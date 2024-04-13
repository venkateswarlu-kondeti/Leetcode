package com.hashing.counting;

import java.lang.reflect.Array;
import java.util.*;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2){
        StringBuilder sb=new StringBuilder(s2);
        Set<Character> charSet=new HashSet<>();
        for(char c : s1.toCharArray()){
            charSet.add(c);
        }
        char[] subCharS1=s1.toCharArray();
        Arrays.sort(subCharS1);
        String stringS1=String.valueOf(subCharS1);
        for(int i=0;i<s2.length();i++){
            if(charSet.contains(s2.charAt(i)) && i<=s2.length()-s1.length()){
                String subStr=sb.substring(i,i+s1.length());
                char[] subCharS2=subStr.toCharArray();
                Arrays.sort(subCharS2);
                String stringS2=String.valueOf(subCharS2);
                if(stringS2.equals(stringS1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println("The permutation is string is: "+checkInclusion("ab","eidbaooo"));
        System.out.println("The permutation is string is: "+checkInclusion("ab","eidboaoo"));
        System.out.println("The permutation is string is: "+checkInclusion("abc","bbbca"));
        System.out.println("The permutation is string is: "+checkInclusion("abc","acbbb"));
        System.out.println("The permutation is string is: "+checkInclusion("abc","abbbc"));
        System.out.println("The permutation is string is: "+checkInclusion("abc","ccccbbbbaaaa"));
        System.out.println("The permutation is string is: "+checkInclusion("adc","dcda"));
    }
}
