package com.gp.demo07_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lp
 * @since 2021-01-25 10:05:44
 */
public class Demo01_PreOrder2 {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            //先压如右边，能保证陷入后出
            if (node.right != null) stack.push(node.right);

            if (node.left != null) stack.push(node.left);
        }
        return result;
    }
}
