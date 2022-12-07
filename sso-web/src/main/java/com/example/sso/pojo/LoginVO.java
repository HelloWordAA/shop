package com.example.sso.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * yzw
 * 2022/12/7
 * 登录实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {
    private String username;
    private String password;
    /**
     * 验证码
     */
    private String captcha;

}
