package leetcode;

import java.util.Arrays;

/**
 * Created by wangshunxi on 2020/5/7.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class FindContentChildren_455 {
    public static void main(String[] args) {

    }
    public static int findContentChildren(int[] g,int[] s){
        if (g == null || s == null) return 0;
        int s1 = 0;
        int g1 = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (g1 < g.length && s1 < s.length){
            if(g[g1] <= s[s1]){
                g1++;
            }
            s1++;
        }
        return g1;
    }
}
