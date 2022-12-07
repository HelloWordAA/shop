package com.example.demo.util;

import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**
     * java自带jar工具 java.security.MessageDigest 实现
     *
     * @param text  要加密的字符串
     * @param rad   进制：比如 16、32
     * @param isUpp 是否转换为大写
     * @return
     */
    public static String strToMD5(String text, int rad, boolean isUpp) {
        MessageDigest messageDigest = null;
        try {
            //通过MessageDigest类来的静态方法getInstance获取MessageDigest对象
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 4、获取明文字符串对应的字节数组
        byte[] input = text.getBytes();
        // 5、执行加密
        messageDigest.update(input);
        //这里也可以直接使用byte[] output = messageDigest.digest(input)方法来进行加密，就省略了上面的update方法了
        byte[] output = messageDigest.digest();
        // 6、创建BigInteger对象
        // signum为1表示正数、-1表示负数、0表示0。不写默认表示正数
        int signum = 1;
        BigInteger bigInteger = new BigInteger(signum, output);
        // 7、按照16进制(或32进制)将bigInteger转为字符串
        return isUpp ? bigInteger.toString(rad).toUpperCase() : bigInteger.toString(rad);
    }

    /**
     * spring自带的工具 org.springframework.util.DigestUtils 实现
     * @param text
     * @return 16进制
     */
    public static String _strToMD5(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }

    public static void main(String[] args) {
        String str = "hello";
        System.out.println(strToMD5(str, 16, true));
        System.out.println(_strToMD5(str));
        System.out.println(strToMD5(str, 16, false).equals(_strToMD5(str)));
    }
}