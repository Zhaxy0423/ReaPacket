package com.nowcoder.test.Array;


/**
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是I am a student.
 */
public class ReverseSentence {
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
