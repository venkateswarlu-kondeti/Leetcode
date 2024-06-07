package com.stacksandqueues.stacks;

import java.util.*;

public class RobotToPrint {
    public static String robotWithString(String s){
        Stack<Character> stack=new Stack<>();
        List<Character> charList=new ArrayList<>();
        StringBuilder p=new StringBuilder();
        for(char c: s.toCharArray()){
            charList.add(c);
        }
        Collections.sort(charList);
        int i=0;
        for(char ch : s.toCharArray()){
            if(charList.get(i)==ch){
                p.append(ch);
                charList.remove(i);
                continue;
            }
            while(!stack.empty() && stack.peek()<=ch){
                p.append(stack.pop());
            }
            stack.push(ch);
            charList.remove(ch);
        }
        System.out.println(stack);
        System.out.println(charList);

        while(!stack.isEmpty()){
            p.append(stack.pop());
        }
        return p.toString();

       /*Stack<Character> stack=new Stack<>();
       List<Character> charList=new ArrayList<>();
       StringBuilder p=new StringBuilder();
       for(char c: s.toCharArray()){
           charList.add(c);
       }
       Collections.sort(charList);
       int i=0;
       for(char ch : s.toCharArray()){
           if(charList.get(i) !=ch){
               stack.push(ch);
               charList.remove(charList.indexOf(ch));
           }else{
               p.append(ch);
               charList.remove(charList.indexOf(ch));
               while(!stack.empty() && !charList.isEmpty() && stack.peek()<=charList.get(i)){
                   p.append(stack.pop());
               }
           }
       }
       while(!stack.empty()){
           p.append(stack.pop());
       }
       return p.toString(); */
    }
    public static void main(String[] args ){
        //String s="zza";
        //String s="bacd";
        //String s = "bdda";
        //String s = "bac";
        //String s = "bydizfve";
        String s = "vzhofnpo";
        System.out.println("Lexicographically printed smallest string by robot is: "+robotWithString(s));
    }
}
