package com;

import java.util.Scanner;

/***
 * 问题：明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 * 输入：
 * 3
 * 2
 * 2
 * 1
 * 输出：
 * 1
 * 2
 * 方法：把输入的数字i放入另一个数组的第i位并赋值为1，之后遍历数组为1的提出i
 */
public class test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int length =Integer.parseInt(sc.next());//输入几个数 4
            int [] number = new int[length];
            for (int i = 0; i < length; i++) {
                number[i] = Integer.parseInt(sc.next());//输入数据 3 2 2 1
            }
            int [] a =quchong(number);
            for (int i = 0; i < 1000; i++) { //把值为1的i打印出来
                if(a[i] == 1)
                    System.out.println(i);
            }

        }
    }

    private static int[] quchong(int[] number) {
        int [] b = new int[1000];
        for (int i = 0; i < 1000; i++) { //把b数组全赋值为0
            b[i] = 0;
        }
        for (int i = 0; i < number.length; i++) { //把数组b的第[3,2,2,1]位赋值为1
            b[number[i]]=1;
        }
        return b;//结果b[0,1,1,1,0,0,……]其中值为1的i就为对应的结果
    }
}
