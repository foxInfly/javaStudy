package com.gp.linearList.linkedList.demo01_reverseList;


/**
 * Reverse Linked List   单向单链表反转2
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * @author lp
 * @since 2021/1/20 10:59
 **/
public class ReverseLinkedList2 {

    /**
     * 反转从位置 m 到 n 的链表
     * @param head 链表头节点
     * @param m 开始节点位置
     * @param n 结束节点位置
     */
    public static ListNode reverseList(ListNode head,int m, int n) {
        if (head == null || m >= n) {
            return null;
        }
        int count = 0;
        System.out.println("原始链表："+listListNode(head));

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        //找到开始位置的前一个节点,此节点不参与反转，会执行反转后的第一个
        for (int i = 1; i < m; i++) {
            head = head.next;
            System.out.println("处理后链表："+listListNode(head));
        }

        ListNode preM = head;
        ListNode mNode = head.next;//开始节点
        ListNode nNode = mNode;//结束节点
        ListNode postN = nNode.next;//需要反转的节点

        for (int i = m; i < n; i++) {
            count++;
            ListNode next = postN.next;//下一个需要反转的节点
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }

        mNode.next = postN;
        preM.next = nNode;
        System.out.println("第"+count+"轮:" +listListNode(preM));
        return dummy.next;
    }

    public static String listListNode(ListNode head){
        StringBuilder sb = new StringBuilder();
        while (head.next != null){
            sb.append(head.val).append("->").append(head.next.val).append(" ");
            head = head.next;
        }
        sb.append(head.val).append("->nul");
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        reverseList(listNode1,2,4);
    }
}
