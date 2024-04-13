package com.linkedlist.reversing_a_linked_list;

public class MaximumTwinSumOfALinkedList {
    public static int pairSum(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        ListNode dummy=head;
        int ans=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        while(head!=null && head.next!=null){
            if(head.next==slow){
                break;
            }
            head=head.next;
        }
        ListNode prev=null;
        ListNode curr=slow;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        head.next=prev;
        fast=prev;
        slow=dummy;

        if(slow.next==fast){
            return slow.val+fast.val;
        }else{
            while(fast!=null){
                ans=Math.max(ans, slow.val+ fast.val);
                slow=slow.next;
                fast=fast.next;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        /*ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(3);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println("The maximum twin sum of linked list is: "+pairSum(head));*/
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(100000);
        ListNode head=node1;
        node1.next=node2;
        System.out.println("The maximum twin sum of linked list is: "+pairSum(head));
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
