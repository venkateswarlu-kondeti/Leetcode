package com.linkedlist.fast_and_slow_pointers;
//82. Remove Duplicates from Sorted List II
public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel=new ListNode(0,head);
        ListNode prev=sentinel;
        while(head!=null){
            if(head.next!=null && head.val==head.next.val){
                while(head.next!=null && head.val==head.next.val){
                    head=head.next;
                }
                prev.next=head.next;
            }else{
                prev=prev.next;
            }
            head=head.next;
        }
        return sentinel.next;

        //---------------------------My Solution-------------------------------
        /*ListNode sentinel=new ListNode(0,head);
        ListNode prev=sentinel;
        Map<Integer,Integer> collect=new HashMap<>();
        ListNode dummy=head;
        while(dummy!=null){
            collect.put(dummy.val,collect.getOrDefault(dummy.val,0)+1);
            dummy=dummy.next;
        }
        System.out.println(collect);
        while(head!=null){
            if(collect.get(head.val)==1){
                prev.next=head;
                prev=head;
            }else {
                prev.next = null;
            }
            head=head.next;
        }
        return sentinel.next;*/
    }
    public static void main(String[] args){
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(4);
        ListNode node7=new ListNode(5);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        System.out.println("After removing the duplicates from the sorted list: "+deleteDuplicates(head).val);*/
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(3);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println("After removing the duplicates from the sorted list: "+deleteDuplicates(head).next.val);*/
        /*ListNode node1=new ListNode(1);
        ListNode head=node1;
        System.out.println("After removing the duplicates from the sorted list: "+deleteDuplicates(head).val);*/
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        System.out.println("After removing the duplicates from the sorted list: "+deleteDuplicates(head).val);
    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }
}
