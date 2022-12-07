package com.example.sso.service;

import base.IBaseService;
import com.example.entity.TUser;
import com.example.sso.pojo.LoginVO;
import pojo.ResultBean;

/**
 * yzw
 * 2022/12/7
 */
public interface IUserService extends IBaseService<TUser> {
    ResultBean login(LoginVO user);
}
