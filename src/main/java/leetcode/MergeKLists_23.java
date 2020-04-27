package leetcode;

/**
 * Created by wangshunxi on 2020/4/26.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class MergeKLists_23 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int k = lists.length;
        while (k > 1){
            int i = 0;
            for (int j = 0;j < k;j += 2){
                if (j == k-1){
                    lists[i++] = lists[j];
                }else {
                    lists[i++] = mergeTwoLists(lists[j],lists[j+1]);
                }
            }
            k = i;
        }
        return  lists[0];
    }


    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}