package com.linkedlist.reversing_a_linked_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        List<Integer> valList=new ArrayList<>();
        while(curr!=null){
            valList.add(curr.val);
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        System.out.println(valList);

        /*LinkedList lm=new LinkedList();
        while(prev!=null){
            lm.add(prev.val);
            prev=prev.next;
        }
        System.out.println(lm.toString());*/

        for(int l : valList){
            if(l!= prev.val){
                return false;
            }
            prev=prev.next;
        }
        return true;
    }
    public static void main(String[] args){
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(1);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println("The Palindrome linked list is: "+isPalindrome(head));*/
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode head=node1;
        node1.next=node2;
        System.out.println("The Palindrome linked list is: "+isPalindrome(head));*/
    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
