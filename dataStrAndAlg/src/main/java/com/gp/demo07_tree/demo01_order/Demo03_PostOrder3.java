package com.gp.demo07_tree.demo01_order;

import com.gp.demo07_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lp
 * @since 2021-01-25 10:24:54
 */
public class Demo03_PostOrder3 {

    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null && node.left == null) {
                result.add(stack.pop().val);
            }
            if (node.right != null) {
                stack.push(node.right);
                node.right = null;
            }
            if (node.left != null) {
                stack.push(node.left);
                node.left = null;
            }
        }
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


        System.out.println(new Demo03_PostOrder3().postorderTraversal(treeNode8));
    }
}
