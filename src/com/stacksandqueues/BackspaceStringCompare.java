package com.stacksandqueues;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t){
        return build(s).equals(build(t));
    }
    public static String build(String str){
        StringBuilder stack=new StringBuilder();
        for(char c:str.toCharArray()){
            if(c!='#'){
                stack.append(c);
            }else if(stack.length()>0){
                stack.deleteCharAt(stack.length()-1);
            }
        }
        return stack.toString();
    }
    public static void main(String[] args){
        String s="ab#c";
        String t="ad#c";
        System.out.println("The string after comparing backspace string is: "+backspaceCompare(s,t));
    }
}
