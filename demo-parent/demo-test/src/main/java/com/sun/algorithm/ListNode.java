package com.sun.algorithm;

/**
 * 链表
 * @author sunxiang
 * @date 2021-01-27 16:15
 **/
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
