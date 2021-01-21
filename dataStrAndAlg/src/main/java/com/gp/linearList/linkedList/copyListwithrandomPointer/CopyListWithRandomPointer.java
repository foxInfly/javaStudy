package com.gp.linearList.linkedList.copyListwithrandomPointer;

import com.gp.linearList.linkedList.reverseList.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * copy list with random pointer
 *
 * @author lp
 * @since 2021-01-21 10:29:32
 */
public class CopyListWithRandomPointer {

    public static ListNodeWithRandomPointer copyRandomList(ListNodeWithRandomPointer head){
        if (head == null) {
            return null;
        }

        Map<ListNodeWithRandomPointer,ListNodeWithRandomPointer> map = new HashMap<>();
        ListNodeWithRandomPointer newHead = head;
        System.out.println("原始链表："+listListNode(head));

        while (newHead != null) {
            if (!map.containsKey(newHead)) {
                ListNodeWithRandomPointer copyNode = new ListNodeWithRandomPointer(newHead.val);
                map.put(newHead, copyNode);
            }

            if (newHead.random != null) {
                ListNodeWithRandomPointer random = newHead.random;
                if (!map.containsKey(random)) {
                    ListNodeWithRandomPointer copyRandom = new ListNodeWithRandomPointer(random.val);
                    map.put(random, copyRandom);
                }
                map.get(newHead).random = map.get(newHead.random);
            }
            map.get(newHead).next = newHead.next;
            newHead = newHead.next;
        }

//        newHead = head;
//        while (newHead != null){
//            ListNodeWithRandomPointer next = newHead.next;
//            map.get(newHead).next = map.get(next);
//            newHead = newHead.next;
//        }
        System.out.println("复制链表："+listListNode(map.get(head)));
        return map.get(head);
    }

    public static String listListNode(ListNodeWithRandomPointer head){
        StringBuilder sb = new StringBuilder();
        while (head.next != null){
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
