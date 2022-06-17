package com;

import java.sql.Array;
import java.util.HashMap;
import java.util.Scanner;

/***
 * 两数相加 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * 输入
 * [20,70,110,150],90
 * 输出
 * [1,2]
 * 说明
 * 20+70=90
 */
public class test02 {

    public static void main(String[] args) {
/*        String s = "陈嘉欣是宇宙无敌超级可爱美少女";
        char[] chars = s.toCharArray();
        String returnStr = "";
        for (char aChar : chars) {
            returnStr += "//u" + Integer.toString(aChar, 16);
        }
        System.out.println(returnStr);*/
        int []sum = twoSum();
        for (int s:sum) {
            System.out.println(s);
        }

    }

/*        public static int[] twoSum() {
            int target = 90;
            int[] numbers = {110,20,150,70};
            int n = numbers.length;
            int[] result = new int[2];
            //map里面放 键为target-每个数的结果 值为下标
            //每次放入的时候看是否包含 当前值
            //有的话说明当前值和已包含的值下标的那个元素为需要的结果
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0;i<n;i++){
                if(map.containsKey(numbers[i])){
                    result[0] = map.get(numbers[i])+1;
                    result[1] = i+1;
                    break;
                }
                else{
                    map.put(target - numbers[i], i);
                }
            }
            return result;
        }*/
    public static int[] twoSum(){
        int result[] =new int[2];//结果
        int Target = 90;
        int [] number = {110,20,150,70};
        HashMap<Integer,Integer> map = new HashMap<>();//临时存放target-各个number数组中的值[(-20,0);(70,1);(-60,2);(20,3)]
        for (int i = 0; i < number.length; i++) {
            if (map.containsKey(number[i])) {
                result[0]=map.get(number[i]) + 1;
                result[1] = i + 1;
                break;
            }else {
                map.put(Target - number[i],i); //[(-20,0);(70,1);(-60,2);(20,3)]
            }
        }

        return result;


    }

}
