package com.guier.binarytree;

public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + val +
                '}';
    }
}
