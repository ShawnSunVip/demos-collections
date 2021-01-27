package com.sun.algorithm;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 * @author sunxiang
 * @date 2021-01-27 16:31
 **/
public class ListNodeFindK {
    public static void main(String[] args) {
        ListNode l1 =new ListNode(1);
        ListNode l2 =new ListNode(2);
        ListNode l3 =new ListNode(3);
        l1.next =l2;
        l2.next=l3;

        System.out.println(FindKthToTail(l1,2));
    }

    //两个指针一个指针p1先开始跑，指针p1跑到k-1个节点后，另一个节点p2开始跑，当p1跑到最后时，p2所指的指针就是倒数第k个节点。
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode pre=null,p =null;
        pre=head;
        p=head;
        int a=k;
        int count=0;
        while (p!=null){
            p=p.next;
            count++;
            if(k<1){
                pre=pre.next;
            }
            k--;
        }
        if(count<a){
            return null;
        }

        return pre;
    }
}
