package com.nowcoder.test.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
           return result;
        }else{
            queue.add(root);
            TreeNode node;
            //如果左右子节点不为空，则将其入队，在分别判断其是否为空的情况
            while(!queue.isEmpty()){
                node =queue.peek();
                queue.poll();
                result.add(node.val);
                if (node.left != null ) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            return result;
        }

    }

}
