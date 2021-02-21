package com.guier.binarytree;

import java.util.*;

public class FloorOrder {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        TreeNode root = node1;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node6.left = node7;

        FloorOrder floorOrder = new FloorOrder();
        floorOrder.floorOrderRight(root);
//        floorOrder.floorOrder(root);
//        floorOrder.preOrder(root);
//        floorOrder.inOrder(root);

    }

    public void floorOrderRight(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
//                TreeNode tmp = null;
//                Iterator<TreeNode> it = queue.iterator();
//                while (it.hasNext()) {
//                    tmp = it.next();
//                }
//                if (queue.isEmpty()) {
//                    continue;
//                }
//                TreeNode tmp = null;
//                tmp = queue.getLast();
//                // tmp是最右
//                if (tmp != null) {
//                    System.out.println(tmp.value);
//                    queue.offer(null);
//                }
                if (!queue.isEmpty()) {
                    System.out.println(queue.getLast().val);
                    queue.offer(null);
                }

                continue;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public void floorOrder(TreeNode root) {
        TreeNode cur = root;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur != null) {
                System.out.println(cur.val);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    ArrayList<Integer> preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
        return list;
    }

    ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            list.add(current.val);
            current = current.right;

        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
        return list;

    }
}
