package io.lvlvforever;

public class Q18 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return hasSubtreeCore(root1, root2);
    }

    private boolean hasSubtreeCore(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1.val == root2.val) {
            boolean flag = hasSubtreeCore(root1.left, root2.left) && hasSubtreeCore(root1.right, root2.right);
            if (flag == true) {
                return true;
            }
        }
        return hasSubtreeCore(root1.left, root2) || hasSubtreeCore(root1.right, root2);
    }


}
