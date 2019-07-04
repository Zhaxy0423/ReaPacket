package com.nowcoder.test.Stack;

import java.util.Stack;

/**
 * 入栈：数据栈中直接压入元素，当辅助栈空或者要压入的元素小于当前辅助栈栈顶元素时，辅助栈也压入该元素
 *
 * 出栈：在数据栈不空的前提下，如果辅助栈栈顶元素与数据栈栈顶元素相等，则都弹出；否则只弹出数据栈栈顶元素
 *
 * 得最小元素：直接返回辅助栈栈顶元素
 */
public class MinEle {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        //如果辅助栈栈顶元素比node大，则将node入栈
        if(minStack.empty()||(!minStack.empty()&&node<=minStack.peek())){
            minStack.push(node);
        }
    }

    public void pop() {
        if(!dataStack.empty()){
            if(minStack.peek()==dataStack.peek()){
                minStack.pop();
            }
            dataStack.pop();
        }
    }

    public int top() {
        //数据栈的栈顶元素为最大值
        return dataStack.peek();
    }

    public int min() {
        //辅助栈的栈顶元素为最小值
        return minStack.peek();
    }
}
