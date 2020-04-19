package leetcode;

/**
 * Created by wangshunxi on 2020/4/16.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
/*
* 旋转数组   给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
* eg
* 输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
* */

//思路
    //第一次翻转  {7,6,5,4,3,2,1}
    //第二次翻转  {5,6,7,4,3,2,1}
    //第三次翻转  {5,6,7,1,2,3,4}
public class Rotate_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int[] retate = retate(nums, 3);
        for (int i = 0; i < retate.length; i++) {
            System.out.println(retate[i]);
        }
    }
    public static int[] retate(int[] nums,int k){
        k %= nums.length;    //防止下标越界  k > nums.length
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        return nums;
    }

    public static void reverse(int[] nums,int start,int end){
        int tmp;
        while (start < end){
        tmp = nums[start];
        nums[start++] = nums[end];
        nums[end--] = tmp;
        }
    }
}
