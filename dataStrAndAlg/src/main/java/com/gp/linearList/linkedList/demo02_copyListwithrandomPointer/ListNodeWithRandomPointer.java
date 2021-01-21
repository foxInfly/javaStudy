package com.gp.linearList.linkedList.demo02_copyListwithrandomPointer;

/**
 * list Node with Random Pointer
 *
 * @author lp
 * @since 2021-01-21 10:27:58
 */
public class ListNodeWithRandomPointer {
    int val;
    ListNodeWithRandomPointer next;
    ListNodeWithRandomPointer random;

    public ListNodeWithRandomPointer(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
