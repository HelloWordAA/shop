package com.example.demo.service;


import com.example.demo.Task.MyAsyncTask;
import com.example.demo.config.LoginDTO;
import com.example.entity.TUser;
import com.example.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * yzw
 * 2022/11/22
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private MyAsyncTask myAsyncTask;



//    @Override
//    public TUser getUser(int id) {
//        return userMapper.selectById(id);
//    }

//    @Override
//    public void updateUser(TUser user) {
//        userMapper.updateById(user);
//    }
//
//    @Override
//    public void insert(TUser user) {
//        userMapper.insert(user);
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        userMapper.deleteById(id);
//    }

    @Override
    public List<TUser> getUsers() {
        return userMapper.selectList();
    }

//    @Override
//    public String login(TUser user) {
//        return "login成功";
//    }

    @Override
    public ResultBean login(LoginDTO user) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("service："+user.getName());
        Future<String> stringFuture = myAsyncTask.myTask();
        try {
            System.out.println("获取异步信息："+stringFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        TUser currentUser = userMapper.selectByName(user.getName());
        if (currentUser!=null){
            if (currentUser.getPassword().equals(user.getPassword())){
                //TODO    获取用户信息
                //TODO    用JWT生成token
                //TODO     将token存入redis中
                //TODO     返回redis的key  username:UUID
                System.out.println("成功");
                return new ResultBean("200","username:UUID");

            }
            System.out.println("失敗1");
            return new ResultBean("400","账号或密码错误");
        }
        System.out.println("失敗1");
        return new ResultBean("400","账号或密码错误");
    }


}
