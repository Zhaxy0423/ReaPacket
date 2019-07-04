package com.nowcoder.test.BinaryTree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果
 *
 * 二叉搜索树：左子树的所有结点小于根结点 && 右子树的所有结点大于根节点；
 *
 * 二叉搜搜索树的后序遍历：遍历的最后一个元素是树的根节点；
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length<=0){
            return false;
        }else{
            return isBSTree(sequence,0,sequence.length-1);
        }
    }
    private boolean isBSTree(int[] array,int start,int end){
        //切分数组成左右子树两部分，递归知道子数组中所有元素都满足二叉搜索树的条件
        if(start>=end){
            return true;
        }
        int root=array[end];
        int i=start;
        //左子树节点均小于根节点
        while(array[i]<root){
            i++;
        }
        //右子树节点均大于根节点
        int j=i;
        //循环条件变为end终止
        while(j<end){
            if(array[j]<root){
                return false;
            }
            j++;
        }
        boolean left=isBSTree(array,start,i-1);
        boolean right=isBSTree(array,i,end-1);
        return left && right;
    }
}
