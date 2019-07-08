package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/19.
 */
public class Q19_1 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

}
