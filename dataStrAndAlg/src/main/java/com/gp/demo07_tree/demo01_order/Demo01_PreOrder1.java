package com.gp.demo07_tree.demo01_order;

import com.gp.demo07_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  前序遍历1
 * @author lp
 * @since 2021/1/25 10:11
 **/
public class Demo01_PreOrder1 {
    /**
     * @param root: A Tree
     * @return: Pre-order traversal in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode5 = new TreeNode(5, treeNode1, treeNode7);
        TreeNode treeNode10 = new TreeNode(10, treeNode9, treeNode12);
        TreeNode treeNode8 = new TreeNode(8, treeNode5, treeNode10);


        System.out.println(new Demo01_PreOrder2().preorderTraversal(treeNode8));
    }
}