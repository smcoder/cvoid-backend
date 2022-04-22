package org.smcoder.cvoid.controller;

import com.github.pagehelper.PageHelper;
import org.smcoder.cvoid.dao.RebotDao;
import org.smcoder.cvoid.domain.PageRebot;
import org.smcoder.cvoid.domain.PageUser;
import org.smcoder.cvoid.domain.Rebot;
import org.smcoder.cvoid.domain.SmUser;
import org.smcoder.cvoid.example.RebotExample;
import org.smcoder.cvoid.response.Page;
import org.smcoder.cvoid.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RebotController {


    @Resource
    private RebotDao rebotDao;

    @RequestMapping("suggestion")
    @ResponseBody
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

    @RequestMapping("topic/publish")
    @ResponseBody
    public Response add(@RequestBody Rebot rebot) {
        rebotDao.insertSelective(rebot);
        return new Response(1, "");
    }

    @RequestMapping("topic/delete")
    @ResponseBody
    public Response delete(@RequestBody Rebot rebot) {
        rebotDao.deleteByPrimaryKey(rebot.getId());
        return new Response(1, "");
    }

    @RequestMapping("topic/info")
    @ResponseBody
    public Response edit(@RequestBody Rebot rebot) {
        Rebot dbRebot = rebotDao.selectByPrimaryKey(rebot.getId());
        return new Response(1, dbRebot);
    }

    @RequestMapping("topic/edit")
    @ResponseBody
    public Response update(@RequestBody Rebot rebot) {
        rebotDao.updateByPrimaryKeySelective(rebot);
        return new Response(1, "");
    }

    @RequestMapping("topic/list")
    @ResponseBody
    public Response topicList(@RequestBody PageRebot pageRebot) {
        PageHelper.startPage(pageRebot.getPageNo(), pageRebot.getPageSize());
        List<Rebot> userList = rebotDao.selectList(pageRebot);
        Page page = new Page(userList.size(), userList);
        return new Response(1, page);
    }
}
