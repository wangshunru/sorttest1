package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangshunxi on 2020/5/7.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class MajorityElement_169 {
    public static void main(String[] args) {

    }
    public static int majorityElement(int[] nums) {
        int target = nums[0];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                ++count;
            }else if(--count == 0){
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
    public static int marjor(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
