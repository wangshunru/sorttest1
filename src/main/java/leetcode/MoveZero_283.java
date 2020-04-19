package leetcode;

/**
 * Created by wangshunxi on 2020/4/14.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */

/*
* 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
* */
public class MoveZero_283 {

    public static void main(String[] args) {
        int[] nums =  {0,1,4,0,6,9};
        int[] zero = moveZero(nums);
        for (int i = 0; i < zero.length; i++) {
            System.out.println(zero[i]);
        }
    }

    public static int[] moveZero(int[] nums){
        int j = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                if (i != j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }
}
