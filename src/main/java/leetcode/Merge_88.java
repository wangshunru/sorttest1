package leetcode;

//合并两个有序数组
public  class Merge_88{
    public void merge(int[] nums1,int m,int[] nums2,int n){
        int l1 = m-1;
        int l2 = n-1;
        int l = m+n-1;
        while(l1 >= 0 && l2 >= 0){
            nums1[l--] = nums1[l1]>nums2[l2]?nums1[l1--]:nums2[l2--];
        }
        System.arraycopy(nums1,0,nums2,0,l2+1);
    }
}
