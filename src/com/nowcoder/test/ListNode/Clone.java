package com.nowcoder.test.ListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head
 *
 * 1.复制普通节点并插入
 * 2.复制random指向
 * 3.拆分原节点和复制节点
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Clone {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null){
            return null;
        }
        RandomListNode p = pHead;
        //复制普通指向并且插入
        while(p!=null){
            //定义节点并赋值
            RandomListNode tmp = new RandomListNode(p.label);
            tmp.next = p.next;//保存下一个节点
            p.next =tmp;
            p = tmp.next;
        }
        //复制Random指向
        p=pHead;
        while(p!=null){
            if(p.random!=null){
                p.next.random=p.random.next;
            }
            p=p.next.next;
        }
        //拆分原链表与复制的链表
        RandomListNode head =pHead.next;//复制链表的表头
        RandomListNode q = head;
        p=pHead;//原链表表头
        while(q.next!=null){
            p.next=q.next;
            p=p.next;

            q.next=p.next;
            q=q.next;

        }
        //将原链表结尾设置为空
        p.next=null;
        return head;
    }
}
