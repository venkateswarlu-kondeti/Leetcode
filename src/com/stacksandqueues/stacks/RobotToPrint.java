package com.stacksandqueues.stacks;

import java.util.*;

public class RobotToPrint {
    public static String robotWithString(String s){
        Map<Character,Integer> charCount=new HashMap<>();
        List<Character> orderedChar=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        for(char c: s.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0)+1);
            orderedChar.add(c);
        }
        Collections.sort(orderedChar);
        System.out.println(charCount);
        System.out.println(orderedChar);
        int j=0;
        for(int i=0;i<s.length();i++){
            stack1.push(s.charAt(i));
            if(!stack1.empty() && stack1.peek()==orderedChar.get(j) && i==0){
                sb.append(stack1.pop());
                charCount.put(s.charAt(i),charCount.get(s.charAt(i))-1);
                System.out.println(charCount);
                if(charCount.get(s.charAt(i))==0){
                    charCount.remove(s.charAt(i));
                    j++;
                }
                System.out.println(charCount);
            }else if(!stack1.empty() && stack1.peek()==orderedChar.get(j) && i==s.length()-1){
                while(!stack1.empty()){
                    sb.append(stack1.pop());
                }
            }else if(!stack1.empty() && stack1.peek()==orderedChar.get(j)){
                stack2.clear();
                sb.append(stack1.pop());
                charCount.put(s.charAt(i),charCount.get(s.charAt(i))-1);
                if(charCount.get(s.charAt(i))==0){
                    charCount.remove(s.charAt(i));
                    j++;
                }
                while(!stack1.empty()){
                    stack2.push(stack1.pop());
                }
                stack1=stack2;
                System.out.println(stack1);
            }
        }
        System.out.println(stack1);
        for(int k=0;k<stack1.size();k++){
            sb.append(stack1.get(k));
        }
        return sb.toString();
    }
    public static void main(String[] args ){
        //String s="zza";
        String s="bacd";
        //String s = "bdda";
        //String s = "bac";
        //String s = "bydizfve";
        System.out.println("Lexicographically printed smallest string by robot is: "+robotWithString(s));
    }
}
