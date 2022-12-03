package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * yzw
 * 2022/11/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO implements Cloneable {
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


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
