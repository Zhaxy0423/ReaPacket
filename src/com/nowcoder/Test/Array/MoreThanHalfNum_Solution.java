package com.nowcoder.Test.Array;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int result=0;
        for(int i=0;i<array.length;i++){
            if(!hashMap.containsKey(array[i])){
                hashMap.put(array[i],1);

            }else{
                hashMap.put(array[i],hashMap.get(array[i])+1);
            }
        }
        int n=hashMap.size();
        int a[][]= new int[2][n];
        int i=0;
        for (int key : hashMap.keySet()) {
            a[0][i]=key;
            a[1][i]=hashMap.get(key);
            i++;
        }
        for(int j=0;j<n;j++){
            if(a[1][j]>array.length/2){
                result=a[0][j];
            }
        }
        return result;
    }
}
