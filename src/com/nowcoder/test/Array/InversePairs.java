package com.nowcoder.test.Array;

/**
 * @author 渣小宇
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 *
 * 如果遍历数组，对每个数字都和后面的数字比较大小，时间复杂度为O(n^2)，效率太低。
 * 利用归并排序的思想，先将数组分解成为n个长度为1的子数组，然后进行两两合并同时排好顺序。
 * 在对两个子区域合并排序时，记左边区域（下标为start~mid）的指针为i，右边区域（下标为mid+1~end）的指针为j，两个指针都指向该区域内最大的数字，排序时：
 * （1）如果i指向的数字大于j指向的数字，说明：逆序对有j-mid个，我们把i指向的数字放入临时创建的排序数组中，然后令i-1，指向该区域前一个数字，继续进行排序；
 * （2）如果i指向的数字小于等于j指向的数字，说明暂时不存在逆序对，将j指向的数字放入临时创建的排序数组中，然后令j-1，指向该区域前一个数字，继续进行排序；
 * （3）某一子区域数字都放入排序数组后，将另一个子区域剩下的数字放入排序数组中，完成排序；
 * （4）最后将排序好的数字按顺序赋值给原始数组的两个子区域，以便合并后的区域与别的区域合并。
 * （5）需要在方法中考虑count过大时对其取模的问题。p%1000000007
 */
public class InversePairs {
    public int InversePairs(int [] array) {
        int p=0;
        if(array ==null || array.length==0){
            p=0;
        }else{
            p=getCount(array,0,array.length-1);
        }
        return p;
    }
    private int getCount(int[] array,int start,int end){
        if(start>=end){
            return 0;
        }
        int mid = (start+end)/2;
        int left = getCount(array,start,mid)%1000000007;
        int right = getCount(array,mid+1,end)%1000000007;
        int count =0;
        int i=mid;
        int j=end;
        int temp[] = new int[end-start+1];
        int k=end-start;
        while(i>=start && j>=mid+1){
            if(array[i]>array[j]){
                count = count+j-mid;
                temp[k--]=array[i--];
                if(count>=1000000007)
                {
                    count%=1000000007;
                }
            }else{
                temp[k--]=array[j--];
            }
        }
        while(i>=start){
            temp[k--]=array[i--];
        }
        while(j>=mid+1){
            temp[k--]=array[j--];
        }
        for(k=0;k<temp.length;k++){
            array[k+start]=temp[k];
        }
        return (count+left+right)%1000000007;
    }
}
