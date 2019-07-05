package com.nowcoder.test.Array;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int[] num=new int[2];
        if(array==null){
            num=null;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(!hashMap.containsKey(array[i])){
                hashMap.put(array[i],1);
            }else{
                hashMap.put(array[i],2);
            }
        }
        Set<Integer> set = hashMap.keySet();
        int j=0;
        for(int key:set){
            if(hashMap.get(key)==1){
                num[j++]=key;
            }
        }
        num1[0]=num[0];
        num2[0]=num[1];
    }
}
/***
 * 异或法
 * 解法1：
 * 1、思路：
 * (1)对于出现两次的元素，使用“异或”操作后结果肯定为0，那么我们就可以遍历一遍数组，对所有元素使用异或操作，那么得到的结果就是两个出现一次的元素的异或结果。
 * (2)因为这两个元素不相等，所以异或的结果肯定不是0，也就是可以再异或的结果中找到1位不为0的位，例如异或结果的最后一位不为0。
 * (3)这样我们就可以最后一位将原数组元素分为两组，一组该位全为1，另一组该位全为0。
 * (4)再次遍历原数组，最后一位为0的一起异或，最后一位为1的一起异或，两组异或的结果分别对应着两个结果。
 * 2、复杂度：
 *   （1）时间复杂度：第一次循环，将所有元素异或得到对应结果，时间开销为O(n)；第二次循环，找出第一次异或结果为1的位，时间开销为O(32)；第三次循环，根据为1的位将元素分为两组进行异或得到两个结果，时间复杂度为O(n)，所以总的时间复杂度为T(n) = 2*O(n)+O(32) = O(n)。
 *   （2）空间复杂度：常数，因为只分配了两个空间用于结果的保存，因此空间复杂度为常数。
 *
 *    public static int[] findNumsAppearOnce2(int[] arr) {
 *         if(arr.length < 2)
 *             return arr;
 *
 *         int[] result = new int[2];  //要返回的结果
 *         int res = arr[0];  //第一次对所有元素进行亦或操作结果
 *         for(int i=1; i<arr.length; i++) {
 *             res ^= arr[i];
 *         }
 *         int bitIndex = 0;
 *         for(int i=0; i<32; i++) {  //找出亦或结果为1的位。
 *             if((res>>i & 1) == 1) {
 *                 bitIndex = i;
 *                 break;
 *             }
 *         }
 *         for(int i=0; i<arr.length; i++) { //根据bitIndex为1，将元素分为两组
 *             if((arr[i] >> bitIndex & 1) == 1)
 *                 result[0] ^= arr[i];   //对应位为1，亦或得到的结果
 *             else
 *                 result[1] ^= arr[i];   //对应位为0，亦或得到的结果
 *         }
 *
 *         return result;
 *     }
 *
 */
