package com.gp.demo01_linearList.linkedList.demo02_copyListwithrandomPointer;

/**
 * copy list with random pointer 2
 *
 * @author lp
 * @since 2021-01-21 10:29:32
 */
public class CopyListWithRandomPointer2 {

    public static ListNodeWithRandomPointer copyRandomList(ListNodeWithRandomPointer head) {
        if (head == null) {
            return null;
        }
        System.out.println("原始链表：" + listListNode(head));

        copy(head);
        copyRandom(head);
        System.out.println("复制链表：" + listListNode(split(head)));
        return split(head);
    }

    private static ListNodeWithRandomPointer split(ListNodeWithRandomPointer head) {
        ListNodeWithRandomPointer result = head.next;
        ListNodeWithRandomPointer move = head.next;
        while (head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
            if (move != null && move.next != null) {
                move.next = move.next.next;
                move = move.next;
            }
        }
        return result;
    }

    private static void copy(ListNodeWithRandomPointer head) {
        ListNodeWithRandomPointer node = head;//临时值，用于存储当前node
        while (node != null) {
            ListNodeWithRandomPointer copy = new ListNodeWithRandomPointer(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
    }

    private static void copyRandom(ListNodeWithRandomPointer head) {
        ListNodeWithRandomPointer node = head;//临时值，用于存储当前node
        while (node != null && node.next != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }


    public static String listListNode(ListNodeWithRandomPointer head) {
        StringBuilder sb = new StringBuilder();
        while (head.next != null) {
            sb.append(head.val).append("->").append(head.next.val);
            if (head.random != null) {
                sb.append("->").append(head.random.val);
            }
            sb.append(" ");
            head = head.next;
        }
        sb.append(head.val).append("->nul");
        return sb.toString();
    }


    public static void main(String[] args) {
        ListNodeWithRandomPointer listNode3 = new ListNodeWithRandomPointer(3);
        ListNodeWithRandomPointer listNode2 = new ListNodeWithRandomPointer(2);
        ListNodeWithRandomPointer listNode1 = new ListNodeWithRandomPointer(1);
        listNode1.next = listNode2;
        listNode1.random = listNode3;
        listNode2.next = listNode3;

        copyRandomList(listNode1);

    }
}
