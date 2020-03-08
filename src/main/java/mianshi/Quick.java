package mianshi;

/**
 * Created by wangshunxi on 2019/11/25.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class Quick {
    public static void main(String[] args) {
        int[] arr = {12,1,0,9,6,32,15,90,33,12};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void quickSort(int[] arr,int low,int high){
        if (low < high){
            int index = getIndex2(arr, low, high);
            quickSort(arr, low, index-1);
            quickSort(arr, index+1, high);
        }
    }

    public static int getIndex(int[] arr,int low,int high){
        int tmp = arr[low];
        while (low < high){
            while (low < high && arr[high] >= tmp){
                high --;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp){
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    public static int getIndex2(int[] arr,int low,int high){
        // 基准值
        int base = arr[low];
        while (low < high){

            // 从右往左查找 找到比基准值小的
            while (low < high && arr[high] >= base){
                high --;
            }
            // 交换基准值与找到的值
            swap(arr,low,high);
            // 从左往右查找 找到比基准值大的
            while (low < high && arr[low] <= base){
                low ++;
            }
            swap(arr,low,high);
        }
        return low;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
