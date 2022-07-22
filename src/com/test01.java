package com;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

/***
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * 输出描述:
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * 示例1
 * 输入
 * 0xAA
 * 输出
 * 170
 */
public class test01 {
    /***
     *方法一：用java自带方法
     *去除前两位0x，使用ASCII表对字母进行转化为数字，利用Math.pow(16,i)计算16为底i的次方
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            StringBuffer sb=new StringBuffer();
            sb.append(sc.next());
            //String str=sc.next();
            String str=sb.reverse().substring(0,sb.length()-2);//AAx0 -> AA
            char ch[]=str.toCharArray();
            int sum=0;
            for(int i=0;i<ch.length;i++){
                if(ch[i]>='A'&&ch[i]<='F'){
                    System.out.println(Integer.valueOf(ch[i]));
                    sum+=(Integer.valueOf(ch[i])-55)*Math.pow(16,i);//Math.pow(16,i)：16为底数的i次方 A:65-55=10
                }else {
                    System.out.println(Integer.valueOf(ch[i]));
                    sum+=(Integer.valueOf(ch[i])-48)*Math.pow(16,i);// 0:48-48=0
                }
            }
            System.out.println(sum);
            // System.out.println(Integer.valueOf('6'));
        }
    }

    /***
     *方法二：用java自带方法
     *去除前两位0x，使用Integer.parseInt(str,16)进行直接转化
     */
    public static void function2() {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next().substring(2);//去除0X
            System.out.println(Integer.parseInt(str,16));//直接把十六进制str转换成int
        }
    }

}
