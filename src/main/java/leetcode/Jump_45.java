package leetcode;

/**
 * Created by wangshunxi on 2020/5/8.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class Jump_45 {
    public static void main(String[] args) {

    }
    public static int jump(int[] nums){
        if (nums == null || nums.length < 1){  //直接到达情况
            return 0;
        }
        int start = 0; //起跳起点
        int max = nums[0]; //每一次起跳的终点
        int step = 1; //跳到终点的最小步数
        while (max < nums.length-1){  //获取start-->max 区间最大的位置 此位置可以作为下一次起跳的起点
            int curMax = 0;
            for (int i = start+1; i <= max; i++) {
                if (i + nums[i] > curMax){
                    //当前点可以到达的最远位置
                    curMax = i+nums[i];
                    start = i;
                }
            }
            //从当前点可以到达的最终位置
            max = start + nums[start];
            step ++;
        }
        return step;
    }
}
