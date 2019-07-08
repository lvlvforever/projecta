package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/17.
 */
public class Q13 {
    public static void main(String[] args) {

    }

    private ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return null;
        }
        if (toBeDeleted == head) {
            ListNode next = head.next;
            head.next = null;
            toBeDeleted = null;
            return next;
        } else if (toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            ListNode next = toBeDeleted.next.next;
            toBeDeleted.next.next = null;
            toBeDeleted.next = next;
            return head;
        } else {
            ListNode cur = head;
            while (cur.next != null && cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            return head;
        }
    }
}
