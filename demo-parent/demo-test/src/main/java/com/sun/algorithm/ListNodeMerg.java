package com.sun.algorithm;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author sunxiang
 * @date 2021-01-27 16:40
 **/
public class ListNodeMerg {
    public static void main(String[] args) {
        ListNode l1 =new ListNode(1);
        ListNode l2 =new ListNode(4);
        ListNode l3 =new ListNode(6);
        l1.next =l2;
        l2.next=l3;

        ListNode m1 =new ListNode(2);
        ListNode m2 =new ListNode(3);
        ListNode m3 =new ListNode(5);
        m1.next =m2;
        m2.next=m3;

        System.out.println(Merge(l1,m1));


    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 ==null){
            return list2;
        }
        if(list2 ==null){
            return list1;
        }

        ListNode merg =null;
        ListNode c =null;
        while (list1!=null && list2 !=null){
            if(list1.val <= list2.val){
                if(merg ==null){
                    merg =c =list1;
                }else{
                    c.next=list1;
                    c =list1;
                }
                list1 =list1.next;
            }else{
                if(merg ==null){
                    merg =c =list2;
                }else{
                    c.next=list2;
                    c =list2;
                }
                list2 =list2.next;
            }
        }

        if(list1==null){
            c.next=list2;
        }else{
            c.next=list1;
        }
        return merg;
    }
}
