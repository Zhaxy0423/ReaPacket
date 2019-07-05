package com.nowcoder.test.BinaryTree;

import java.util.LinkedList;

/**
 * @author 渣小宇
 * 二叉树的深度：层次遍历实现(借助队列实现)
 * 设置变量level记录当前节点所在的层数，设置变量last指向当前层的最后一个节点，当处理完当前层的最后一个节点，
 * 让level指向+1操作。设置变量cur记录当前层已经访问的节点的个数，当cur等于last时，表示该层访问结束。
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        int depth=0;
        if(root==null){
            return 0;
        }
        TreeNode current ;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur,last;
        while(!queue.isEmpty()){
            cur=0;
            last=queue.size();
            while(cur<last){
                current=queue.poll();
                cur++;
                if(current.left!=null){
                    queue.offer(current.left);
                }
                if(current.right!=null){
                    queue.offer(current.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
/**
 * 递归方法
 *    public int TreeDepth(TreeNode root) {
 *         int depth;
 *         if(root==null){
 *             return 0;
 *         }else{
 *             int leftDepth=TreeDepth(root.left);
 *             int rightDepth=TreeDepth(root.right);
 *             depth = leftDepth > rightDepth ? leftDepth+1 :rightDepth+1;
 *         }
 *         return depth;
 *     }
 */
