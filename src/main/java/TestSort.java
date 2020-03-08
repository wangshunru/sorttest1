/**
 * Created by wangshunxi on 2019/11/17.
 * e-mail: mcphilex1989@gmail.com
 * phone: 15652608401
 */
public class TestSort {
    public static void main(String[] args) {
        //冒泡排序
       /* int[] arr = {3,9,0,4,6,2,1,7,9};
        for (int i =0;i <arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i] > arr[j]){
                    int item;
                    item = arr[j];
                    arr[j] = arr[i];
                    arr[i] = item;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/

       //快速排序


       int[] arr = {49,38,65,97,23,22,76,1,5,8,2,0,-1,22};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        popSort(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        selectSort(arr, 0, arr.length - 1);

        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr,int low,int high){
        if (low < high){
            int index = getIndex(arr, low, high);
            //进行迭代 对index之前的之后的数据进行相同的操作
            quickSort(arr,0,index-1);
            quickSort(arr,index+1,high);
        }
    }


    public static int getIndex(int[] arr,int low,int high){
        //基准数据
        int tmp = arr[low];
        while (low < high){
            //当队尾的元素大于基准数据
            while (low < high && arr[high] >= tmp){
                high -- ;
            }
            //如果队尾小于 将high位置的值赋值给low位置
            arr[low] = arr[high];
            //当对首元素小于基准
            while (low < high && arr[low] <= tmp){
                low ++;
            }
            //
            arr[high] = arr[low];
        }
        //当low 和 high 相等时 就是正确的索引位置
        arr[low] = tmp;
        return low;
    }

    public static void selectSort(int[] arr, int low, int high) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] >= arr[j]) {
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }



    public static void popSort(int[] arr, int low, int high) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int i = arr[a];
        arr[a] = arr[b];
        arr[b] = i;
    }
}
