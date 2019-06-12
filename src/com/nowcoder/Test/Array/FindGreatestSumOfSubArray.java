package com.nowcoder.Test.Array;

import java.util.ArrayList;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        int result=0;
        if(array.length==0){
            result=0;
        }else if(array.length==1){
            result=array[0];
        }else{
            SubArray(list,array,0,array.length-1);
            int max=list.get(0);
            for(int i=0;i<list.size();i++){
                if(max<=list.get(i)){
                    max=list.get(i);
                }
            }
            result=max;
        }

        return result;
    }
    private void  SubArray(ArrayList<Integer> list ,int[] array,int start,int end){
        int sum=0;
        if(start<end){
            for(int i=start;i<=end;i++){
                sum=sum+array[i];
                list.add(sum);
            }
            SubArray(list,array,start+1,end);
        }

    }
}
