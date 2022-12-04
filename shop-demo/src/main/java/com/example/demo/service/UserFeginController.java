package com.example.demo.service;

import com.example.demo.MyAspect.MyLog;
import com.example.demo.pojo.LoginVO;
import com.example.entity.TUser;
import enumEntity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.ResultBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * yzw
 * 2022/11/22
 */
@RestController
@RequestMapping("user")
public class UserFeginController {
    @Autowired
//    @Qualifier("userServiceImpl")
    private UserService userServiceImpl;

    @RequestMapping("test")
    public String test(){
        List<TUser> list = userServiceImpl.getUsers();
//        User user = userServiceImpl.getUser(100);
//        System.out.println(user.getId());

        return list.toString();
    }
    @RequestMapping("login")
    @MyLog(desc = "开始登陆")
    public ResultBean login(@RequestBody LoginVO user,
                             String referer,
                             HttpServletRequest request,
                             HttpServletResponse response){
        System.out.println("开始登陆:"+user.getName());
        ResultBean resultBean = userServiceImpl.login(user);
        System.out.println("返回"+resultBean.getData());
        if ("200".equals(resultBean.getCode())){

//            Cookie cookie = new Cookie("user:token",resultBean.getData().toString());
//            cookie.setPath("/");
//            cookie.setHttpOnly(true);
//            response.addCookie(cookie);
            System.out.println("成功:"+user.getName());
            return new ResultBean(ResultCode.SUCCESS,resultBean.getData());
        }

        return new ResultBean(ResultCode.USER_LOGIN_ERROR);
//        throw new UserException();
    }
}
