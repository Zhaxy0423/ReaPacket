package com.nowcoder;

import java.util.*;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine();
        System.out.println(str.length());
        System.out.println(ReverseSentence(str));
    }
    public static String ReverseSentence(String str) {
        if(str.trim().length()==0){
            return str;
        } else{
            String[] sentence = str.split(" ");
            String result = "";
            for(int i=sentence.length-1;i>0;i--){
                result=result+sentence[i]+" ";
            }
            str = result+sentence[0];
            return str;
        }
    }
}


