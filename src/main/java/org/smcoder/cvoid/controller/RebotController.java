package org.smcoder.cvoid.controller;

import org.smcoder.cvoid.dao.RebotDao;
import org.smcoder.cvoid.domain.Rebot;
import org.smcoder.cvoid.example.RebotExample;
import org.smcoder.cvoid.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RebotController {


    @Resource
    private RebotDao rebotDao;

    @RequestMapping("suggestion")
    public Response suggestion(@RequestBody Rebot rebot) {
        RebotExample example = new RebotExample();
        example.createCriteria().andKeyLike(rebot.getKey());
        List<Rebot> list = rebotDao.selectByExample(example);
        if (null == list || list.size() < 1) {
            list = new ArrayList<>();
            rebot.setContent("暂时没有符合条件的内容呢");
            list.add(rebot);
            return new Response(1, list);
        }

        return new Response(1, list);
    }
}
