package com.gp.linearList.linkedList.reverseList;


/**
 * Reverse Linked List   单向单链表反转
 *
 * @author lp
 * @since 2021-01-19 23:12:47
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        int count = 0;
        System.out.println("原始链表："+listListNode(head));
        ListNode pre = head;
        ListNode current = head.next;
        pre.next = null;
        System.out.println("第"+count+"轮:" +listListNode(pre));

        while (current != null){
            count++;
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
            System.out.println("第"+count+"轮:" +listListNode(pre));
        }
        return pre;
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
        reverseList(listNode1);
    }
}
