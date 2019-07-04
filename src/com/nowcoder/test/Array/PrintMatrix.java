package com.nowcoder.test.Array;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
import java.util.ArrayList;

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int hCount=matrix.length;//行数
        int lCount=matrix[0].length;//列数
        //数组元素只有一个的特殊情况
        if(hCount==1&&lCount==1){
            result.add(matrix[0][0]);
        }
        if(matrix==null||hCount<=0||lCount<=0){
            return null;
        }
        if(hCount!=1||lCount!=1){
            int start=0;//每一圈的起始位置(start,start)
            while(lCount>start*2 && hCount>start*2){
                printMatrix(result,matrix,lCount,hCount,start);
                ++start;
            }
        }

        return result;
    }
    private void printMatrix(ArrayList<Integer> result,int [][] matrix,int lCount,int hCount,int start){
        //行列终点位置
        int endX = lCount - 1 - start;
        int endY = hCount - 1 - start;
        for(int i=start;i<=endX;++i){
            result.add(matrix[start][i]);
        }
        //第一行之后往下行数增加1
        if(start<endY){
            for(int i=start+1;i<=endY;++i){
                result.add(matrix[i][endX]);
            }
        }
        //最后一列之后往左列数减1
        if(start < endX && start < endY){
            for (int i = endX-1; i >= start; --i) {
                result.add(matrix[endY][i]);
            }
        }
        //第一列之后行数列数均减1
        if(start < endX && start < endY - 1){
            for (int i = endY-1; i >= start + 1; --i) {
                result.add(matrix[i][start]);
            }
        }


    }
}
