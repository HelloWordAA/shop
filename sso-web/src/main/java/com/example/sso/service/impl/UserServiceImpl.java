package com.example.sso.service.impl;

import com.example.entity.TUser;
import com.example.mapper.TUserMapper;
import com.example.sso.pojo.LoginVO;
import com.example.sso.service.IUserService;
import com.example.sso.service.RedisService;
import com.example.sso.util.JwtTokenUtil;
import enumEntity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.ResultBean;

import java.util.UUID;

/**
 * yzw
 * 2022/12/7
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private RedisService redisServiceImpl;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResultBean login(LoginVO user) {
        //TODO  验证账号密码
        String username = user.getUsername();
        TUser tUser = userMapper.selectByName(username);
        String redisKey = tUser.getId()+ UUID.randomUUID().toString();
        if (tUser.getPassword().equals(user.getPassword())){
            //TODO  生成token    token生成：userid+时间戳+服务秘钥
            String token = jwtTokenUtil.generateToken(tUser);
            //TODO  将token存入redis中  单位/S  SECONDS
            redisServiceImpl.set(redisKey,token,60*60);
            return ResultBean.create(ResultCode.SUCCESS,redisKey);
        }
        return ResultBean.fail(ResultCode.USER_NOT_EXIST);
    }

//    @Override
//    public IBaseDao<TUser> getBaseDao() {
//        return userMapper;
//    }
}
