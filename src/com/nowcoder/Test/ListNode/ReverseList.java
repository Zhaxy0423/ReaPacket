package com.nowcoder.Test.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        ListNode next = null;
        ListNode current = head;
        if(head ==null||head.next==null){
            return newHead;
        }
        while(current!=null){
            /**
             * 等号表示左边指向右边
             */
            next=current.next;//备份，以免链表断裂
            current.next=newHead;//反转
            newHead = current;//平移
            current=next;
        }
        return newHead;
    }
}
