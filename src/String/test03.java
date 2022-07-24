package String;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/***
 * ����
 * ʵ��ɾ���ַ����г��ִ������ٵ��ַ��������ִ������ٵ��ַ��ж������ѳ��ִ������ٵ��ַ���ɾ�������ɾ����Щ���ʺ���ַ������ַ����������ַ�����ԭ����˳��
 *
 * ���ݷ�Χ��������ַ����������� 1 \le n \le 20 \1��n��20  ����֤������ַ����н�����Сд��ĸ
 * ����������
 * �ַ���ֻ����СдӢ����ĸ, �����ǷǷ����룬������ַ�������С�ڵ���20���ֽڡ�
 *
 * ���������
 * ɾ���ַ����г��ִ������ٵ��ַ�����ַ�����
 */
public class test03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            char []c = s.toCharArray();//�������ַ�ת��Ϊchar����
            HashMap<Character,Integer> hashMap = new HashMap<>();//������Ÿ����ַ��Ͷ�Ӧ���ַ�����
            for (char i : c){
                hashMap.put(i , (hashMap.getOrDefault(i , 0) + 1));//��������ַ�������
            }

            //�ó���С����
            Collection<Integer> collation = hashMap.values();//ȡ�����ж�Ӧ�ַ�����
            Integer min = Collections.min(collation);//�ó���С����

            for (Character character : hashMap.keySet()){//ȡ�������ַ�
                if(hashMap.get(character) == min){//������ַ�����Ϊ��С����ֵ
                    s = s.replaceAll(String.valueOf(character) , "");//�滻���ַ�Ϊ��
                }
            }
            System.out.println(s);

        }
    }

}
