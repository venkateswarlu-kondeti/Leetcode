package com.stacksandqueues.stacks;

import java.util.Stack;

public class MinStack {
    Stack<int[]> stack=new Stack<>();
    public MinStack(){

    }
    public void push(int val){
        if(stack.empty()){
            stack.push(new int[]{val,val});
        }
        int currMin=stack.peek()[1];
        stack.push(new int[]{val,Math.min(val,currMin)});
    }
    public void pop(){
        stack.pop();
    }
    public int top(){
        return stack.peek()[0];
    }
    public int getMin(){
        return stack.peek()[1];
    }



    //--------------------------My Solution---------------------------------------------------------------------
    /*Stack<Integer> stack;
    public MinStack(){
        stack=new Stack<>();
    }
    public void push(int val){
        stack.push(val);
    }
    public void pop(){
        stack.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        int ans=stack.peek();
        for(int i=0;i<stack.size();i++){
            ans=Math.min(ans,stack.get(i));
        }
        return ans;
    }*/
    public static void main(String[] args){
        MinStack minStack=new MinStack();
        /*minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());*/

        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
