package com.nowcoder.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 渣小宇
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int index = 0;
        if(str.length()==0){
            index = -1;
        }else{
            HashMap<Character,Integer> hashMap = new LinkedHashMap<Character,Integer>(str.length());
            for(char c:str.toCharArray()){
                if(!hashMap.containsKey(c)){
                    hashMap.put(c,1);
                }else{
                    hashMap.put(c,hashMap.get(c)+1);
                }
            }
            for(Map.Entry<Character, Integer> entry : hashMap.entrySet()){
                if(entry.getValue()==1){
                    for(int i=0;i<str.length();i++){
                        if(entry.getKey()==str.charAt(i)){
                            index=i;
                        }
                    }
                    break;
                }
            }
        }
        return index;
    }
}
