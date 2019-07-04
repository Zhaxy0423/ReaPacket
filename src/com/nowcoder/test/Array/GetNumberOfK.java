package com.nowcoder.test.Array;

/**
 * @author 渣小宇
 * 统计一个数字在数组中出现的次数
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int result=0;
        if(array==null){
            return 0;
        }
        for(int i=0;i<array.length;i++){
            result=result+getNumCount(array[i],k);
        }
        return result;
    }

    /**
     * 获取k在一个数中出现的次数
     * @param num
     * @param k
     * @return
     */
    private int getNumCount(int num,int k){
        int count = 0;
        String numStr = String.valueOf(num);
        char numChar[] = numStr.toCharArray();
        for(int i=0;i<numChar.length;i++){
            if(numChar[i]==String.valueOf(k).charAt(0)){
                count++;
            }
        }
        return count;
    }
}
