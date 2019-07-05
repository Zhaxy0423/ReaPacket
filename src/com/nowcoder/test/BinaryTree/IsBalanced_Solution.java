package com.nowcoder.test.BinaryTree;

/**
 * 判断二叉树是否为平衡二叉树：左右子树的高度差不大于1，且左右子树均为平衡二叉树。
 * 方法一：有一个缺陷，就是每判断一棵树就要遍历一遍树种的节点；来计算树的高度，这样下来，整个判断过程，每个节点不止被遍历过一次了
 *
 * 方法二： 如果我们用后序遍历的方式遍历二叉树的每个结点，在遍历一个结点之前我们就已经遍历了它的左右子树。
 * 只要在遍历每个结点的时候我们记录它的深度（某一节点的深度等于它到叶结点的路径的长度），
 * 我们就可以一边遍历一边判断每个结点是不是平衡二叉树。
 */
public class IsBalanced_Solution {
    private boolean isBalanced = false;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root) {
        if(root == null) {
            isBalanced = true;
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int depth = (left > right ? left : right) + 1;
        if(Math.abs(left - right) <= 1) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }
        return depth;
    }

}
/**
 *    public boolean IsBalanced_Solution(TreeNode root) {
 *         if(root==null){
 *             return true;
 *         }
 *         if(Math.abs(getTreeDepth(root.left)-getTreeDepth(root.right))<=1){
 *             return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
 *         }else{
 *             return false;
 *         }
 *     }
 *     public int getTreeDepth(TreeNode root) {
 *           int depth;
 *           if(root==null){
 *               return 0;
 *           }else{
 *               int leftDepth=getTreeDepth(root.left);
 *               int rightDepth=getTreeDepth(root.right);
 *              depth = leftDepth > rightDepth ? leftDepth+1 :rightDepth+1;
 *           }
 *          return depth;
 *      }
 */

