package com.linkedlist.fast_and_slow_pointers;
//2095. Delete the Middle Node of a Linked List
public class DeleteTheMiddleNodeOfALinkedList {
    public static ListNode deleteMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        ListNode ans=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow==fast){
            return null;
        }
        while(head!=null && head.next!=null){
            if (head.next==slow){
                break;
            }
            head=head.next;
        }
        head.next=slow.next;
        return ans;
    }
    public static void main(String[] args){
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(7);
        ListNode node5=new ListNode(1);
        ListNode node6=new ListNode(2);
        ListNode node7=new ListNode(6);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        System.out.println("After deleting the middle node of the linked list: "+deleteMiddle(head).next.next.next.val);*/
        ListNode node1=new ListNode(1);
        ListNode head=node1;
        System.out.println("After deleting the middle node of the linked list: "+deleteMiddle(head).val);
    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
