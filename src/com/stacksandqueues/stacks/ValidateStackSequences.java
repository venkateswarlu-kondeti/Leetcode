package com.stacksandqueues.stacks;

import java.util.Stack;

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped){
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.empty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty() ? true : false;
    }
    public static void main(String[] args){
        /*int[] pushed={1,2,3,4,5};
        int[] popped={4,5,3,2,1};*/
        int[] pushed={1,2,3,4,5};
        int[] popped={4,3,5,1,2};
        System.out.println("Is valid stack sequence? "+validateStackSequences(pushed,popped));
    }
}
