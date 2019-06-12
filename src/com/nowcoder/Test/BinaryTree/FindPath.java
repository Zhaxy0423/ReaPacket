package com.nowcoder.Test.BinaryTree;
/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
import java.util.ArrayList;

public class FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return listAll;
        }
        //保存路径上的当前节点
        list.add(root.val);
        //减去当前结点的值直到叶子结点处判断是否为0
        target=target-root.val;
        //叶子结点处将遍历的路径数组添加到总数组中
        if(target==0&&root.left==null&&root.right==null){
            //使用list对新对象实例初始化赋值
            listAll.add(new ArrayList<>(list));
        }
        //前序遍历二叉树
        FindPath(root.left,target);
        FindPath(root.right,target);
        //移除最末尾的结点，当前节点为叶子节点或者已经访问过的情况下，回溯到父节点
        list.remove(list.size()-1);
        return listAll;
    }

}
