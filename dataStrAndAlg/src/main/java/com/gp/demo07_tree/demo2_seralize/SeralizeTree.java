package com.gp.demo07_tree.demo2_seralize;

import com.gp.demo07_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树序列化
 *
 * @author lp
 * @since 2021/1/26 17:02
 **/
public class SeralizeTree {

    /**
     * 1.Encodes a tree to a single string.
     *
     * @param root tree
     */
    public String serialize(TreeNode root) {
        if (root == null) return "{}";

        //用于存储所有的节点
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        // 1.用前序遍历后，把所有的节点存入到list集合中
        // [1,2,3,null,null,4,5,null,null,null,null]
         for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);

            if (node == null) continue;

            //先左后右把所有的节点前序遍历后放入list
            list.add(node.left);
            list.add(node.right);
        }

        // 2.把最后一行未null的全部去掉
        // [1,2,3,null,null,4,5]
        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }

        StringBuilder sb = new StringBuilder("{");
        sb.append(list.get(0).val);
        // 3.把list变成字符串
        // {1,2,3,#,#,4,5}
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",").append(list.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // 2.Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}"))  return null;

        // 1.String[] data 1 2 3 # # 4 5
        String[] datas = data.substring(1, data.length() - 1).split(",");
        boolean isLeft = true;

        List<TreeNode> queue = new ArrayList<>();
        TreeNode node = new TreeNode(Integer.parseInt(datas[0]));
        queue.add(node);
        int index = 0;
        for (int i = 1; i < datas.length; i++) {
            if (!datas[i].equals("#")) {
                TreeNode node1 = new TreeNode(Integer.parseInt(datas[i]));
                if (isLeft) {
                    queue.get(index).left = node1;
                } else {
                    queue.get(index).right = node1;
                }
                queue.add(node1);
            }

            if (!isLeft) index++;

            isLeft = !isLeft;
        }
        return queue.get(0);
    }

    public static void main(String[] args) {
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(5,treeNode6,treeNode7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3,treeNode4,treeNode5);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);

        System.out.println(new SeralizeTree().serialize(treeNode1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
