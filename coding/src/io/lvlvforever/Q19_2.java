package io.lvlvforever;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvlvforever on 2018/7/19.
 */
public class Q19_2 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);

        for (int i = 0; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;

        }
    }

    private void traverse(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        traverse(node.left, list);
        traverse(node.right, list);
    }


}
