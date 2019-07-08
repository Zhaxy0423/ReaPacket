package com.nowcoder.test;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 借助判断内容进行递归
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        int result=n;
        boolean flag = (n>0)&&((result+=Sum_Solution(n-1))>0);
        return result;
    }
    private int sumN(int n){
        int sum = (int)Math.pow(n,2)+n;
        return sum>>1;
    }
}
