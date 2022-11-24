package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.TUser;

import java.util.List;

/**
 * yzw
 * 2022/11/22
 */
public interface TUserMapper extends BaseMapper<TUser> {
    List<TUser> selectList();

    TUser selectByName(String name);
}