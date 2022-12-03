package com.sso.controller;

import com.example.demo.pojo.LoginVO;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.ResultBean;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * yzw
 * 2022/11/22
 */
@RestController
@RequestMapping("home")
public class HomeController {
    @Autowired
    private IUserService userService;

    @RequestMapping("test")
    @ResponseBody
    public String test(){
//        List<TUser> list = userServiceImpl.getUsers();
//        User user = userServiceImpl.getUser(100);
//        System.out.println(user.getId());

        return "list.toString()";
    }

    @RequestMapping("gotoLogin")
    public String gotoLogin(HttpServletRequest request, Model model) {
        String referer = request.getHeader("Referer");
        model.addAttribute("referer",referer);
        return "login";
    }

    @RequestMapping("login")
    @CrossOrigin(origins = "*")
    public ResultBean login(@RequestBody LoginVO user,
                            String referer,
                            HttpServletRequest request,
                            HttpServletResponse response){
//        response.addHeader("Access-Control-Allow-Origin","*");
        System.out.println("开始登陆:"+user.getName());
        ResultBean resultBean = userService.login(user);
        if ("200".equals(resultBean.getStatusCode())){
            Cookie cookie = new Cookie("userToken",resultBean.getData().toString());
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(1000*60);
            response.addCookie(cookie);
            return new ResultBean("200",resultBean.getData());
//            if (referer ==null || "".equals(referer)){
//                return "redirect:http://localhost:9999/index";
//            }
//            return referer;
        }
//        return "reg";
        return new ResultBean("400","失敗");
    }
}
