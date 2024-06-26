package com.stacksandqueues.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    List<Integer> numList;
    public MyStack() {
        queue1=new LinkedList<>();
        numList=new ArrayList<>();
    }

    public void push(int x) {
        queue1.clear();
        queue1.add(x);
        numList.add(queue1.remove());
        for(int i=numList.size()-1;i>=0;i--){
            queue1.add(numList.get(i));
        }
    }

    public int pop() {
        numList.remove(numList.size()-1);
        return queue1.remove();
    }

    public int top() {
        return queue1.isEmpty()? 0: queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args){
        MyStack myStack=new MyStack();
        /*myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());*/

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        myStack.push(4);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
