package com.nowcoder.Test;


import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 列出所有字符串用递归求解。
 * 处理字符串中的字母应转换成字符数组
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();//根据返回类型需要
        if(str==null||str.length()==0){
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> res = new TreeSet<String>(); //用于排序输出
        getResult(chars,0,str.length()-1,res);
        result.addAll(res) ;//添加到ArrayList
        return result ;
    }

    public void getResult(char[] chars,int start,int end,TreeSet<String> res){

        if(start==end){
            res.add(String.valueOf(chars));
        }else{
            for(int i=start;i<=end;i++){
                swap(chars,start,i);//换一位
                //递归0和0，1,2,3，...交换，之后1和1，2，..交换
                getResult(chars,start+1,end,res);//递归
                swap(chars,start,i);//换回来，保证下次换位是正确的
            }
        }
    }

    public void swap(char[] chars,int a,int b){
        if(a==b){//因为会出现原位置与原位置交换，直接空即可

        }else{
            char temp = chars[a];
            chars[a]=chars[b];
            chars[b]=temp;
        }
    }
}
