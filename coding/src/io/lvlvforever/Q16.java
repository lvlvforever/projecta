package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/18.
 */
public class Q16 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = q;
            q = p;
            p = tmp;
        }
        return q;
    }
}