package com.nowcoder.test.Array;

/**
 *对于一个给定的字符序列S，请你把其循环左移n位后的序列输出
 * 其他方法：将两个相同字符串拼接，然后从第K位开始取length个
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str.length()==0){
            return str;
        }else if(n==0){
            return str;
        }else{
            char[] charStr = str.toCharArray();
            char[] temp = new char[n];
            for(int i=0;i<n;i++){
                temp[i]=charStr[i];
            }
            for(int i=0;i<charStr.length-n;i++){
                charStr[i]=charStr[i+n];
            }
            for(int i=charStr.length-n;i<charStr.length;i++){
                charStr[i]=temp[i-charStr.length+n];
            }
            return String.valueOf(charStr);
        }
    }
}
