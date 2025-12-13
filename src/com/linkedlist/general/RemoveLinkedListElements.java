package com.linkedlist.general;
//203. Remove Linked List Elements
public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel=new ListNode(0,head);
        ListNode prev=sentinel;
        while(head!=null){
            if(head.val==val){
                prev.next=head.next;
            }else{
                prev=head;
            }
            head=head.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args){
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(6);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(5);
        ListNode node7=new ListNode(6);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        System.out.println("After removing the linked list elements: "+removeElements(head,6).next.next.next.next.val);*/
        /*ListNode head=null;
        System.out.println("After removing the linked list elements: "+removeElements(head,1).val);*/
        ListNode node1=new ListNode(7);
        ListNode node2=new ListNode(7);
        ListNode node3=new ListNode(7);
        ListNode node4=new ListNode(7);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println("After removing the linked list elements: "+removeElements(head,7).val);
    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
