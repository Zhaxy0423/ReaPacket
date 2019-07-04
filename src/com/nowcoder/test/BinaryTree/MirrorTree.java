package com.nowcoder.test.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorTree {
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        //如果树为 null 直接返回。否则将根节点入队列。
        Queue<TreeNode> queue= new LinkedList<TreeNode>() ;
        queue.add(root);
        while(!queue.isEmpty())
        {
            //队列不为空时，节点出队，交换该节点的左右子树。
            TreeNode root1=queue.poll();
            TreeNode temp;
            temp=root1.left;
            root1.left=root1.right;
            root1.right=temp;
            //已交换完
            if(root1.right!=null)
            {
                queue.add(root1.right);
                //如果左子树不为 null 入队
            }
            if(root1.left!=null)
            {
                queue.add(root1.left);
                //如果右子树不为 null 入队。
            }
        }
    }
}
/**
 *    public void Mirror(TreeNode root) {
 *         if(root==null){
 *             return;
 *         }
 *         TreeNode temp;
 *         temp=root.left;
 *         root.left=root.right;
 *         root.right=temp;
 *         Mirror(root.left);
 *         Mirror(root.right);
 *     }
 * */