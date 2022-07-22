package com;

import java.util.HashSet;
import java.util.Scanner;

/***
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 * 方法：利用HashSet不存放重复值原理
 */
public class test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String S = sc.nextLine();
            char []C = S.toCharArray();
            HashSet<Character> hashSet = new HashSet<>();
            for (int i = 0; i < C.length; i++) { //利用HashSet不存放重复值原理
                hashSet.add(C[i]);
            }
            System.out.println(hashSet.size());
        }
    }
}
