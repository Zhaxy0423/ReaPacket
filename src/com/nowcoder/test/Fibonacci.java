package com.nowcoder.test;

/**
 * 输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
public class Fibonacci {
    public int Fibonacci(int n) {
            int a = 0, b=1, c = 0;
            int result =0;
            for (int i = 0; i <= n; i++) {
                if (i == 0) {
                    result=a;
                }else if (i == 1) {
                    result=b;
                }else {
                    c = a+b;
                    a = b;
                    b = c;
                    result =c;
                }
            }
            return result;
        }
}

    /** 递归实现
     * public int Fibonacci(int n){
     *      if(n==0){
     *           return 0;
     *       }
     *       if(n==1){
     *           return 1;
     *       }
     *       int result =0;
     *       if(n>=2){
     *           result =Fibonacci(n-1)+Fibonacci(n-2);
     *       }
     *         return result;
     *}

     */
