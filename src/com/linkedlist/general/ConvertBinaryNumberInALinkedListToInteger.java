package com.linkedlist.general;

public class ConvertBinaryNumberInALinkedListToInteger {
    public static int getDecimalValue(ListNode head) {
        int ans=0,len=0;
        ListNode dummy=head;
        while (dummy!=null){
            len++;
            dummy=dummy.next;
        }
        while(head!=null){
            ans= ans+ (int)(head.val*Math.pow(2,len-1));
            head=head.next;
            len--;
        }
        return ans;
    }
    public static void main(String[] args){
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(0);
        ListNode node3=new ListNode(1);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        System.out.println("Converted binary number ina linked list to integer: "+getDecimalValue(head));*/
        /*ListNode node1=new ListNode(0);
        ListNode head=node1;
        System.out.println("Converted binary number ina linked list to integer: "+getDecimalValue(head));*/
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(0);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(1);
        ListNode node5=new ListNode(0);
        ListNode node6=new ListNode(0);
        ListNode node7=new ListNode(1);
        ListNode node8=new ListNode(1);
        ListNode node9=new ListNode(1);
        ListNode node10=new ListNode(0);
        ListNode node11=new ListNode(0);
        ListNode node12=new ListNode(0);
        ListNode node13=new ListNode(0);
        ListNode node14=new ListNode(0);
        ListNode node15=new ListNode(0);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;
        node9.next=node10;
        node10.next=node11;
        node11.next=node12;
        node12.next=node13;
        node13.next=node14;
        node14.next=node15;

        System.out.println("Converted binary number ina linked list to integer: "+getDecimalValue(head));
    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
