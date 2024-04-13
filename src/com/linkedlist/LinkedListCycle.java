package com.linkedlist;

import java.util.LinkedList;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        boolean status;

        LinkedList h=new LinkedList();
        h.add(head.val);

        if (head.next != null) {
            head.next = head;
        }
        if (head.next != null) {
            status = true;
        } else {
            status = false;
        }
        System.out.println("Head is: " + head.val + " and  " + head.next);
        return status;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 0, -4};
        ListNode head = null;
        LinkedListCycle llc = new LinkedListCycle();

        for (int i = 0; i < a.length; i++) {
            head = new ListNode(a[i]);
        }

        System.out.println("Cycle: " + llc.hasCycle(head));

    }
}


