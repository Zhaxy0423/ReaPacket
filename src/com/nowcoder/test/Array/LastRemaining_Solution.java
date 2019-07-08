package com.nowcoder.test.Array;

import java.util.LinkedList;

/**
 * 0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 方法一：采用链表来存放，每次对长度取余来实现循环
 */
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int removeIndex = 0;
        while(list.size()>1){
            removeIndex = (removeIndex+m-1)%list.size();
            list.remove(removeIndex);
        }
        return list.getFirst();
    }
}
/**
 * 方法二：找规律实现
 *    public int LastRemaining_Solution(int n, int m) {
 *         if(n<1 || m<1)
 *             return -1; //出错
 *         int last=0;
 *         for(int i=2;i<=n;i++){
 *             last=(last+m)% i;  //这里是i不是n！！！
 *         }
 *         return last;
 *     }
 */