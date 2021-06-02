package com.gp.demo07_tree.demo04_lowestCommon;

import com.gp.demo07_tree.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *
 * @author lp
 * @since 2021/1/27 10:42
 **/
public class LowestCommonTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
            if(root == null || root == A || root == B)  return root;

            TreeNode left = lowestCommonAncestor(root.left, A, B);
            TreeNode right = lowestCommonAncestor(root.right, A, B);
            if (left != null && right != null) return root;

            if (left != null) return left;

            if (right != null)  return right;

            return null;
        
    }
}
