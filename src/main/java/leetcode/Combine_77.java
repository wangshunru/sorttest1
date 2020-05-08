package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangshunxi on 2020/5/8.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class Combine_77 {
    public static void main(String[] args) {

    }
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k){
            return res;
        }
        findCombines(n,k,1,new Stack<Integer>());
        return res;
    }
    private static void findCombines(int n, int k, int begin, Stack<Integer> s){
        if (s.size() == k){
            res.add(new ArrayList<Integer>(s));
            return;
        }
        /*for (int i = begin;i <= n;i++){
            s.add(i);
            findCombines(n,k,i+1,s);
            s.pop();
        }*/
        for (int i = begin;i <= n-(k-s.size())+1;i++){
            s.push(i);
            findCombines(n,k,i+1,s);
            s.pop();
        }
    }
}
