package org.smcoder.cvoid.controller;

import com.github.pagehelper.PageHelper;
import org.smcoder.cvoid.dao.SmUserDao;
import org.smcoder.cvoid.domain.PageUser;
import org.smcoder.cvoid.domain.SmUser;
import org.smcoder.cvoid.example.SmUserExample;
import org.smcoder.cvoid.response.Page;
import org.smcoder.cvoid.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Resource
    SmUserDao userDao;

    @RequestMapping("register")
    @ResponseBody
    public Response register(@RequestBody SmUser user) {
        SmUserExample userExample = new SmUserExample();
        userExample.createCriteria().andAccountEqualTo(user.getAccount());
        SmUser smUser = userDao.selectByExample(userExample);
        if (null != smUser) {
            return new Response(-1, "当前账号已被注册，请重试");
        }
        userDao.insertSelective(user);
        return new Response(1, user);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestBody SmUser user, HttpSession session) {
        SmUserExample userExample = new SmUserExample();
        userExample.createCriteria().andAccountEqualTo(user.getAccount()).andPasswordEqualTo(user.getPassword());
        SmUser smUser = userDao.selectByExample(userExample);
        if (null == smUser) {
            return new Response(-1, "当前登录的用户名密码错误，请重试");
        }

        session.setAttribute("user", smUser);
        return new Response(1, smUser);
    }

    @RequestMapping("logout")
    @ResponseBody
    public Response logout(HttpSession session) {
        SmUser user = (SmUser) session.getAttribute("user");
        if (null == user) {
            return new Response(-1, "当前没有登录用户信息");
        }
        return new Response(1, "注销成功");
    }

    @RequestMapping("user/info")
    @ResponseBody
    public Response userInfo(HttpSession session) {
        SmUser user = (SmUser) session.getAttribute("user");
        return new Response(1, user);
    }


    @RequestMapping("user/add")
    @ResponseBody
    public Response userAdd(@RequestBody SmUser user) {
        SmUserExample example = new SmUserExample();
        example.createCriteria().andAccountEqualTo(user.getAccount());
        SmUser dbUser = userDao.selectByExample(example);
        if (null != dbUser) {
            return new Response(-1, "当前账号信息已存在");
        }
        userDao.insertSelective(user);
        return new Response(1, "");
    }

    @RequestMapping("user/edit")
    @ResponseBody
    public Response userEdit(@RequestBody SmUser user) {
        userDao.updateByPrimaryKeySelective(user);
        return new Response(1, "");
    }

    @RequestMapping("user/delete")
    @ResponseBody
    public Response userDelete(@RequestBody SmUser user) {
        userDao.deleteByPrimaryKey(user.getId());
        return new Response(1, "");
    }

    @RequestMapping("user/list")
    @ResponseBody
    public Response userList(@RequestBody PageUser pageUser) {
        PageHelper.startPage(pageUser.getPageNo(), pageUser.getPageSize());
        List<SmUser> userList = userDao.selectList(pageUser);
        Page page = new Page(userList.size(), userList);
        return new Response(1, page);
    }
}
