package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangshunxi on 2020/4/28.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
/*
* 输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
* */

public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        for (String s:strings) {
            System.out.println(s);
        }
    }
    private static List<String> res = new ArrayList<String>();
    private static List<String> generateParenthesis(int n){

        _generate(0,0,n,"");
        return res;
    }

    private static void _generate(int left,int right,int n,String s){
        //结束条件
        if (left == n && right == n){
            res.add(s);
            return;
        }
        if (left < n){   //左括号没有使用完  才可以使用
            _generate(left+1, right, n, s+"(");
        }
        if (right < left){ //合法情况 右括号一定在左括号之后生成
            _generate(left, right + 1, n, s+")");
        }
    }
}
