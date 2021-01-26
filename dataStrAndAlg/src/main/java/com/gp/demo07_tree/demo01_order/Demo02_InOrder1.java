package com.gp.demo07_tree.demo01_order;

import com.gp.demo07_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lp
 * @since 2021-01-25 10:24:36
 */
public class Demo02_InOrder1 {

    /**
     * @param root: A Tree
     *
     * @return: in-order traversal in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        //这里设计的秒，刚好跳出递归
        if(root == null) return result;

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        result.addAll(left);
        result.add(root.val);

        //通过是否修改原有集合来返回true或者false
        boolean b = result.addAll(right);
        System.out.println(result);
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


        System.out.println(new Demo02_InOrder2().inorderTraversal(treeNode8));
    }
}
