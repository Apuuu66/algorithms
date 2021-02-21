package com.guier.binarytree;

public class ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4, 5, 6, 7};
        int[] in = {3, 2, 4, 1, 6, 5, 7};
        TreeNode root = new ReConstructBinaryTree().reConstructBinaryTree(pre, in);
        new FloorOrder().preOrder(root);
        new FloorOrder().inOrder(root);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return rebuild(pre, 0, pre.length - 1, in, 0, in.length - 1);

    }

    private TreeNode rebuild(int[] pre, int p_left, int p_right, int[] in, int in_left, int in_right) {
        if (p_left > p_right || in_left > in_right) {
            return null;
        }
        TreeNode root = new TreeNode(pre[p_left]);
        int mid = in_left;
        for (int i = in_left; i <= in_right; i++) {
            if (pre[p_left] == in[i]) {
                mid = i;
                break;
            }
        }
//        在中序遍历中，根节点把序列分为左右子树
//        int leftCount = mid - inL;  // 左子树节点个数
//        int rightCount = inR - mid; // 右子树节点个数
//        tree.left = dfs(pre, in, preL + 1, preL + leftCount, inL, mid - 1);
//        tree.right = dfs(pre, in, preR - rightCount + 1, preR, mid + 1, inR);

        root.left = rebuild(pre, p_left + 1, p_left + mid - in_left, in, in_left, mid - 1);
        root.right = rebuild(pre, p_left + mid - in_left + 1, p_right, in, mid + 1, in_right);
        return root;
    }
}
