package com.nowcoder.Test.BinaryTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x; }
}

/**
 * 以前序遍历找到根节点，以中序遍历中的根节点分割左右子树
 * 循环判断条件为中序遍历是否到达最后一个结点
 */
public class ReConstructTree {
    //对输入前序、中序做非空处理
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre==null || in==null){
            return null;
        }
        TreeNode treeNode = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return treeNode;
    }
    //递归将分割的左右子树当做新的二叉树
    public static TreeNode reConstructBinaryTree(int [] pre,int preStart,int preEnd,int [] in,int inStart,int inEnd) {
        TreeNode root = new TreeNode(pre[preStart]);//前序遍历的第一个结点就是新二叉树的根节点
        root.left=null;
        root.right=null;
        if(preStart==preEnd && inStart==inEnd){
            return root;
        }
        for(int i=inStart;i<=inEnd;i++){
            //在中序遍历中找到根节点的位置，分割左右子树作为新的二叉树递归
            if(in[i]==pre[preStart]){
                if(i!=inStart){ //避免出现左子树为空
                    root.left=reConstructBinaryTree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                }//inStart是递增的，对应preStart和preEnd相对应变化
                if(i!=inEnd){ //避免出现右子树为空
                    root.right=reConstructBinaryTree(pre,i+1+preStart-inStart,preEnd,in,i+1,inEnd);
                }
                break;
            }
        }
        return root;
    }
}
