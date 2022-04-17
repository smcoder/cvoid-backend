package org.smcoder.cvoid.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.smcoder.cvoid.config.HttpAPIService;
import org.smcoder.cvoid.dao.NewsDao;
import org.smcoder.cvoid.dao.RegionDao;
import org.smcoder.cvoid.dao.SmCountDao;
import org.smcoder.cvoid.domain.News;
import org.smcoder.cvoid.domain.Region;
import org.smcoder.cvoid.domain.SmCount;
import org.smcoder.cvoid.example.RegionExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class SpiderController {

    @Resource
    private HttpAPIService httpAPIService;

    @Resource
    private RegionDao regionDao;

    @Resource
    private SmCountDao countDao;

    @Resource
    private NewsDao newsDao;

    @RequestMapping("/spider/province")
    @ResponseBody
    public String province() throws Exception {
        Map<String, Set<String>> regionMap = new HashMap<>();
        String result = httpAPIService.doGet("https://c.m.163.com/ug/api/wuhan/app/data/list-total");
        JSONObject object = JSON.parseObject(result);
        if (object.getInteger("code").equals(10000)) {
            JSONArray array = object.getJSONObject("data").getJSONArray("areaTree");
            for (int index = 0; index < array.size(); index++) {
                JSONObject item = array.getJSONObject(index);
                if (!item.getString("name").equals("中国")) {
                    continue;
                }
                JSONArray sumList = item.getJSONArray("children");
                for (int tindex = 0; tindex < sumList.size(); tindex++) {
                    JSONObject province = sumList.getJSONObject(tindex);
                    if (!regionMap.containsKey(province.getString("name"))) {
                        regionMap.put(province.getString("name"), new HashSet<>());
                    }

                    JSONObject totalObject = province.getJSONObject("total");
                    // 确诊
                    int total = totalObject.getInteger("confirm");
                    // 治愈
                    int heal = totalObject.getInteger("heal");
                    // 死亡
                    int dead = totalObject.getInteger("dead");
                    // 疑似
                    int suspect = totalObject.getInteger("suspect");

                    // 地区
                    String provinceName = province.getString("name");

                    SmCount smCount = new SmCount();
                    smCount.setSumCount(total);
                    smCount.setGoodCount(heal);
                    smCount.setDeathCount(dead);
                    smCount.setNewAdd(suspect);

//                    RegionExample example = new RegionExample();
//                    example.createCriteria().andProvinceEqualTo(provinceName);
//                    List<Region> regions = regionDao.selectByExample(example);
                    smCount.setAddressId(provinceName);
                    countDao.insertSelective(smCount);

                    JSONArray cityArray = province.getJSONArray("children");
                    for (int cindex = 0; cindex < cityArray.size(); cindex++) {
                        JSONObject city = cityArray.getJSONObject(cindex);
                        if (city.getString("name").equals("未明确地区")) {
                            continue;
                        } else {
                            if (!regionMap.get(provinceName).contains(city.getString("name"))) {
                                regionMap.get(provinceName).add(city.getString("name"));
                            }
                        }
                    }

                }
            }
        }

        if (null != regionMap) {
            for (Map.Entry<String, Set<String>> regionEntry : regionMap.entrySet()) {
                Set<String> cityList = regionEntry.getValue();
                for (String cityName : cityList) {
                    Region region = new Region();
                    region.setProvince(regionEntry.getKey());
                    region.setCity(cityName);
                    regionDao.insertSelective(region);
                }
            }
        }
        return "success";
    }

    @RequestMapping("/spider/news")
    @ResponseBody
    public String news() throws Exception {
        List<Region> regionList = regionDao.selectByExample(new RegionExample());
        if (null != regionList && regionList.size() > 0) {
            for (Region region : regionList) {
                String key = region.getProvince() + region.getCity();
                String result = httpAPIService.doGet("https://opendata.baidu.com/data/inner?tn=reserved_all_res_tn&dspName=iphone&from_sf=1&dsp=iphone&resource_id=28565&alr=1&query=" + key + "新型肺炎最新动态");
                JSONObject resultObject = JSON.parseObject(result);
                if (null == resultObject.getJSONArray("Result") || resultObject.getJSONArray("Result").size() < 1) {
                    continue;
                }
                JSONArray itemArray = resultObject.getJSONArray("Result").getJSONObject(0).getJSONArray("items_v2");
                JSONArray newsArray = itemArray.getJSONObject(0).getJSONObject("aladdin_res").getJSONObject("DisplayData").getJSONObject("result").getJSONArray("items");

                for (int i = 0; i < newsArray.size(); i++) {
                    JSONObject tempObject = newsArray.getJSONObject(i);
                    // 新闻标题-需要解码
                    String title = tempObject.getString("eventDescription");
                    // 发布日期
                    String date = tempObject.getString("eventTime");
                    // 新闻URL
                    String sourceUrl = tempObject.getString("eventUrl");
                    // 来源-需要解码
                    String sourceName = tempObject.getString("siteName");

                    News news = new News();
                    news.setContent(sourceUrl);
                    news.setTitle(title);
                    news.setPublishTime(convertTime(date));
                    news.setAddressId(region.getProvince());
                    newsDao.insertSelective(news);
                }
            }
        }
        return "success";
    }

    private String unicodeToString(String str) {
        int start = 0;
        int end = 0;
        StringBuilder buffer = new StringBuilder();
        while (start > -1) {
            end = str.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = str.substring(start + 2, str.length());
            } else {
                charStr = str.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(Character.toString(letter));
            start = end;
        }
        return buffer.toString();
    }

    private String convertTime(String str) {
        Long dateLong = Long.valueOf(str);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(dateLong * 1000));
    }
}
