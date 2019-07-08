package io.lvlvforever;

public class Q6 {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Q6 obj = new Q6();
        TreeNode node = obj.reConstructBinaryTree(pre, in);
        Utils.traverse(node);
    }


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode node = constructCore(pre, in, 0, pre.length - 1, 0, pre.length - 1);
        return node;

    }

    private TreeNode constructCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        int root = pre[preStart];
        TreeNode node = new TreeNode(root);
        if (preStart == preEnd) {
            return node;
        }
        int pos = indexOf(in, root);
        int leftTreeLength = pos - preStart; //左子树的节点数量
        int rightTreeLength = preEnd - pos; //右子树的节点数量
        if (leftTreeLength > 0) {
            node.left = constructCore(pre, in, preStart + 1, preStart + leftTreeLength, inStart, pos - 1);
        }
        if (rightTreeLength > 0) {
            node.right = constructCore(pre, in, preStart + leftTreeLength + 1, preEnd, pos + 1, inEnd);
        }

        return node;

    }

    private int indexOf(int[] arr, int target) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
