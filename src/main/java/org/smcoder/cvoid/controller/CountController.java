package org.smcoder.cvoid.controller;

import org.smcoder.cvoid.dao.RegionDao;
import org.smcoder.cvoid.dao.SmCountDao;
import org.smcoder.cvoid.domain.SmCount;
import org.smcoder.cvoid.domain.SmUser;
import org.smcoder.cvoid.example.SmCountExample;
import org.smcoder.cvoid.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class CountController {

    @Resource
    private SmCountDao countDao;

    @RequestMapping("count/info")
    @ResponseBody
    public Response countInfo(@RequestBody SmCount count, HttpSession session) {
        SmUser user = (SmUser) session.getAttribute("user");
        SmCountExample countExample = new SmCountExample();
        countExample.createCriteria().andAddressIdEqualTo(StringUtils.isEmpty(count.getAddressId()) ? user.getAddressId() : count.getAddressId());
        count = countDao.selectByExample(countExample);
        if (null != count) {
            return new Response(1, count);
        }
        return new Response(-1, "暂无数据");
    }
}
