package com.gp.linearList.linkedList.addTwoNumbers;

/** add two list
 * @author lp
 * @since 2021-01-21 14:12:57
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int carry = 0;//进位
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null){
            int number = l1.val + l2.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number % 10);
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int number = l1.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number % 10);
            pre = pre.next;
            l1 = l1.next;
        }

        while (l2 != null){
            int number = l2.val + carry;
            carry = number / 10;
            pre.next = new ListNode(number % 10);
            pre = pre.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return head.next;
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
        ListNode listNode1 = new ListNode(2)
                .setNext(new ListNode(4)
                        .setNext(new ListNode(3)));
        ListNode listNode2 = new ListNode(5)
                .setNext(new ListNode(6)
                        .setNext(new ListNode(4)));
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        String s = listListNode(listNode);
        System.out.println(s);
    }
}
