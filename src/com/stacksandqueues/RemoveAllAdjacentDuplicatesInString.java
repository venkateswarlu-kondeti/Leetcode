package com.stacksandqueues;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String s){
        StringBuilder stack=new StringBuilder();
        for(char c: s.toCharArray()){
            if(stack.length()>0 && stack.charAt(stack.length()-1)==c){
                stack.deleteCharAt(stack.length()-1);
            }else{
                stack.append(c);
            }
        }
        return stack.toString();
    }
    public static void main(String[] args){
        String str="abbaca";
        System.out.println("The string after removing the adjacent duplicates is: "+removeDuplicates(str));
    }
}
