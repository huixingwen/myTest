package com.darunfa;

import java.sql.SQLOutput;

/**
 * @创建人 wenxinghui
 * @创建时间 2019/9/20 16:01
 * @描述 单例设计模式
 */
public class StringTest {

//    //加volatile是禁止指令重排,防止创建对象的时候,先变量指向对象,后初始化对象
//    private static volatile StringTest instance = null;
//
//    private StringTest() {
//    }
//
//    public static StringTest getInstance(){
//        if (instance == null) {
//            synchronized (StringTest.class) {
//                if (instance == null) {
//                    instance = new StringTest();
//                }
//            }
//        }
//        return instance;
//    }

    public static void main(String[] args) {
//        String s = new String("1");//生成了常量池中的“1” 和堆空间中的字符串对象s
//        String s2 = "1";//生成一个s2的引用指向常量池中的“1”对象，已经存在，直接指向它。
//        s.intern();//这一行无实际作用。因为"1"已经存在了。
//        System.out.println(s == s2); //s 和 s2 的引用地址不同。因此返回了false
//
//        String s3 = new String("1") + new String("1");////在字符串常量池中生成“1” ，并在堆空间中生成s3引用指向的对象（内容为"11"）。注意此时常量池中是没有 “11”对象的
//        String s4 = "11";//直接去生成常量池中的"11"
//        s3.intern();//这一行无实际作用。因为"1"已经存在了。
//        System.out.println(s3 == s4);//s3 和 s4 的引用地址不同。因此返回了false

//        System.out.println(sun.misc.VM.maxDirectMemory() / 1024 / 1024 + "MB");

        String str1 = "计算机";
        String str2 = "计算机";
        System.out.println("str1==str2:" + (str1 == str2));

        String str3 = new String("计算机");
        System.out.println("str1==str3:" + (str1 == str3));
        System.out.println("str1==str3.intern():" + (str1 == str3.intern()));
        System.out.println("str2==str3.intern():" + (str2 == str3.intern()));

        String str4 = new String("计算机");
        System.out.println("str3==str4:" + (str3 == str4));
        System.out.println("str3.intern()==str4.intern():" + (str3.intern() == str4.intern()));


        String str5 = new StringBuilder("软件").append("工程").toString();
        System.out.println("str5.intern() == str5:" + (str5.intern() == str5));

        String str6 = new String(new StringBuilder("物联网").append("工程").toString());
        System.out.println("str6.intern() == str6:" + (str6.intern() == str6));

        String str7 = new String("物联网");
        System.out.println("str7.intern() == str7:" + (str7.intern() == str7));
    }


}
