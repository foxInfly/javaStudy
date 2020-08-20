package com.pupu.alt.tree;

        import lombok.Getter;
        import lombok.Setter;

/**二叉树
 * @author : lipu
 * @since : 2020-02-23 19:38
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //1.创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //2.添加节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //3.先手动创建二叉树，后面学习递归创建二叉树
        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        //测试
        System.out.println("前序遍历：");
        binaryTree.preOrder();
        System.out.println("中序遍历：");
        binaryTree.infixOrder();
        System.out.println("后序遍历：");
        binaryTree.postOrder();
    }
}


//定义一个二叉树
@Setter
class BinaryTree{
    private HeroNode root;

    //前序遍历
    public void preOrder(){
        if (this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("当前二叉树为空，无法遍历");
        }
    }

}

//heroNode水浒英雄节点
@Getter
@Setter
class HeroNode{
    private int no;//编号
    private String name;//姓名
    private HeroNode left;//默认null
    private HeroNode right;//默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +"no=" + no +", name='" + name + '\'' +'}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);//先输出父节点
        //向左递归
        if (this.left != null) {
            this.left.preOrder();
        }
        //向右递归
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        //向左递归
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);//先输出父节点
        //向右递归
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        //向左递归
        if (this.left != null) {
            this.left.postOrder();
        }
        //向右递归
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);//先输出父节点
    }
}

