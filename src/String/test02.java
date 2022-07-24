package String;

import java.util.Scanner;

/***密码校验
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）(例：021Abc9Abc1 ,Abc重复长度超过2个）
 *
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * OK
 * NG
 * NG
 * OK
 */
public class test02 {

    public static boolean checkLength(String password){
        if (password == null || password.length() <= 8)
            return false;
        return true;
    }
    // 2.包括大小写字母.数字.其它符号,以上四种至少三种
    public static boolean checkCharKinds(String password){
        int Digit=0 , lowercase=0,uppercase=0,others=0;
        char[] ch = password.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i]>='0'&&ch[i]<='9') {
                Digit=1;
                continue;
            }
            else if (ch[i]>='a'&&ch[i]<='z') {
                lowercase=1;
                continue;
            }
            else if (ch[i]>='A'&&ch[i]<='Z') {
                uppercase=1;
                continue;
            }else {
                others=1;
                continue;
            }
        }
        int total = Digit+lowercase+uppercase+others;
        return total>=3 ? true : false;
    }
    // 3.不能有相同长度超2的子串重复   021Abc9Abc1
    public static boolean checkCharRepeat(String password){//从头依次拿三个元素("021")和后length-n("21Abc9Abc1")个相比较，看是否包含
        for(int i=0 ;i<password.length()-2 ;i++){    //i=0 ("021")和("21Abc9Abc1")比较
            String substr1 =password.substring(i, i+3);//i=1 ("21A")和("1Abc9Abc1")比较
            if (password.substring(i+1).contains(substr1))//i=3 ("Abc")和("bc9Abc1")比较
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String psw = cin.nextLine();
            if (checkLength(psw) && checkCharKinds(psw) && checkCharRepeat(psw))
                System.out.println("OK");
            else
                System.out.println("NG");
        }
    }
}

