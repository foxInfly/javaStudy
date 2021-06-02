package com.gp.demo07_tree.demo05_balance_tree;

import com.gp.demo07_tree.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * @author lp
 * @since 2021/1/27 10:47
 **/
public class BalanceBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return maxTree(root) != -1;
    }

    public int maxTree(TreeNode node) {
        if (node == null) return 0;

        int left = maxTree(node.left);
        int right = maxTree(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

}