package com.gp.demo07_tree;

/** 二叉树
 * @author lp
 * @since 2021-01-25 10:09:07
 */
public class TreeNode {
    int val;//值
    TreeNode left;//左子节点
    TreeNode right;//右子节点

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
