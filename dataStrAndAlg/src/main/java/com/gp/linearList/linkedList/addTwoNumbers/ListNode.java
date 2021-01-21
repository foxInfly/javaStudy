package com.gp.linearList.linkedList.addTwoNumbers;

import lombok.Data;
import lombok.experimental.Accessors;

/**单向单链表
 * @author lp
 * @since 2021-01-19 23:22:04
 */
@Data
@Accessors(chain = true)
public class ListNode {
    //属性
    int val;
    //指向下一个节点的索引（指针）
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
