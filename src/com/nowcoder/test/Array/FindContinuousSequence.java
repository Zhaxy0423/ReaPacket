package com.nowcoder.test.Array;
import java.util.ArrayList;

/**
 * 找出所有和为S的连续正数序列
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for(int i=1;i<sum;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            int s=0;
            for(int j=i;j<sum;j++){
                if(s<sum){
                    s=s+j;
                    arr.add(j);
                    if(s==sum){
                        arrayLists.add(arr);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return arrayLists;
    }
}
/**
 *  方法二：初始状态下，small指向1，big指向2。如果从small到big的和大于S，则从序列中去掉较小的值，
 *  也就是small向后移动一个位置。若从small到big的序列和小于S，则big向后移动一个位置，以便序列包含更多的数字。
 *
 *     public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
 *         ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
 *         if(sum<=1){return lists;}
 *         int small=1;
 *         int big=2;
 *         while(small!=(1+sum)/2){          //当small==(1+sum)/2的时候停止
 *             int curSum=sumOfList(small,big);
 *             if(curSum==sum){
 *                 ArrayList<Integer> list=new ArrayList<Integer>();
 *                 for(int i=small;i<=big;i++){
 *                     list.add(i);
 *                 }
 *                 lists.add(list);
 *                 small++;big++;
 *             }else if(curSum<sum){
 *                 big++;
 *             }else{
 *                 small++;
 *             }
 *         }
 *         return lists;
 *     }
 *     //计算当前序列的和
 *     public int sumOfList(int head,int leap){
 *         int sum=head;
 *         for(int i=head+1;i<=leap;i++){
 *             sum+=i;
 *         }
 *         return sum;
 *     }
 */