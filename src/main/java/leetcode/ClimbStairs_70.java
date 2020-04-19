package leetcode;

/**
 * Created by wangshunxi on 2020/4/15.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
/*
* 爬楼梯问题 一次只能上一级或者2级
*   分析 从第3级台阶开始 只能从 n-1 或者 n-2 上一级或者2级台阶
*   所以 f(n) = f(n-1)+f(n-2)  斐波那契
* */
public class ClimbStairs_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(6));
        System.out.println(gs(6 ));
    }
    public static int climbStairs(int n){
        if (n == 1) return  1;
        int first = 1;
        int second = 2;
        int third;
        for (int i = 3;i <= n;i++){
            third = first + second;
            first = second;
            second = third;
        }
        return  second;
    }
    //斐波那契公式
    public static int gs(int n){
        double sqrt = Math.sqrt(5);
        double v = Math.pow((1 + sqrt) / 2, n + 1) - Math.pow((1 - sqrt) / 2, n + 1);
        return  (int) (v/sqrt);
    }
}
