package com;

import java.lang.reflect.Array;

public class test05 {

    static int []f = new int[50];//默认值为0

    public static void main(String[] args) {
        //System.out.println(jumpFloor1(7));
        //System.out.println(jumpFloor2(7));
        System.out.println(jumpFloor2_1(7));
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
        int si_0=1;    //F(0)=1
        int si_1=1;    //F(1)=1
        int result=0;
        for(int i=2;i<=target;i++){
            result=si_0+si_1;  //F（n）=F（n-1）+F（n-2）  F（2）=F（1）+F（0）  F（3）=F（2）+F（1）
            si_1=si_0;
            si_0=result;
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

    /***
     * 递归2.0，使用数组存储计算值，避免重复计算
     * @param target
     * @return
     */
    public static int jumpFloor2_1(int target){
        if (target <= 1){
            return 1;
        }
        if (f[target] > 0){ //如果数组中存储的有计算结果就直接取值
            return f[target];
        }
        return f[target] = jumpFloor2_1(target - 1) + jumpFloor2_1(target - 2);
    }
}
