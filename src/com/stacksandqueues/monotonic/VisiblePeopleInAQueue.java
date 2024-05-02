package com.stacksandqueues.monotonic;

import java.util.Arrays;
import java.util.Stack;
public class VisiblePeopleInAQueue {
    public static int[] canSeePersonsCount(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[heights.length];
        for(int i= heights.length-1;i>=0;i--){
            while(!stack.empty() && stack.peek()<heights[i]){
                stack.pop();
                ans[i]+=1;
            }
            if(!stack.empty() && stack.peek()>heights[i]){
                ans[i]+=1;
            }
            stack.push(heights[i]);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] heights = {10,6,8,5,11,9};
        //int[] heights = {5,1,2,3,10};
        System.out.println("The number of visible people in a Queue is: "+ Arrays.toString(canSeePersonsCount(heights)));
    }
}
