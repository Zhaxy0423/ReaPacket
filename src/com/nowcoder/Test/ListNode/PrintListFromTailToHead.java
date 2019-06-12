package com.nowcoder.Test.ListNode;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 链表反转
 * 先确定头结点，将头结点备份作为指针移动，以下一个指针是否为空作为判断条件
 *
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> aL = new ArrayList<>();
        if(listNode==null){
            return aL;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = listNode;
        while(current != null){
            stack.push(current);
            current = current.next;
        }
        while(stack.size()>0){
            aL.add(stack.pop().val);
        }
        return aL;
    }
}
