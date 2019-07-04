package com.nowcoder.test;


public class Find {
    public  boolean Find(int target, int [][] array) {
        int a[] = new int[array.length*array[0].length];
        int k=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                a[k]=array[i][j];
                k++;
            }
        }
        for(int i=0;i<a.length;i++){
            if(target!=a[i]){
                continue;
            }else{
                return true;
            }
        }
        return false;
    }
}
