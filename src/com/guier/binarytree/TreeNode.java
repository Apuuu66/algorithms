package com.guier.binarytree;

public class TreeNode {
    Integer value;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
