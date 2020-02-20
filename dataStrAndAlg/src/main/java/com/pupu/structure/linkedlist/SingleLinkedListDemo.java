package com.pupu.structure.linkedlist;

/**单链表，案例：水浒英雄排行榜
 * @author : lipu
 * @since : 2020-02-19 11:11
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //1、创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        //2、创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //3、加入链表
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);
        //3、按顺序加入链表
        singleLinkedList.addByorder(heroNode1);
        singleLinkedList.addByorder(heroNode4);
        singleLinkedList.addByorder(heroNode1);
        singleLinkedList.addByorder(heroNode2);
        singleLinkedList.addByorder(heroNode3);
        singleLinkedList.addByorder(heroNode2);
        //4、显示链表
        singleLinkedList.list();
        //5、修改一个节点.
        HeroNode heroNode = new HeroNode(1, "宋江", "及时雨~~~");
        singleLinkedList.update(heroNode);
        singleLinkedList.list();
        //6、删除一个节点.
        singleLinkedList.delete(4);
        singleLinkedList.delete(5);
        singleLinkedList.list();

        //7、获取链表中的有效个数
        System.out.println(getLength(singleLinkedList.getHead()));

        //8、获取倒数第二个节点
        findlastIndexNode(singleLinkedList.getHead(),2);

        //9、单链表反转
        System.out.println("原列表：");
        singleLinkedList.list();
        System.out.println("反转单链表表：");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
    }

    /**将单链表反转
     * @author lipu
     * @since  2020/2/19 17:40
     * @param
     * @return
    */
    public static void reverseList(HeroNode head){
        //空链表和只有一个节点的链表无需反转
        if(head.next == null || head.next.next == null ){return;}
        //定义辅助变量
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的前端
        while (cur != null){
            next = cur.next;//暂时保存当前节点的下一个节点
            cur.next=reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;
            cur = next;//让cur后移
        }
        //将head.next 指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    /**查找单链表中的倒数第 k 个结点 【新浪面试题】
     * 思路：
     *  1.编写一个方法，接收head节点，同时接收一个index
     *  2.index表示倒数第index个节点
     *  3.先把链表从头到尾遍历，得到链表的总长度
     *  4.得到size后，我们从链表的第一个开始遍历（size-index）个，就可以了
     *  5。找到返回结果，没有返回空
     * @author lipu
     * @since  2020/2/19 17:19
     * @param  head 链表的头节点
     * @return 
    */
    public static HeroNode findlastIndexNode(HeroNode head, int index){
        if(head.next == null){return null;}
        int size = getLength(head);
        if(index < 0 || index > size){return null;}
        //定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size -index ; i++) {
            cur = cur.next;
        }
        System.out.println("倒数第 "+index+" 个的节点为："+cur.toString());
        return cur;
    }

    /**获取单链表的节点个数（如果是带头节点的链表，需求：不统计头节点）
     * @author lipu
     * @since  2020/2/19 16:46
     * @param  head 链表的头节点
     * @return 返回有效节点的个数
     */
    public static int getLength(HeroNode head){
        if(head.next == null){return 0;}
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null){
            length ++ ;
            temp = temp.next;
        }
        return length;
    }
}

//定义class SingleLinkedList管理我们得英雄
class SingleLinkedList{
    //先初始化一个头节点，头接点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //1、添加节点到单向链表
    //思路：当不考虑编号顺序时，1、找到当前链表的最后节点；2、将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        System.out.println("向链表中加入的节点为："+heroNode.toString());

        //因为head节点不能动，因此我们需要一个辅助指针（变量）
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //找到链表最后
            if(temp.next == null){ break;}
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //退出while循环时，temp就指向了链表的最后，将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }

    //第二种方式：在添加英雄时，根据排名将英雄插入到指定位置（如果有这个排名，则添加失败，并给出提示）
    public void addByorder(HeroNode heroNode){
        System.out.println("向链表中加入的节点为："+heroNode.toString());

        //因为头节点不能动，因此我们需要一个辅助指针（变量）来帮助我们找到添加的位置
        //因为是单链表，因此我们找的temp是位于添加位置的前一个特节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        //遍历链表，找到最后
        while (true){
            //判断是否在链表最后
            if(temp.next == null){  break;}

            if(temp.next.no > heroNode.no){//位置找到，就在temp的后面插入
                break;
            }else if (temp.next.no == heroNode.no){//说明希望添加的heronode的编号依然存在
                flag = true;//true说明编号存在
                break;
            }
            //将temp后移,遍历当前链表
            temp = temp.next;
        }
        //判断flag
        if(flag){//不能添加说明编号已经存在
            System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n",heroNode.no);
        }else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //3、修改节点的信息，编号不变，修改名称和昵称
    public void update(HeroNode heroNode){
        //判断是否空
        if(head.next == null){throw new RuntimeException("链表为空");}
        //找到需要修改的节点，根据no编号
        //定义一个辅助的变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true){
            //遍历完
            if (temp == null) {break;}
            //找到
            if(temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //根据flag判断是否找到修改的节点
        if(flag){
            temp.name=heroNode.name;
            temp.nickname=heroNode.nickname;
            System.out.printf("修改编号为%d 的节点成功\n",heroNode.no);
        }else {//没有找到
            System.out.printf("没有找到编号%d 的节点,不能修改\n",heroNode.no);
        }
    }

    //4、删除节点的信息；
    //思路；1）head不能动，因此我们需要一个temp辅助节点找到待删除的前一个节点
    //     2）说明我们在在比较时，是temp.next.no和需要删除的节点的no比较
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除的节点
        while (true){
            //判断是否空
            if(head.next == null){throw new RuntimeException("链表为空");}
            //遍历完
            if (temp.next == null) {break;}
            //找到待删除的节点d的前一个节点
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //根据flag判断是否找到修改的节点
        if(flag){
            temp.next=temp.next.next;
            System.out.printf("删除编号%d 的节点成功\n",no);
        }else {//没有找到
            System.out.printf("没有找到编号%d 的节点,不能删除\n",no);
        }


    }
    //5、显示链表
    public void list(){
        //2.1判断链表是否为空
        if(head.next == null){throw new RuntimeException("链表为空");}

        //2.2 因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            if(temp == null){break;}
            //输出节点的信息
            System.out.println(temp.toString());
            //将节点的后移
            temp = temp.next;
        }

    }


}


//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;//排名
    public String name;//姓名
    public String nickname;//昵称
    public HeroNode next;//下一名水浒英雄

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了方便重新toString
    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + "'}";
    }
}