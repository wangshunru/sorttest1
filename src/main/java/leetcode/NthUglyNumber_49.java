package leetcode;

/**
 * Created by wangshunxi on 2020/5/8.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class NthUglyNumber_49 {
    public static void main(String[] args) {

    }
    public static int nthUglyNumber(int n){
        int a = 0;
        int b = 0;
        int c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = res[a]*2;
            int n3 = res[b]*3;
            int n5 = res[c]*5;
            res[i] = Math.min(Math.min(n2,n3),n5);
            if (res[i] == n2) a++;
            if (res[i] == n3) b++;
            if (res[i] == n5) c++;
        }
        return res[n-1];
    }
}
