package com.stacksandqueues.stacks;

import java.util.Stack;

public class RobotToPrint {
    public static String robotWithString(String s){
        int k=0;
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
            if(stack.size()==1){
                k=(int)s.charAt(0);
            }
            if( stack.size()>1 && k>(int)s.charAt(i)){
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(stack);
        for(int j=0;j<stack.size();j++){
            sb.append(stack.get(j));
        }
        return sb.toString();
    }
    public static void main(String[] args ){
        //String s="zza";
        //String s="bacd";
        //String s = "bdda";
        //String s = "bac";
        String s = "bydizfve";
        System.out.println("Lexicographically printed smallest string by robot is: "+robotWithString(s));
    }
}
