package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangshunxi on 2020/4/27.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class ThreeSum_15 {
    public static void main(String[] args) {

    }

    //先排序 + 双指针  转化成 a+b = -c
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int a = 0, b = 0,sum = 0;
        for (int i = 0;i < nums.length -2;i++){
            if (i == 0 || (i >0 && nums[i] != nums[i-1])){ //去重
                a = i+1;
                b = nums.length - 1;
                sum = 0 - nums[i];
                while (a < b){
                    if (nums[a] + nums[b] == sum){
                        ans.add(Arrays.asList(nums[a],nums[b],nums[i]));
                        while (a < b && nums[a] == nums[a+1]) a++;
                        while (a < b && nums[b] == nums[b-1]) b--;
                        a++;
                        b--;
                    }else if (nums[a] + nums[b] < sum){
                        a++;
                    }else {
                        b--;
                    }
                }
            }
        }
        return ans;
    }
}
