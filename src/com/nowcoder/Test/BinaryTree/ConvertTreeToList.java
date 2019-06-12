package com.nowcoder.Test.BinaryTree;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
/**这里注意的是，利用递归的思想，利用convert2Link我们将左右子树
 * 分别转换为链表，然后再与root节点链接成为一个完整的链表，
 * 返回的是中间节点，也就是我们传进去的root对应的节点，
 * 所以我们用下面循环讲root指向链表的开头
 * */
public class ConvertTreeToList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        pRootOfTree = convert2Link(pRootOfTree);
        while(pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }

    public  TreeNode convert2Link(TreeNode root){
        if(root == null ||(root.left == null && root.right == null));
        //tmp为每次递归时的辅助结点，递归得到最左子节点
        TreeNode tmp = null;
        if(root.left != null){
            tmp = convert2Link(root.left);
            while(tmp.right != null){
                tmp = tmp.right;
            }
            /**形成双向链表
             * 以.right表示双向链表的.next，
             * 以.left表示双向链表的.pre
             * */
            tmp.right = root;
            root.left = tmp;
        }
        if(root.right != null){
            tmp = convert2Link(root.right);
            while(tmp.left != null){
                tmp = tmp.left;
            }
            tmp.left = root;
            root.right = tmp;
        }
        return root;
    }
}
