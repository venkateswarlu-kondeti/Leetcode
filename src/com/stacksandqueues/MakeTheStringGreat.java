package com.stacksandqueues;

import java.util.Stack;

public class MakeTheStringGreat {
    public static String makeGood(String s){
        StringBuilder stack=new StringBuilder();
        for(char c:s.toCharArray()){
            if(stack.length()>0 && c!=stack.charAt(stack.length()-1) && (Character.toUpperCase(c)==stack.charAt(stack.length()-1) || Character.toLowerCase(c)==stack.charAt(stack.length()-1))){
                stack.deleteCharAt(stack.length()-1);
            }else{
                stack.append(c);
            }
        }
        return stack.toString();
    }
    public static void main(String[] args){
        //String s="leEeetcode";
        //String s = "abBAcC";
        String s = "s";
        System.out.println("After making the string great: "+makeGood(s));
    }
}
