package com.nowcoder.Test;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        int ugly[] = new int[index];
        if(index==0){
            return 0;
        }else{
            ugly[0]=1;
            int p2=0;
            int p3=0;
            int p5=0;
            int uglyIndex = 1;
            while(uglyIndex<index){
                //只需找到只能被2、3、5整除的数即可
                int min=min(ugly[p2]*2,ugly[p3]*3,ugly[p5]*5);
                //丑数数组
                ugly[uglyIndex]=min;//与前一个丑数相比移动指针
                while(ugly[p2]*2<=ugly[uglyIndex]){
                    p2++;
                }
                while(ugly[p3]*3<=ugly[uglyIndex]){
                    p3++;
                }
                while(ugly[p5]*5<=ugly[uglyIndex]){
                    p5++;
                }
                uglyIndex++;
            }
            return ugly[index-1];
        }

    }
    private int  min(int a,int b,int c){
        if(a<=b&&a<=c){
            return a;
        }
        if(b<=a&&b<=c){
            return b;
        }
        return c;
    }
}
