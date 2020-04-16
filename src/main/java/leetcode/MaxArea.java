package leetcode;

/**
 * Created by wangshunxi on 2020/4/16.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
/*
* 盛水最多的容器
* 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
* 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
* 使得它们与 x 轴共同构成的容器可以容纳最多的水。

* */
public class MaxArea {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
    public static  int maxArea(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int area = 0;
        while (start < end){
            area = nums[start] < nums[end]?Math.max(area,(end-start)*nums[start++]):Math.max(area,(end-start)*nums[end--]); //49
        }
        return area;

    }
}
