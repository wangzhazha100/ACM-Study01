package com;

public class test05 {

    public static void main(String[] args) {
        System.out.println(jumpFloor1(7));
        System.out.println(jumpFloor2(7));
    }

    /***
     * 跳到第n个台阶，只有两种可能
     * 从第n-1个台阶跳1个台阶
     * 从第n-2个台阶跳2个台阶
     * 只需求出跳到第n-1个台阶和第n-2个台阶的可能跳法即可
     * F（n）:n个台阶的跳法
     * 递推公式：F（n）=F（n-1）+F（n-2）
     * 不难发现这是一个斐波那契数列
     * 起始条件为F（0）=1，F（1）=1
     * 解法一：自底向上，使用迭代          动态规划
     * @param target
     * @return
     */
    public static int jumpFloor1(int target) {
        if(target==0)  //F(0)=0
            return 1;
        if(target==1)  //F(1)=1
            return 1;
        int si_1=1;    //F(n-1)=1
        int si_2=1;    //F(n-2)=1
        int result=0;
        for(int i=2;i<=target;i++){
            result=si_1+si_2;  //F（n）=F（n-1）+F（n-2）  F（2）=F（1）+F（0）  F（3）=F（2）+F（1）
            si_2=si_1;
            si_1=result;
        }
        return result;
    }

    /***
     * 自顶向下，使用              递归
     * @param target
     * @return
     */

    public static int jumpFloor2(int target) {
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        return jumpFloor2(target-1)+jumpFloor2(target-2);
    }
}
