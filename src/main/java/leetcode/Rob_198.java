package leetcode;

/**
 * Created by wangshunxi on 2020/5/25.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class Rob_198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums){
        int length = nums.length;
        if(length < 1){
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2;i <= length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[length];
    }
}
