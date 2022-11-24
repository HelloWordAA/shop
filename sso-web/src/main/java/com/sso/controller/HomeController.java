package com.sso.controller;

import com.example.demo.service.IUserService;
import com.example.demo.service.ResultBean;
import com.example.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * yzw
 * 2022/11/22
 */
@RestController
@RequestMapping("home")
public class HomeController {
    @Autowired
    private IUserService userServiceImpl;

    @RequestMapping("test")
    public String test(){
        List<TUser> list = userServiceImpl.getUsers();
//        User user = userServiceImpl.getUser(100);
//        System.out.println(user.getId());

        return list.toString();
    }

    @RequestMapping("gotoLogin")
    public String gotoLogin(HttpServletRequest request, Model model) {
        String referer = request.getHeader("Referer");
        model.addAttribute("referer",referer);
        return "login";
    }

    @RequestMapping("login")
    public ResultBean login(@RequestBody TUser user,
                            String referer,
                            HttpServletRequest request,
                            HttpServletResponse response){
        System.out.println("开始登陆:"+user.getName());
        ResultBean resultBean = userServiceImpl.login(user);
        if ("200".equals(resultBean.getData())){
            Cookie cookie = new Cookie("user:token",resultBean.getData().toString());
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return new ResultBean("200","登陆成功");
        }
        return new ResultBean("400","登录失败");
    }
}
