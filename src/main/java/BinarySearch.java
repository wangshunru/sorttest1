import java.util.Arrays;

/**
 * Created by wangshunxi on 2019/11/21.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {12,0,8,3,56,6,8,11};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int i = binarySearch(arr, 0, arr.length - 1, 11);
        System.out.println(i);
        System.out.println(arr[i]);
    }
    public static int binarySearch(int[] arr,int low,int high,int key){
        while (low <= high){
            int mid = (int)Math.floor((low + high) / 2);
            if (key == arr[mid]){
                return mid;
            }else if (key < arr[mid]){
                high = mid -1;
                return binarySearch(arr, low, high, key);
            }else {
                low = mid +1;
                return binarySearch(arr, low, high, key);
            }
        }
        return -1;
    }
}
