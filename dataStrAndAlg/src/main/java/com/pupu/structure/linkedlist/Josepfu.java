package com.pupu.structure.linkedlist;

import lombok.Data;

/**Josepfu约瑟夫问题
/**Josepfu约瑟夫问题
 * @author : lipu
 * @since : 2020-02-20 15:27
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.show();

        //测试小孩出圈是否正确
        list.countBoy(1,2,5);
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("nums的值不正确");return;
        }

        Boy curBoy = null; //辅助指针，帮助构建环形链表
        //是用for循环创建我们得环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环形链表
                curBoy = first;//让curBoy直行第一个小孩
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历环形链表
    public void show(){
        //判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~~");return;
        }
        //因first不能动，因此我们仍然使用一个辅助指针完成
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号为："+curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
        System.out.println("遍历结束~~~");
    }

    /**根据用户的输入，计算出小孩除权的顺序
     * @author lipu
     * @since  2020/2/20 15:52
     * @param startNo 从第几个小孩开始数数
     * @param countNum 数几下
     * @param nums 最初有多少小孩在圈中
    */
    public void countBoy(int startNo, int countNum, int nums){
        System.out.println(nums+"个小孩，从第 "+startNo+"个小孩开始数数，数到 "+countNum+"，的个小孩出圈 ");
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");return;
        }
        //创建辅助指针，帮助完成小孩出圈
        Boy helper = first;
        //让辅助指针事先指向环形链表的最后这个节点
        while (true){
            if (helper.getNext() == first) {break; }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int j = 0; j < startNo -1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true){
            if (helper == first) {break;}
            //让first和helper指针同时移动m-1次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.println(first.getNo()+"编号的小孩出圈；");
            first = first .getNext();
            helper.setNext(first);
        }
        System.out.println(first.getNo()+"编号的小孩最后出圈；");
    }

}


//创建一个Boy类，表示一个节点
@Data
class Boy{
    private int no; //编号
    private Boy next;//指向下一个节点，默认null

    public Boy(int no) {this.no = no;}
}
