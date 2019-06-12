package com.nowcoder.Test.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode current =head;
        ListNode first = head;
        if(head==null){
            return null;
        }
        /**
         * 获取链表长度
         */
        int count=0;
        while(current!=null){
            count++;
            current=current.next;
        }
        if(k>count){
            first = null;
        }else{
            while((count-k)>0){
                first = first.next;
                count--;
            }
        }
        return first;
    }

}
