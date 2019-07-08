package com.nowcoder.test.Array;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if(A.length==0){
            return null;
        }
        int mulResult = 1;
        int[] B = new int[A.length];
        for(int j=0;j<A.length;j++){
            for(int i=0;i<A.length;i++){
                if(i==j){
                    mulResult=mulResult*1;
                }else{
                    mulResult=mulResult*A[i];
                }
            }
            B[j] = mulResult;
            mulResult=1;
        }
        return B;
    }
}
