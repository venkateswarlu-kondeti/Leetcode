package com.linkedlist.reversing_a_linked_list;

public class ReverseNodesInEvenLengthGroups {
    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy=head;
        ListNode ans=head;
        int length=0;
        while(dummy!=null){
            length++;
            dummy=dummy.next;
        }
        System.out.println(length);
        int currLen=length;
        ListNode prevHead=null;
        for(int i=1;i<=length;i++){
            int iniVal=currLen>=i?i:currLen;
            if(iniVal%2==0){
                ListNode prev=null;
                ListNode curr=head;
                while(curr!=null && iniVal>0){
                    ListNode nextNode=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=nextNode;
                    iniVal--;
                }
                prevHead.next=prev;
                head.next=curr;
                prevHead=head;
                head=head.next;
            }else{
                while(iniVal>0){
                    prevHead=head;
                    head=head.next;
                    iniVal--;
                }
            }
            currLen=currLen-i;
            if(currLen<=0){
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        /*ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(6);
        ListNode node4=new ListNode(3);
        ListNode node5=new ListNode(9);
        ListNode node6=new ListNode(1);
        ListNode node7=new ListNode(7);
        ListNode node8=new ListNode(3);
        ListNode node9=new ListNode(8);
        ListNode node10=new ListNode(4);
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
        System.out.println("The reverse nodes in even length groups are: "+reverseEvenLengthGroups(head).val);*/
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(6);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println("The reverse nodes in even length groups are: "+reverseEvenLengthGroups(head).val);*/
        /*ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(6);
        ListNode node5=new ListNode(5);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println("The reverse nodes in even length groups are: "+reverseEvenLengthGroups(head).next.next.next.next.val);*/
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(0);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(4);
        ListNode node6=new ListNode(7);
        ListNode node7=new ListNode(3);
        ListNode node8=new ListNode(6);
        ListNode head=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        System.out.println("The reverse nodes in even length groups are: "+reverseEvenLengthGroups(head).next.next.next.next.next.next.val);
    }
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
