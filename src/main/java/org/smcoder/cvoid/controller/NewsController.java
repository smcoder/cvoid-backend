package org.smcoder.cvoid.controller;

import org.smcoder.cvoid.dao.NewsDao;
import org.smcoder.cvoid.domain.News;
import org.smcoder.cvoid.domain.SmUser;
import org.smcoder.cvoid.example.NewsExample;
import org.smcoder.cvoid.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class NewsController {

    @Resource
    NewsDao newsDao;

    @RequestMapping("news/list")
    @ResponseBody
    public Response list(@RequestBody News news, HttpSession session) {
        SmUser user = (SmUser) session.getAttribute("user");
        NewsExample example = new NewsExample();
        example.createCriteria().andAddressIdEqualTo(StringUtils.isEmpty(news.getAddressId()) ? user.getAddressId() : news.getAddressId());
        List<News> newsList = newsDao.selectByExample(example);

        if (null == newsList || newsList.size() < 1) {
            return new Response(-1, "暂无数据");
        }
        return new Response<>(1, newsList);
    }
}
