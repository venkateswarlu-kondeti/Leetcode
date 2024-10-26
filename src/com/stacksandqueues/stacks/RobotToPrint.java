package com.stacksandqueues.stacks;

import java.util.*;

public class RobotToPrint {
    public static String robotWithString(String s){
        Stack<Character> stack=new Stack<>();
        StringBuilder p=new StringBuilder();
        char[] charArray=s.toCharArray();
        Arrays.sort(charArray);
        String sortedStr=new String(charArray);
        System.out.println(sortedStr);
        int j=0;
        for(Character c: s.toCharArray()){
            stack.add(c);
            if(c==sortedStr.charAt(j)){
                p.append(stack.pop());
                j++;
            } else if (c!=sortedStr.charAt(j) && c==s.charAt(s.length()-1)) {
                Collections.reverse(stack);
            }
        }
        while(!stack.empty()){
            p.append(stack.pop());
        }
        return p.toString();
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

