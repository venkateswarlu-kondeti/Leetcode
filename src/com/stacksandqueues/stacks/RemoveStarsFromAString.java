package com.stacksandqueues.stacks;

import java.util.Stack;

public class RemoveStarsFromAString {
    public static String removeStars(String s){
        StringBuilder str=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.empty() && c=='*'){
                stack.pop();
            }
            if(c!='*'){
                stack.push(c);
            }
        }
        while (!stack.empty()){
            str.append(stack.pop());
        }

        return str.reverse().toString();
    }
    public static void main(String[] args){
        String s="leet**cod*e";
        //String s = "erase*****";
        System.out.println("After removing the stars from a string is: "+removeStars(s));
    }
}
