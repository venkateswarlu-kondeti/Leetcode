package com.linkedlist;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
//141. Linked List Cycle
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;

        //----Another Solution-----------------------
        /*Set<ListNode> seen=new HashSet<>();
        while(head!=null){
            if(seen.contains(head)){
                return true;
            }
            seen.add(head);
            head=head.next;
        }
        return false;*/
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(-4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        ListNode head=node1;
        System.out.println("Is there a cycle: "+LinkedListCycle.hasCycle(head));

    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }
}


