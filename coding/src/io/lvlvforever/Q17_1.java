package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/18.
 */
public class Q17_1 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            } else {
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }

        }
        if (list1 != null) {
            p.next = list1;
        } else if (list2 != null) {
            p.next = list2;
        }
        ListNode res = head.next;
        head.next = null;
        return res;

    }
}
