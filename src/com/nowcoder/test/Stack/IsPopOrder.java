package com.nowcoder.test.Stack;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序
 * 出栈的每个元素后面比该元素的原下标小的元素，应该按原下标从大到小的相对顺序排列
 */
public class IsPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean flag=false;
        if(pushA==null||popA==null){
            return false;
        } else{
            /**
             * 将入栈序列的第一个元素入辅助栈并与出栈序列的第一个元素比较，
             * 循环入栈序列直到找到与出栈序列相等的元素，将栈顶元素其出辅助栈；
             */
            if(pushA.length==1||popA.length==1){
                if(pushA[0]==popA[0]){
                    flag=true;
                }
                else
                    flag=false;
            }else{
                for(int i=0;i<pushA.length;i++){
                    Stack<Integer> stack= new Stack<>();
                    int k=0;
                    while(stack.push(pushA[k])!=popA[i]){
                        k++;
                    }
                    stack.pop();
                    flag = stack.empty();
                }
            }
            //最后出栈元素为最先入栈元素，以最后出栈元素出栈后辅助栈是否为空判断合法性
            return flag;
        }
    }
}
