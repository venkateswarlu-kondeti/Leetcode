package com.linkedlist.general;

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode odd=head, even=head.next, evenHead=even;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;

        //------------------My Solution--------------
        /*ListNode ans=head, firstOddNode=null, prev=null, dummy=head;
        int length=0;
        while(dummy!=null){
            length++;
            dummy=dummy.next;
        }
        if(length>2){
            firstOddNode=head.next;
            prev=head;
            head=head.next;
        }else{
            return ans;
        }
        while(head!=null){
            prev.next=head.next;
            prev=head;
            head=head.next;
            if(head.next==null && length%2!=0){
                head.next=firstOddNode;
                prev.next=null;
                break;
            } else if (head.next==null && length%2==0) {
                prev.next=firstOddNode;
                break;
            }
        }
        return ans;*/
    }
    public static void main(String[] args){
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println("The odd even linked list is: "+oddEvenList(head).val);*/
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println("The odd even linked list is: "+oddEvenList(head).next.next.next.val);*/
        ListNode node1=new ListNode(1);
        ListNode head=node1;
        System.out.println("The odd even linked list is: "+oddEvenList(head).val);

    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
