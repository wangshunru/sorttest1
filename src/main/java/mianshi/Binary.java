package mianshi;

import java.util.Arrays;

/**
 * Created by wangshunxi on 2019/11/25.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class Binary {
    public static void main(String[] args) {
        int[] arr = {12, 0, -1, 8, 34, 234, 123, 90, 7};
        Arrays.sort(arr);
        int i = binarySearch(arr, 0, arr.length - 1, 8);
        System.out.println(i);
    }

    //二分法查找
    public static int binarySearch(int[] arr, int low, int high, int key) {
        while (low < high) {
            int mid = (int) Math.floor((low + high) / 2);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                return binarySearch(arr, mid+1 , high, key);
            } else  {
                return binarySearch(arr, low, mid , key);
            }
        }
        return -1;
    }
}
