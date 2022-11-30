package com.example.demo.service;

import com.example.demo.config.LoginDTO;
import com.example.entity.TUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pojo.ResultBean;

import java.util.List;

/**
 * yzw
 * 2022/11/25
 */
public interface UserService {
    @RequestMapping(value = "/home/test" ,method = RequestMethod.GET)
    List<TUser> getUsers();
//        @RequestMapping(value = "/home/login",method = RequestMethod.POST)
//        String login(TUser user);

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
        //@RequestBody不写可以默认
    ResultBean login(@RequestBody LoginDTO user);
}
