package com.nowcoder.Test.Array;

import java.util.ArrayList;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        if(numbers.length==0){
            return "";
        }else if(numbers.length==1){
            return numbers[0]+"";
        }else{
            newArray(list,numbers,0,numbers.length-1);
            long min=Long.parseLong(list.get(0));
            for(int i=1;i<list.size();i++){
                if(min- Long.parseLong(list.get(i))>=0){
                    min=Long.parseLong(list.get(i));
                }
            }
            return min+"";
        }
    }
    private void newArray(ArrayList<String> list,int numbers[],int start,int end){
        String sum="";
        if(start==end){
            for(int j=0;j<=end;j++){
                sum=sum+numbers[j];
            }
            list.add(sum);
        }
        for(int i=start;i<=end;i++){
            swap(numbers,start,i);
            newArray(list,numbers,start+1,end);
            swap(numbers,start,i);
        }

    }
    private void swap(int[] numbers,int a,int b){
        int tmp;
        if(a==b){

        }else{
            tmp=numbers[a];
            numbers[a]=numbers[b];
            numbers[b]=tmp;
        }
    }
}
