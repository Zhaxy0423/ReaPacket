package com.nowcoder.Test.BinaryTree;
/**
 * 要查找树A是否存在和树B结构一样的子树，我们可以分成两步：
 * 第一步在树A中找到和树B的根节点的值一样的节点R，
 * 第二步再判断树A中以R为根节点的子树是不是包含和树B一样的结构。
 */
public class HasSubtree {
    public static boolean HasSubTree(TreeNode root1, TreeNode root2)
    {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = DoesTree1HasTree2(root1, root2);
            }
            // 从根节点的左子树开始匹配Tree2
            if (!result) {
                result = HasSubTree(root1.left, root2);
            }
            // 如果左子树没有匹配成功则继续在右子树中继续匹配Tree2
            if (!result) {
                result = HasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    private static boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            // 证明Tree2已经遍历结束，匹配成功
            return true;
        }
        if (root1 == null) {
            // 证明Tree1已经遍历结束，匹配失败
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        // 递归验证左子树和右子树是否包含Tree2
        return DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
    }
}
