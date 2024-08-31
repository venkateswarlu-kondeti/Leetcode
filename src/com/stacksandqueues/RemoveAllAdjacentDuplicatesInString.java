package com.stacksandqueues;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s){
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c : s.toCharArray()){
            if(!stack.empty() && stack.peek()==c){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
        /*StringBuilder stack=new StringBuilder();
        for(char c: s.toCharArray()){
            if(stack.length()>0 && stack.charAt(stack.length()-1)==c){
                stack.deleteCharAt(stack.length()-1);
            }else{
                stack.append(c);
            }
        }
        return stack.toString();*/
    }
    public static void main(String[] args){
        String str="abbaca";
        System.out.println("The string after removing the adjacent duplicates is: "+removeDuplicates(str));
    }
}
