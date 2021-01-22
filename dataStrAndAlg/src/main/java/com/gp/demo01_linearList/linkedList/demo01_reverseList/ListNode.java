package com.gp.demo01_linearList.linkedList.demo01_reverseList;

import lombok.Data;

/**单向单链表
 * @author lp
 * @since 2021-01-19 23:22:04
 */
@Data
public class ListNode {
    //属性
    int val;
    //指向下一个节点的索引（指针）
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
