package com.guier.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    static class Solution {
        ArrayList<Integer> arrayList = new ArrayList<>();

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if (listNode != null) {
                this.printListFromTailToHead(listNode.next);
                arrayList.add(listNode.val);
            }
            return arrayList;
        }
    }

}
