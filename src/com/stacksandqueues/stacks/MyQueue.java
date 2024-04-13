package com.stacksandqueues.stacks;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int x) {
        if(!stack2.empty()){
            stack2.clear();
        }
        stack1.push(x);
        int topIndex=stack1.size()-1;
        while(topIndex>=0){
            stack2.push(stack1.get(topIndex));
            topIndex--;
        }
        System.out.println(stack2);
    }
    public int pop() {
        stack1.remove(0);
        return stack2.pop();
    }
    public int peek() {
        return stack2.peek();
    }
    public boolean empty() {
        return stack2.size()>0 ? false : true;
    }
    public static void main(String[] args){
        MyQueue myQueue=new MyQueue();
        /*myQueue.push(5);
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        int qPeek=myQueue.peek();
        int qPop=myQueue.pop();
        boolean qCheck=myQueue.empty();
        System.out.println(qPeek);
        System.out.println(qPop);
        System.out.println(qCheck);*/

        /*myQueue.push(1);
        int qPop=myQueue.pop();
        boolean qCheck=myQueue.empty();
        System.out.println(qPop);
        System.out.println(qCheck);*/

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}
