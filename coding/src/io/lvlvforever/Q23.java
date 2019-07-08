package io.lvlvforever;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                nodes.add(left);
            }
            if (right != null) {
                nodes.add(right);
            }
            list.add(node.val);
        }
        return list;
    }
}
