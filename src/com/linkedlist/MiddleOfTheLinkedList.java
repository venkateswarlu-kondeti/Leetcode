package com.linkedlist;
import java.io.*;
import java.util.LinkedList;



public class MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
    return slow;
    }

    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode head=node1;
        //ListNode head=new ListNode(-1,node1);
        System.out.println("The middle of the linked list is: "+middleNode(head).val);
        System.out.println("The middle of the linked list is: "+middleNode(head).next.val);
        System.out.println("The middle of the linked list is: "+middleNode(head).next.next.val);
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val, ListNode next){
            this.val=val;
            this.next=next;
        }
    }
}
