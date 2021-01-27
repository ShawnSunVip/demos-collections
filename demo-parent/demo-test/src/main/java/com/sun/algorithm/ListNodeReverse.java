package com.sun.algorithm;

/**
 * 链表反转
 * @author sunxiang
 * @date 2021-01-27 16:15
 **/
public class ListNodeReverse {
    public static void main(String[] args) {
        ListNode l1 =new ListNode(1);
        ListNode l2 =new ListNode(2);
        ListNode l3 =new ListNode(3);
        l1.next =l2;
        l2.next=l3;
        ListNode listNode = ReverseList(l1);
        System.out.println(listNode.toString());

    }
    public static ListNode ReverseList(ListNode head){
        ListNode next =null;
        ListNode pre=null;
        while (head!=null){
            next =head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
