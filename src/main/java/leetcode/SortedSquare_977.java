package leetcode;

import java.util.Map;

/**
 * Created by wangshunxi on 2020/4/21.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
/*
* 有序数组的平方   给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
* */
public class SortedSquare_977 {
    public static void main(String[] args) {
        int[] nums = {-4,-2,0,1,2,5};
        int[] ints = sortedSquares(nums);
        for (int i:ints) {
            System.out.println(i);
        }
    }

    public static int[] sortedSquares(int[] nums){
        int[] res = new int[nums.length];
        //双指针
        int i = 0;
        int j = nums.length - 1;
        int k = j;
        while(nums[i] <= 0 && nums[j] > 0){
            if (Math.abs(nums[i]) > nums[j]){
                res[k--] = nums[i] * nums[i++];
            }else{
                res[k--] = nums[j] * nums[j--];
            }
        }
        while (i <= j && nums[i] <= 0){
            res[k--] = nums[i] * nums[i++];
        }
        while (i <= j && nums[j] > 0){
            res[k--] = nums[j] * nums[j--];
        }
        return res;
    }
}
