package com.nowcoder;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[][]=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int b[] = new int [n*m];
        int c[] = new int [n*m];
        int d[] = new int [n*m];
        int k=0;
        int x=a[0][0];
        int y=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[k]=a[i][j];
                k++;
            }
        }
        for(int i=0;i<n*m;i++){
            if(x!=b[i]){
                y=b[i];
            }
        }

        for(int i=0;i<n*m;i=i+2){
            c[i]=x;
        }
        for(int i=1;i<n*m-1;i=i+2){
            c[i]=y;
        }
        for(int i=0;i<n*m;i++){
            d[i]=b[i]-c[i];
            if(d[i]==0){
                count++;
            }
        }
        System.out.println(n*m-count);
    }
}


