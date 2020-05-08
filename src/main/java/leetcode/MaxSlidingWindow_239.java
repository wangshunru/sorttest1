package leetcode;

/**
 * Created by wangshunxi on 2020/4/28.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class MaxSlidingWindow_239 {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow1(int[] nums,int k){
        if (nums.length == 0){
            return nums;
        }
        //当前数到左边界的最大值
        int[] leftMax = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0){
                max = Integer.MIN_VALUE;
            }
            if(max < nums[i]){
                max = nums[i];
            }
            leftMax[i] = Math.max(nums[i],max);
        }
        //当前数到右边界的最大值
        int[] rightMax = new int[nums.length];
        max = Integer.MIN_VALUE;
        for(int i = nums.length-1;i >= 0;i--){
            if (i % k == 0){
                max = Integer.MIN_VALUE;
            }
            if (max < nums[i]){
                max = nums[i];
            }
            rightMax[i] = Math.max(nums[i],max);
        }
        int[] res = new int[nums.length -k + 1];
        for (int i = 0;i < res.length;i++){
            int j = i+k-1;
            res[i] = Math.max(leftMax[j],rightMax[i]);
        }
        return res;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;
        //当前数到自己的左边界的最大值
        int leftMax[] = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                max = Integer.MIN_VALUE;
            }
            if (max < nums[i]) {
                max = nums[i];
            }
            leftMax[i] = Math.max(nums[i], max);
        }
        //当前数到自己的右边界的最大值
        int rightMax[] = new int[n];
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i % k == 0) {
                max = Integer.MIN_VALUE;
            }
            if (max < nums[i]) {
                max = nums[i];
            }
            rightMax[i] = Math.max(nums[i], max);
        }

        int result[] = new int[n - k + 1];
        for (int i = 0; i < result.length; i++) {
            int j = i + k - 1;
            result[i] = Math.max(rightMax[i], leftMax[j]);
        }
        return result;
    }
}
