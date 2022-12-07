package com.example.demo.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA密钥对生成：http://web.chacuo.net/netrsakeypair
 * 在线加密解密：在线加密解密 - chahuo.com
 */
public class RSAUtil {
    private static final String CHARSET_NAME = "utf-8";
    private static final String TYPE = "RSA";

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(TYPE).generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance(TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes(CHARSET_NAME)));
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes(CHARSET_NAME));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(TYPE).generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance(TYPE);
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    public static void main(String[] args) throws Exception {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKalqxfHXrZ0JZdLd2+BLhNS6bZxVyCOXvzFd0xCyX4oX/IbglKp9BGxQYaNl7stlHkQmMYBTAkIj0mAQzOVkqisYDevxKA5Yeitnim8R+N+a1SYaoQCfHLbCmMg4ZP0xaC30rA3DSMbEWQTD7p/g6v3sZevQUDVUcge9oaif9AQIDAQAB";
        String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMpqWrF8detnQll0t3b4EuE1LptnFXII5e/MV3TELJfihf8huCUqn0EbFBho2Xuy2UeRCYxgFMCQiPSYBDM5WSqKxgN6/EoDlh6K2eKbxH435rVJhqhAJ8ctsKYyDhk/TFoLfSsDcNIxsRZBMPun+Dq/exl69BQNVRyB72hqJ/0BAgMBAAECgYEAwOZKOArcddKaMJZCoWYY1/bOy9qZXWuNddHPJsAtnzGJcXK5AvJzgqBDrl99o5z15HYcG2MVY85aNn8IwahNh8CpFF8At7O2hVz1sTER2MPeiV5324BGOCPUkT4lY2iT2Dq6hXraZDI9sovit4FnfFlWH9nMOV5ckBvm5ypcCoECQQD/YLgSqXEERuu5qjU+PBCBKqbtOq5+EBNwLb9isxTPjRPoQ98sEzWsbyeLrc73Cjql5vU1io9rsG3IiYdEvFn9AkEAyuiaK95pbILOqK096d3Gt9oz0fqc5K4c9V44anaFzkEOysZlO3o1iZxqjfHdBlJiE4j0fq52+s+L9riqFbNMVQJATL3V0tXUPoLJZ3u8kD0ggJA+pV9S/FL8ZGN69b/26v/sEYoD0IzdPjoQ2iqa3SXXxe8HlNVUj/nuo6qgWYl4SQJBAJsXsYfoh7JeRXHegV15m8O5sDRGl5efkhjmfL67e0kMpy7M+GG+5p8ZhMScYzHK1JZT73XJCr5o13Ws7qyJkMUCQQD2EaVPOG+5M0VbzGGG820NRk9omSwO3GdSf4HZ6JWmeGk0FJN4NfAHnD8nA5L/HP+muqCdYQtYD068oZrNSabP";
        String text = "hello";
        String encodeText = encrypt(text, publicKey);
        System.out.println("加密后：" + encodeText);
        System.out.println("解密后：" + decrypt(encodeText, privateKey));
    }
}