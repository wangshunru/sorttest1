package leetcode;

/**
 * Created by wangshunxi on 2020/5/8.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class CanJump_55 {
    public static void main(String[] args) {

    }
    public static boolean canJump(int[] nums){
        if (nums == null) return false;
        int end = nums.length-1;
        for (int i = nums.length-1;i >= 0;i--){
            if (nums[i] + i >= end){
                end = i;
            }
        }
        return end == 0;
    }
}
