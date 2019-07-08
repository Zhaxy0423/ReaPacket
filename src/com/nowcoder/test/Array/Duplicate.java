package com.nowcoder.test.Array;

import java.util.HashMap;
import java.util.Stack;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null || length == 0){
            duplication[0]=-1;
            return false;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<length;i++){
            if(!hashMap.containsKey(numbers[i])){
                hashMap.put(numbers[i],1);
            }else{
                stack.push(numbers[i]);
            }
        }
        if(stack.size()==0){
            return false;
        }else{
            while(stack.size()>0){
                duplication[0]=stack.pop();
            }
            return true;
        }
    }
}
/**
 * 如果hashmap中已经存在numbers[i]，则直接赋值给duplication[0]
 *     public boolean duplicate(int numbers[],int length,int [] duplication) {
 *         if(numbers==null || length == 0){
 *             duplication[0]=-1;
 *             return false;
 *         }
 *         boolean flag = false ;
 *         HashMap<Integer,Integer> hashMap = new HashMap<>();
 *         Stack<Integer> stack = new Stack<>();
 *         for(int i=0;i<length;i++){
 *             if(!hashMap.containsKey(numbers[i])){
 *                 hashMap.put(numbers[i],1);
 *                 duplication[0]=-1;
 *                 flag = false;
 *             }else{
 *                 duplication[0]=numbers[i];
 *                 flag = true;
 *                 break;
 *             }
 *         }
 *         return flag;
 *     }
 */