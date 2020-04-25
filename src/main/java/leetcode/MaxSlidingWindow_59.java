package leetcode;

/**
 * Created by wangshunxi on 2020/4/23.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
/*
* 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。   滑动窗口的最大值
* 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
* */
public class MaxSlidingWindow_59 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        for (int i:ints) {
            System.out.print(i+"    ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = k - 1;
        int[] result = new int[nums.length - k + 1];//存储结果
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
        }
        result[left] = max;
        boolean maxIsStart = max == nums[left] ? true : false;
        left++;
        right++;
        while (right < nums.length) {
            if (maxIsStart) {
                max = nums[left];
                for (int i = left + 1; i <= right; i++) {
                    max = Math.max(max, nums[i]);
                }
            } else {
                max = Math.max(max, nums[right]);
            }
            result[left] = max;
            maxIsStart = max == nums[left] ? true : false;
            left++;
            right++;
        }
        return result;
    }

}
