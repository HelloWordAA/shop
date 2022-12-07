package com.example.demo.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * DES加解密
 */
public class DESUtil {
    public static Key setKey(String strKey) {
        Key key = null;
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(strKey.getBytes())); // 根据参数生成key
            key = generator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }

    /**
     * @param source  编码内容
     * @param key     密钥
     * @param charSet 编码格式
     * @return
     */
    public static String encrypt(String source, String key, String charSet) {
        String encrypt = null;
        try {
            byte[] ret = encrypt(source.getBytes(charSet), key);
            encrypt = new String(Base64.getEncoder().encode(ret));
        } catch (Exception e) {
            e.printStackTrace();
            encrypt = null;
        }
        return encrypt;
    }

    /**
     * @param encryptedData 解码内容
     * @param key           密钥
     * @param charSet       编码格式
     * @return
     */
    public static String decrypt(String encryptedData, String key, String charSet) {
        String descryptedData = null;
        try {
            byte[] ret = descrypt(Base64.getDecoder().decode(encryptedData.getBytes()), key);
            descryptedData = new String(ret, charSet);
        } catch (Exception e) {
            e.printStackTrace();
            descryptedData = null;
        }
        return descryptedData;
    }

    private static byte[] encrypt(byte[] primaryData, String key) {
        Key desKey = setKey(key);
        try {
            Cipher cipher = Cipher.getInstance("DES"); // Cipher对象实际完成加密操作
            cipher.init(Cipher.ENCRYPT_MODE, desKey); // 用密钥初始化Cipher对象(加密)
            return cipher.doFinal(primaryData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] descrypt(byte[] encryptedData, String key) {
        Key desKey = setKey(key);
        try {
            Cipher cipher = Cipher.getInstance("DES"); // Cipher对象实际完成解密操作
            cipher.init(Cipher.DECRYPT_MODE, desKey); // 用密钥初始化Cipher对象(解密)
            return cipher.doFinal(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String code = "hello";
        String key = "thisisakey";
        String unicode = "utf-8";
        String encrypt = encrypt(code, key, unicode);
        String decrypt = decrypt(encrypt, key, unicode);
        System.out.println("原内容：" + code);
        System.out.println("加密：" + encrypt);
        System.out.println("解密：" + decrypt);
    }
}
