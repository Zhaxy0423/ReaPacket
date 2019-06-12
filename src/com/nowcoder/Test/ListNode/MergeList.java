package com.nowcoder.Test.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head;
        ListNode current;
        /**
         * 新链表的表头赋值
         */
        if(list1.val<list2.val){
            head = list1;
            current = head;
            list1=list1.next;
        }else{
            head = list2;
            current = head;
            list1=list2.next;
        }
        while(list1.next!=null&&list2.next!=null){
            if(list1.val<list2.val){
                current.next = list1;
                current=current.next;
                list1=list1.next;
            }else {
                current.next = list2;
                current=current.next;
                list2=list2.next;
            }
        }
        //不为空则表明另一个链表已遍历完
        if(list1!=null){
            current.next=list1;
        }
        if(list2!=null){
            current.next=list2;
        }
        return head;
    }
}
/**   递归实现
 *    public ListNode Merge(ListNode list1,ListNode list2) {
 *         if(list1==null && list2==null){
 *             return null;
 *         }
 *         if(list1==null){
 *             return list2;
 *         }
 *         if(list2==null){
 *             return list1;
 *         }
 *         ListNode head;
 *         if(list1.val<list2.val){
 *             head=list1;
 *             head.next=Merge(list1.next,list2);
 *         }else{
 *             head=list2;
 *             head.next=Merge(list1,list2.next);
 *         }
 *         return head;
 *     }

 * */