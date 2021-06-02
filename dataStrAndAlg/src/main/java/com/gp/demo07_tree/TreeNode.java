package com.gp.demo07_tree;


/** 二叉树
 * @author lp
 * @since 2021-01-25 10:09:07
 */
public class TreeNode {
    public int val;//值
    public TreeNode left;//左子节点
    public TreeNode right;//右子节点

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
