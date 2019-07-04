package com.nowcoder.test;

import java.util.ArrayList;

/**
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        ArrayList<String> list = new ArrayList<>();
        int result=0;
        if(n==1){
            result=1;
        }else{
            for(int i=1;i<=n;i++){
                list.add(i+"");
                char chars[] = list.get(i-1).toCharArray();
                for(int j=0;j<chars.length;j++){
                    if(chars[j]=='1'){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
