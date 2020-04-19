package leetcode;

/**
 * Created by wangshunxi on 2020/4/18.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
/*给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
*
* */
//仅仅反转字符
public class ReverseOnlyLetters_917 {

    public static void main(String[] args) {
        String s = reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(s);
    }
    public  static  String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        if (chars.length < 2) return S;
        int left = 0;
        int right = chars.length-1;
        while (left < right){
            while (left < right && !isChar(chars[left])) left++;
            while (left < right && !isChar(chars[right])) right--;
            if (left < right){
                chars[left] ^= chars[right];
                chars[right] ^= chars[left];
                chars[left] ^= chars[right];
                left ++;
                right--;
            }
        }
        return new String(chars);
    }
    public static boolean isChar(char c){
        return  (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
    }
}
