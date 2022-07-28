package String;

import java.util.Scanner;

/***
 * ԭ��ip��ַ��ÿ�ο��Կ�����һ��0-255����������ÿ�β�ֳ�һ����������ʽ���������Ȼ��������������ת���һ����������
 * ������һ��ip��ַΪ10.0.3.193
 * ÿ������             ���Ӧ�Ķ�������
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * ���������Ϊ��00001010 00000000 00000011 11000001,ת��Ϊ10���������ǣ�167773121������IP��ַת��������־������ˡ�
 * 00001010000000000000001111000001
 *
 * ���ݷ�Χ����֤������ǺϷ��� IP ����
 *
 * ����������
 * ����
 * 1 ����IP��ַ
 * 2 ����10�����͵�IP��ַ
 *
 * ���������
 * ���
 * 1 ���ת����10���Ƶ�IP��ַ
 * 2 ���ת�����IP��ַ
 *
 * ʾ��1
 * ���룺
 * 10.0.3.193
 * 167969729
 * ����
 * �����
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
            String s1 = Integer.toBinaryString(integer[i]);//��ʮ����ת��Ϊ������ 1010
            while (s1.length() < 8) {
                s1 = "0" + s1; //00001010
            }
            sb.append(s1);
        }
        System.out.println(Long.parseLong(sb.toString(), 2));//�Ѷ�����sb = 00001010 00000000 00000011 11000001 ת��Ϊ ʮ����167969729
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
        String num = Long.toBinaryString(Long.parseLong(s)); //��167969729תΪ������String��
        while (num.length() < 32) { //���0 Ϊ 00001010 00000011 00000011 11000001
            num = "0" + num;
        }
        String[] ans = new String[4];
        for (int i = 0; i < 4; i++) {
            String s1 = num.substring(8 * i, 8 * i + 8);//00001010
            s = Integer.toString(Integer.parseInt(s1, 2));//�Ѷ�����ת��Ϊʮ���� 10
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