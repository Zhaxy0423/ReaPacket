package com.nowcoder.test.Array;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(array==null || array.length<2){
            return arrayList;
        }
        int[][] result = new int[2][array.length];
        int k=0;
        for(int i=0;i<array.length;i++){
            int s=0;
            for(int j=i+1;j<array.length;j++){
                s=array[i]+array[j];
                if(s==sum){
                    result[0][k]=array[i];
                    result[1][k]=array[j];
                    k++;
                    break;
                }
            }
        }
        if(k!=0){
            int min=result[0][0]*result[1][0];
            int index=0;
            for(int i=1;i<k;i++){
                if(min>=result[0][i]*result[1][i]){
                    min=result[0][i]*result[1][i];
                    index=i;
                }
            }
            arrayList.add(result[0][index],result[1][index]);
            return arrayList;
        }else{
            return arrayList;
        }

    }
}
