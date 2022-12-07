package com.example.sso.controller;


import com.example.sso.pojo.LoginVO;
import com.example.sso.service.IUserService;
import com.example.sso.service.RedisService;
import com.example.sso.util.VerifyCodeUtil;
import enumEntity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.ResultBean;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * yzw
 * 2022/11/22
 * 登录
 */
@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private IUserService userServiceImpl;
    @Autowired
    private RedisService redisServiceImpl;

    @RequestMapping("test")
    @ResponseBody
    public String test(){
//        List<TUser> list = userServiceImpl.getUsers();
//        User user = userServiceImpl.getUser(100);
//        System.out.println(user.getId());

        return "list.toString()";
    }

    @RequestMapping("gotoLogin")
    public String gotoLogin(HttpServletRequest request, Model model) {
        String referer = request.getHeader("Referer");
        model.addAttribute("referer",referer);
        return "login";
    }

    /**
     * 获取验证码
     * @param request
     * @param response
     */
    @GetMapping("getCaptcha")
    public void getCaptcha(HttpServletRequest request,HttpServletResponse response){
//        String key = "KAPTCHA_CODE_KEY"+ UUID.randomUUID();
        String key = request.getRemoteAddr();//获取用户ip用于redis的key
        System.out.println("用户ip为："+key);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            String code = VerifyCodeUtil.outputVerifyImage(120, 50, outputStream, 4);
            //验证码存入redis
            redisServiceImpl.set(key,code,30);

            /**
             * Cache-Control指定请求和响应遵循的缓存机制
             * no-store:用于防止重要的信息被无意的发布。在请求消息中发送将使得请求和响应消息都不使用缓存。
             * no-cache:指示请求或响应消息不能缓存
             */
//            response.setHeader("Cache-Control","no-store,no-cache");
//            // 设置输出流内容格式为图片格式.image/jpeg,图片格式用于生成图片随机码
//            response.setContentType("image/jpeg");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream == null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @RequestMapping("login")
    @CrossOrigin(origins = "*")
    public ResultBean login(@RequestBody LoginVO user,
                            String referer,
                            HttpServletRequest request,
                            HttpServletResponse response){
        //TODO 验证码校验
        if (user.getCaptcha() ==null ||user.getCaptcha().equals("")) {
            return ResultBean.fail(ResultCode.PAPAM_IS_BLANK);
        }
        //获取ip地址，因为ip地址作为redis存储验证码的key
        String captchaKey = request.getLocalAddr();
        //判断验证码是否过期
        Long expire = redisServiceImpl.getExpire(captchaKey);
        if (expire<0){
            return ResultBean.fail(ResultCode.PAPAM_IS_INVALID);
        }
        //根据key读取验证码
        String captchaValue = redisServiceImpl.get(captchaKey).toString();
        //验证码超时
        if (!captchaValue.equals(user.getCaptcha())){
            return ResultBean.fail(ResultCode.PAPAM_IS_INVALID);
        }
        //TODO 账号密码校验
        System.out.println("开始登陆:"+user.getUsername());
        ResultBean resultBean = userServiceImpl.login(user);
        if ("200".equals(resultBean.getCode())){
            Cookie cookie = new Cookie("userToken",resultBean.getData().toString());
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            //有效时长一小时  单位/秒  SECONDS
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
            return new ResultBean(ResultCode.SUCCESS,resultBean.getData());
//            if (referer ==null || "".equals(referer)){
//                return "redirect:http://localhost:9999/index";
//            }
//            return referer;
        }
        //登录失败
        return ResultBean.fail(ResultCode.USER_LOGIN_ERROR);
    }
}
