package com.nowcoder.test.Array;

import java.util.Arrays;

/**
 * 决定大/小王可以看成任何数字，任选5张牌能否组成顺子，56张牌中有2张大王，2张小王
 * 思路： 首先把数组排序，再统计数组中 0 的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。
 * 如果空缺的总数小于或者等于 0 的个数，那么这个数组就是连续的：反之则不连续。
 */
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null || numbers.length<5){
            return false;
        }
        Arrays.sort(numbers);
        int zeroNum=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                zeroNum++;
            }
        }
        int empty=0;
        for(int i=zeroNum;i<numbers.length-1;i++){
            if(numbers[i+1]-numbers[i]>1){
                empty+=numbers[i+1]-numbers[i]-1;
            }
            if(numbers[i+1]-numbers[i]==0){
                return false;
            }
        }
        if(empty<=zeroNum){
            return true;
        }
        return false;
    }
}
