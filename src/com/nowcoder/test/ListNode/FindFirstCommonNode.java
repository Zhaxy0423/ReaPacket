package com.nowcoder.test.ListNode;

/**@author 渣小宇
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null){
            return null;
        }
        int count1=getListNodeLength(pHead1);
        int count2=getListNodeLength(pHead2);
        ListNode result = null;
       if(count1>count2){
           for(int i=0;i<count1-count2;i++){
               pHead1=pHead1.next;
           }
       }else{
           for(int i=0;i<count2-count1;i++){
               pHead2=pHead2.next;
           }
       }
       Boolean flag=true;
       while(flag){
           if(pHead1==pHead2){
               result=pHead1;
               flag=false;
           }else {
               pHead1=pHead1.next;
               pHead2=pHead2.next;
           }
       }
       return result;
    }
    private int getListNodeLength(ListNode pHead){
        int length = 0;
        ListNode current=pHead;
        while(current!=null){
            length++;
            current=current.next;
        }
        return length;
    }
}
/**
 *
 * HashMap方法
 * 第一个while是把pHead1的所有节点都放进去。
 * 第二个while开始，对pHead2的每个节点都用  containsKey 方法来判断。
 * 
 *       public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 *         ListNode current1 = pHead1;
 *         ListNode current2 = pHead2;
 *  
 *  
 *         HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
 *         while (current1 != null) {
 *             hashMap.put(current1, null);
 *             current1 = current1.next;
 *         }
 *         while (current2 != null) {
 *             if (hashMap.containsKey(current2))
 *                 return current2;
 *             current2 = current2.next;
 *         }
 *  
 *         return null;
 *  
 *     }
 *
 *
 */