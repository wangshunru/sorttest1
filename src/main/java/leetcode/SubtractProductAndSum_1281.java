package leetcode;

import java.util.Scanner;

/**
 * Created by wangshunxi on 2020/4/16.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */

/*
*1281  整数的各位积和之差
* 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
* 输入：n = 4421
输出：21
解释：
各位数之积 = 4 * 4 * 2 * 1 = 32
各位数之和 = 4 + 4 + 2 + 1 = 11
结果 = 32 - 11 = 21

//思路 分离出各位数
* */
public class SubtractProductAndSum_1281 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(subtractProductAndSum(n));
    }
    public static int subtractProductAndSum(int n){
        int product = 1;
        int sum = 0;
        int num;
        while (n >0){
            num = n % 10;
            product *= num;
            sum += num;
            n = n / 10;
        }
        return product - sum;
    }

}
