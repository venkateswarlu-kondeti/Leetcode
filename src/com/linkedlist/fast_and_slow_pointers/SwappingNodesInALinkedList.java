package com.linkedlist.fast_and_slow_pointers;

import java.util.Arrays;
//1721. Swapping Nodes in a Linked List
public class SwappingNodesInALinkedList {
    public static ListNode swapNodes(ListNode head, int k) {
        int length=0;
        ListNode dummy=head;
        ListNode curr=head;
        ListNode ans=head;
        while(dummy!=null){
            length++;
            dummy=dummy.next;
        }
        System.out.println(length);
        int[] arr=new int[length];
        for(int i=1;i<=length;i++){
            if(i==k){
                arr[length-k]=head.val;
            }else if(i==length-k+1){
                arr[k-1]=head.val;
            }else{
                arr[i-1]=head.val;
            }
            head=head.next;
        }
        System.out.println(Arrays.toString(arr));
        int j=0;
        while(curr!=null && j<length){
            curr.val=arr[j];
            j++;
            curr=curr.next;
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
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,3).val);*/
        ListNode node1=new ListNode(7);
        ListNode node2=new ListNode(9);
        ListNode node3=new ListNode(6);
        ListNode node4=new ListNode(6);
        ListNode node5=new ListNode(7);
        ListNode node6=new ListNode(8);
        ListNode node7=new ListNode(3);
        ListNode node8=new ListNode(0);
        ListNode node9=new ListNode(9);
        ListNode node10=new ListNode(5);
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
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.next.val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.next.next.val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.next.next.next.val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.next.next.next.next.val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.next.next.next.next.next.val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.next.next.next.next.next.next.val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.next.next.next.next.next.next.next.val);
        System.out.println("After swapping the nodes in a linked list: "+swapNodes(head,5).next.next.next.next.next.next.next.next.next.val);



    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
