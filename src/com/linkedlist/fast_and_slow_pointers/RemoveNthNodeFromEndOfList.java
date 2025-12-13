package com.linkedlist.fast_and_slow_pointers;
//19. Remove Nth Node From End of List
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head;
        int initialValue=1;
        int length=0;
        ListNode dummy=head;
        ListNode ans=head;
        while(dummy!=null){
            length++;
            dummy=dummy.next;
        }
        if(length==1){
            return null;
        }
        System.out.println(length);
        int oppositeNValue=length-n;
        if(oppositeNValue==0){
            head=head.next;
            return head;
        }
        while(initialValue<length-n){
            slow=slow.next;
            initialValue++;
        }
        if(slow.next!=null && slow.next.next!=null){
            slow.next=slow.next.next;
        }else if(slow.next!=null){
            slow.next=null;
        }
        return ans;
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
        System.out.println("After removing Nth node form end of list is: "+removeNthFromEnd(head,2).next.next.next.val);*/
        ListNode node1=new ListNode(1);
        ListNode head=node1;
        System.out.println("After removing Nth node form end of list is: "+removeNthFromEnd(head,1).val);
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode head=node1;
        node1.next=node2;
        System.out.println("After removing Nth node form end of list is: "+removeNthFromEnd(head,2).val);*/
    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
