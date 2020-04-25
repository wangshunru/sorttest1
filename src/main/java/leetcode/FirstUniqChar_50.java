package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangshunxi on 2020/4/20.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
    //第一个只出现一次的字符
public class FirstUniqChar_50 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("ababbaacddceffhi"));
        System.out.println(firstUniqChar2("ababbaacddceffhi"));
    }

    public static char firstUniqChar(String s){
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            map.put(sc[i],!map.containsKey(sc[i]));
        }
        for (char c : sc){
            if (map.get(c)) return c;
        }
        return ' ';
    }

    //法二
    public static char firstUniqChar2(String s){
        Map<Character,Boolean> map = new LinkedHashMap<Character, Boolean>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            map.put(c,!map.containsKey(c));
        }
        for (Map.Entry<Character,Boolean> entry : map.entrySet()){
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
