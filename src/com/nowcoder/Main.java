package com.nowcoder;

import java.util.*;

public class Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int array[]=new int[8];
        for(int i=0;i<8;i++){
            array[i]=sc.nextInt();
        }
        System.out.println(InversePairs(array));
    }
    public static int InversePairs(int [] array) {
        int p=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    p++;
                }
            }
        }
        return p%1000000007;
    }
}


