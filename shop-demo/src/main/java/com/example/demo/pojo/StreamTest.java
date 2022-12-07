package com.example.demo.pojo;

import pojo.Test;

/**
 * yzw
 * 2022/11/26
 * 流式编程
 */
public class StreamTest {
    static int[] nums = new int[]{0, 1, 2, 9, 5, 7, 6,2};

    public static void main(String[] args) {
//        List list = Arrays.asList(nums);
//        list.stream().sorted(Comparator.comparing(Integer ::intValue)).collect(Collectors.toList());
////        list.stream().forEach(System.out ::println);
//        System.out.println(list.get(0));
//        IntStream stream = Arrays.stream(nums)
//                .distinct()//去重
//                .limit(6)
//                .sorted(Comparator.comparing(Integer::intValue).reversed())
//                .collect(Collectors.toList())
//                .filter(n->n==2)//过滤
                ;

//        stream.forEach(System.out::println);
//        System.out.println(isPalindrome(0));
//        try {
//            //创建对象的方式
//            //反射派发对象
//            LoginVO loginVO = LoginVO.class.newInstance();
//            loginVO.getName();
//            System.out.println(loginVO.getName());
//            //克隆对象
//            LoginVO login2 = new LoginVO();
//            login2.clone();
//            //反射  构造方法创建
//            LoginVO login3 = LoginVO.class.getConstructor().newInstance();
//            //反射   类的全限定名创建
//            LoginVO login4 = (LoginVO) Class.forName("com.example.demo.pojo.LoginVO").newInstance();
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        final String s = "66";
//        System.out.println(s);
//        String s1 ="66a";
//        System.out.println(s1);
//        String s2 = s+"a";
//        System.out.println(s2);
//        System.out.println(s1==s2);
//        System.out.println(s1.equals(s2));
            Test t = new Test("haha");
            Test t1 = new Test("haha");
            String s = "haha";
            String s1 = new String("haha");
            String s2 = s1;
        System.out.println(t1.equals(t));
        System.out.println(s.equals(s1));
        System.out.println(s.equals(s2));
        System.out.println(s1.equals(s2));


    }
    public static boolean isPalindrome(int x) {
        //如果是负数或者整数则不是回文数
        if(x<0 || x%10 == 0) return false;
        int temp = 0;
        while(x>temp){
            //临时数通过x求余反转
            temp = temp*10+x%10;
            //原数不断去掉最后一位
            x/=10;

        }
        //位数为偶数     位数为奇数
        return x==temp || x == temp/10;
    }
}