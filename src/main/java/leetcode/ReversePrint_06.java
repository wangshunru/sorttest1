package leetcode;

/**
 * Created by wangshunxi on 2020/4/29.
 * e-mail: wsr12240512@163.com
 * phone: 13388071923
 */
public class ReversePrint_06 {
    public static void main(String[] args) {

    }

    public static int[] reversePrint(ListNode head){
        if (head == null){
            return new int[]{};
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = head.next;
        int len = 0;
        while (curr != null){
            len++;
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        int[] res = new int[len];
        int i = 0;
        while (pre != null){
            res[i++] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}
