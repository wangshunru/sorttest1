package leetcode;

/**
 * Created by wangshunxi on 2020/4/18.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,3,3,4,5,5,5};

    }
    public static int removeDuplicates(int[] nums){
        int slow = 0;
        int fast = 0;
        while(slow < fast){
            if (nums[slow] == nums[fast]){
                fast++;
                continue;
            }
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
        return slow+1;
    }
}
