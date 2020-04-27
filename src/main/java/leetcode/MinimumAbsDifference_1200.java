package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangshunxi on 2020/4/25.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class MinimumAbsDifference_1200 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> minimumAbsDifference(int[] arr){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //排序
        Arrays.sort(arr);
        int m = arr[1] - arr[0];
        for (int i = 2;i < arr.length;i++){
            m = Math.min(m,arr[i] - arr[i-1]);
        }
        for (int i = 1;i < arr.length;i++){
            if (arr[i] - arr[i-1] == m){
                res.add(Arrays.asList(arr[i],arr[i-1]));
            }
        }
        return res;
    }
}
