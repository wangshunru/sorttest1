package leetcode;

/**
 * Created by wangshunxi on 2020/5/12.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class MySqrt_69 {
    public static void main(String[] args) {

    }

    public static int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int start = 1;
        int end = x / 2 + 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid < x / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }

    /*
    * 100%
    * */
    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        // 针对特殊测试用例，例如 2147395599 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;// 取右中位数，防止进入死循环
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;// 一定存在，无需后处理
    }
}
