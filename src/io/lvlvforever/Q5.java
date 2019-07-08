package io.lvlvforever;

import java.util.ArrayList;

public class Q5 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        recurVisitList(listNode, list);
        return list;


    }

    private void recurVisitList(ListNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        recurVisitList(node.next, list);
        list.add(node.val);
    }


}
