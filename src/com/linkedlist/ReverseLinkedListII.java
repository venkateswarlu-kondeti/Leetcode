package com.linkedlist;
//92. Reverse Linked List II
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int leftInitial=1,rightInitial=1;
        ListNode slow=head;
        ListNode fast=head;
        ListNode ans=head;
        if(right==left){
            return head;
        }
        while(leftInitial<left){
            slow=slow.next;
            leftInitial++;
        }
        System.out.println(slow.val);
        while(rightInitial<right){
            fast=fast.next;
            rightInitial++;
        }
        ListNode fastNextNode=fast.next;
        System.out.println(fast.val);
        while(head!=null && head.next!=null && head!=slow){
            if(head.next==slow){
               break;
            }
            head=head.next;
        }
        ListNode prev=null;
        ListNode curr=slow;
        ListNode nextNode=null;
        while(curr!=fastNextNode){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        System.out.println(prev.next.val);
        System.out.println(head.val);
        head.next=prev;
        slow.next=nextNode;
        return (head!=slow)? ans : prev;
    }
    public static void main(String[] args){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println("The reverse linked list is: "+reverseBetween(head,2,4).next.next.next.next.val);

        /*ListNode node1=new ListNode(5);
        ListNode head=node1;
        System.out.println("The reverse linked list is: "+reverseBetween(head,1,1).val);*/

        /*ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(5);
        ListNode head=node1;
        node1.next=node2;
        System.out.println("The reverse linked list is: "+reverseBetween(head,1,1).val);*/

    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
