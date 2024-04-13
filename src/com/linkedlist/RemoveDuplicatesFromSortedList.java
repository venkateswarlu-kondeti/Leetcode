package com.linkedlist;

import java.util.*;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head){
        while(head!=null && head.next!=null){
            if(head.val==head.next.val){
                head.next= head.next.next;
            }else{
                head=head.next;
            }
        }
        return head;

        //-------------My Solution-------------------------------
        /*ListNode ans=head;
        while(head!=null && head.next!=null){
            while(head.next!=null && head.next.val==head.val){
                head.next=head.next.next;
            }
            head=head.next;
        }
        return ans;*/

    }
    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(3);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println("The sorted list after removing the duplicates is: "+deleteDuplicates(head).val);
        System.out.println("The sorted list after removing the duplicates is: "+deleteDuplicates(head).next.val);
        System.out.println("The sorted list after removing the duplicates is: "+deleteDuplicates(head).next.next.val);
        System.out.println("The sorted list after removing the duplicates is: "+deleteDuplicates(head).next.next.next.val);
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }
}
