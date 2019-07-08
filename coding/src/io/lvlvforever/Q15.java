package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/18.
 */
public class Q15 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (k-- > 0) {
            if (q == null) {
                return null;
            }
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
        }
        return p;
    }
}
