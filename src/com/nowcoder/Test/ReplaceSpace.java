package com.nowcoder.Test;

public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        String text = "%20";
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i)==' '){
                str.deleteCharAt(i);
                str.insert(i+0,text);
            }
            n = str.length();
        }
        return str.toString();
    }

}
