package com.linkedlist.programs;

import java.util.LinkedList;

public class MyLinkedList {
    LinkedList<Integer> l = new LinkedList<>();
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
    }

    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.addAtHead(1);
        ml.addAtTail(3);
        ml.addAtIndex(1, 2);
        System.out.println(ml.get(1));
        ml.deleteAtIndex(1);
        System.out.println(ml.get(1));
    }
}
