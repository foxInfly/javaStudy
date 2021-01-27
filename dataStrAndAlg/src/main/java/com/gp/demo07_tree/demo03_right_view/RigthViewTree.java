package com.gp.demo07_tree.demo03_right_view;

import com.gp.demo07_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @author lp
 * @since 2021/1/27 10:16
 **/
public class RigthViewTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean findRight;
        while (!queue.isEmpty()) {
            int size = queue.size();
            findRight = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!findRight) {
                    result.add(node.val);
                    findRight = true;
                }
                // 4 5
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5,treeNode6,treeNode7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3,treeNode4,treeNode5);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println(new RigthViewTree().rightSideView(treeNode1));
    }
}