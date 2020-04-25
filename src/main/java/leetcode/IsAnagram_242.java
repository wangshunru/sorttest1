package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshunxi on 2020/4/25.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
/*
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
* s = "anagram", t = "nagaram"
  输出: true
* */
public class IsAnagram_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram2("anagram","nagaram"));
    }
    //排序
    public static boolean isAnagram(String s,String t){
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    public static boolean isAnagram2(String s,String t){
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i= 0;i < s.length();i++){
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }
        for (int i:counter) {
            if (i != 0){
                return false;
            }
        }
        return true;
    }
}
