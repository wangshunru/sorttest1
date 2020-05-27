package leetcode;

/**
 * Created by wangshunxi on 2020/5/11.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class MyPow_50 {
    public static void main(String[] args) {

    }
    public static  double mypow(double x,int n){
        long N = n;
        if(N < 0){
            N = -N;
            x = 1/x;
        }
        return pow_core(x,N);
    }

    private static double pow_core(double x, long n) {
        if (x == 1 || n == 0){
            return 1.0;
        }
        double half = pow_core(x,n/2);
        return n % 2 == 1?half*half*x:half*half;
    }

}
