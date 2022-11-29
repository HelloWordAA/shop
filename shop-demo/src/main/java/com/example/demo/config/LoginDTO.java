package com.example.demo.config;

import lombok.Data;

/**
 * yzw
 * 2022/11/29
 */
@Data
public class LoginDTO {
    /**
     * 用户名称
     */

    private String name;
    /**
     * 密码
     */

    private String password;
//
//    /**
//     * 邮箱
//     */
//    @TableField(value = "email")
//    private String email;
//
//    /**
//     * 手机号
//     */
//    @TableField(value = "phone")
//    private String phone;
//
//    /**
//     * 性别（0-男  ： 1-女）
//     */
//    @TableField(value = "gender")
//    private Integer gender;


}
