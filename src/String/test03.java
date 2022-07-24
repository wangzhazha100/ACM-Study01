package String;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/***
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 */
public class test03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            char []c = s.toCharArray();//把输入字符转化为char数组
            HashMap<Character,Integer> hashMap = new HashMap<>();//用来存放各个字符和对应的字符数量
            for (char i : c){
                hashMap.put(i , (hashMap.getOrDefault(i , 0) + 1));//计算各个字符的数量
            }

            //得出最小次数
            Collection<Integer> collation = hashMap.values();//取出所有对应字符数量
            Integer min = Collections.min(collation);//得出最小数量

            for (Character character : hashMap.keySet()){//取出所有字符
                if(hashMap.get(character) == min){//如果该字符数量为最小数量值
                    s = s.replaceAll(String.valueOf(character) , "");//替换该字符为空
                }
            }
            System.out.println(s);

        }
    }

}
