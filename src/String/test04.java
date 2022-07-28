package String;

import java.util.Scanner;

/***
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * 00001010000000000000001111000001
 *
 * 数据范围：保证输入的是合法的 IP 序列
 *
 * 输入描述：
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * 示例1
 * 输入：
 * 10.0.3.193
 * 167969729
 * 复制
 * 输出：
 * 167773121
 * 10.3.3.193
 */
public class test04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.contains(".")){
                //ip2num(s);
                ip2num_2(s);
            }else {
                //num2ip(s);
                num2ip_2(s);
            }
        }
    }

    public static void ip2num(String s) {
        String[] SA = s.split("\\."); //10.0.3.193
        int[] integer = new int[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SA.length; i++) {
            integer[i] = Integer.parseInt(SA[i]);//10
            String s1 = Integer.toBinaryString(integer[i]);//把十进制转化为二进制 1010
            while (s1.length() < 8) {
                s1 = "0" + s1; //00001010
            }
            sb.append(s1);
        }
        System.out.println(Long.parseLong(sb.toString(), 2));//把二进制sb = 00001010 00000000 00000011 11000001 转化为 十进制167969729
    }
    public static void ip2num_2(String s){
        String[] SA = s.split("\\.");
        Long num = (long)0;
        for (int i = 0; i < 4; i++) {
            //num = num * 2 +Long.parseLong(SA[i]);'
            num = num * 256 +Long.parseLong(SA[i]);
        }
        System.out.println(num);
    }


    public static void num2ip(String s) {
        String num = Long.toBinaryString(Long.parseLong(s)); //把167969729转为二进制String类
        while (num.length() < 32) { //填充0 为 00001010 00000011 00000011 11000001
            num = "0" + num;
        }
        String[] ans = new String[4];
        for (int i = 0; i < 4; i++) {
            String s1 = num.substring(8 * i, 8 * i + 8);//00001010
            s = Integer.toString(Integer.parseInt(s1, 2));//把二进制转化为十进制 10
            ans[i] = s;
        }
        System.out.println(String.join(".", ans));
    }

    public static void num2ip_2(String s){
        Long s1 = Long.parseLong(s);
        String[] ip = new String[4];
        for (int i = 3; i >= 0; i--) {
            ip[i] = Long.toString(s1 % 265);
            s1 = s1 / 256;
        }
            System.out.print(String.join(".",ip ));


    }

}