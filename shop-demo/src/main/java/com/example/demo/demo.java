package com.example.demo;

import com.example.demo.service.IUserService;
import com.example.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * yzw
 * 2022/11/22
 */
@RestController
@RequestMapping("/test")
public class demo {
    @Autowired
    private IUserService userServiceImpl;

    @RequestMapping("test")
    public String test(){
        List<TUser> list = userServiceImpl.getUsers();
//        User user = userServiceImpl.getUser(100);
//        System.out.println(user.getId());

        return list.toString();
    }

//    @RequestMapping("update")
//    public String test(@RequestBody TUser user){
//        System.out.println("进入修改方法："+user.getName());
////        User user = userServiceImpl.getUser(100);
////        System.out.println(user.getId());
//        userServiceImpl.updateUser(user);
//        return "修改成功";
//    }
//    @RequestMapping("isnert")
//    public void insert(@RequestBody TUser user){
//        System.out.println("添加:"+user.getName());
//        userServiceImpl.insert(user);
//    }
//    @RequestMapping("delete")
//    public void deleteById(@RequestBody TUser user){
//        System.out.println("进入删除方法:"+user.getName());
//        userServiceImpl.deleteById(user.getId());
//    }
}
