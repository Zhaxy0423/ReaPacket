package com.nowcoder.test.Array;

/**
 *  输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素
 *  输入[3 4 5 1 2]
 *  输出[1 2 3 4 5]最小值1
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int result=0;
        if(array.length==0){
            return result;
        }

        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){
                result = array[i+1];
                break;
            }
        }
        return result;
    }
}
