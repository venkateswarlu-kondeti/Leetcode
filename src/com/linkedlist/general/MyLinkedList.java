package com.linkedlist.general;

import java.util.LinkedList;

public class MyLinkedList {
    ListNode head;
    ListNode tail;
    int  size;

    public MyLinkedList() {
        size=0;
        head=new ListNode(0);
        tail=new ListNode(0);
        head.next=tail;
        tail.prev=head;
    }
    public int get(int index) {
        ListNode dummy=head.next;
        if(index<0 || index>=size){
            return -1;
        }else{
            while(index>0){
                dummy=dummy.next;
                index--;
            }
        }
        return dummy.val;
    }
    public void addAtHead(int val) {
        size++;
        ListNode nodeAtHead=new ListNode(val);
        ListNode pred=head, succ=head.next;
        nodeAtHead.prev=pred;
        nodeAtHead.next=succ;
        pred.next=nodeAtHead;
        succ.prev=nodeAtHead;
    }
    public void addAtTail(int val) {
        size++;
        ListNode nodeAtTail=new ListNode(val);
        ListNode succ=tail, pred=tail.prev;
        nodeAtTail.next=succ;
        nodeAtTail.prev=pred;
        succ.prev=nodeAtTail;
        pred.next=nodeAtTail;
    }
    public void addAtIndex(int index, int val) {
        ListNode nodeToAdd=new ListNode(val);
        ListNode curr=head.next;
        if(index>size){
            return;
        }else if (index<=size){
            while(index>0){
                curr=curr.next;
                index--;
            }
            ListNode pred=curr.prev, succ=curr;
            nodeToAdd.prev=pred;
            nodeToAdd.next=succ;
            pred.next=nodeToAdd;
            succ.prev=nodeToAdd;
            size++;
        }
    }
    public void deleteAtIndex(int index) {
        ListNode curr=head.next;
        if(index>=0 && index<size){
            while (index>0){
                curr=curr.next;
                index--;
            }
            ListNode pred=curr.prev, succ=curr.next;
            pred.next=succ;
            succ.prev=pred;
            size--;
        }else{
            return;
        }
    }
    public class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val){
            this.val=val;
        }
    }


    //------------------------------------------------------------------------------------------------------------------------------------------
    /*LinkedList<Integer> l = new LinkedList<>();
    int m;

    public MyLinkedList() {
    }

    public int get(int index) {
        try {
            m = l.get(index);
        } catch (IndexOutOfBoundsException e) {
            m = -1;
        }
        return m;
    }

    public void addAtHead(int val) {
        l.addFirst(val);
    }

    public void addAtTail(int val) {
        l.addLast(val);
    }

    public void addAtIndex(int index, int val) {
        try {
            l.add(index, val);
        } catch (IndexOutOfBoundsException e) {

        }
    }

    public void deleteAtIndex(int index) {
        try {
            l.remove(index);
        } catch (IndexOutOfBoundsException e) {

        }

    }*/
        //---------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        /*MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(1);
        ml.addAtTail(3);
        ml.addAtIndex(1, 2);
        System.out.println(ml.get(3));
        ml.deleteAtIndex(1);
        System.out.println(ml.get(-1));*/

        MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(1);
        //ml.addAtTail(3);
        //ml.addAtIndex(1, 2);
        System.out.println(ml.get(0));
        ml.deleteAtIndex(0);
        System.out.println(ml.get(0));
    }
}
