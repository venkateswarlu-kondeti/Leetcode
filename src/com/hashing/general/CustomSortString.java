package com.hashing.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomSortString {
    public static String customSortString(String order, String s){
        Map<Character,Integer> dic=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(char c : s.toCharArray()){
            dic.put(c,dic.getOrDefault(c,0)+1);
        }
        for(char c: order.toCharArray()){
            while(dic.containsKey(c)){
                sb.append(c);
                dic.put(c,dic.get(c)-1);
                if(dic.get(c)==0){
                    dic.remove(c);
                }
            }
        }
        if(!dic.isEmpty()){
            for(Map.Entry<Character,Integer> e : dic.entrySet()){
                while(dic.get(e.getKey())>0){
                    sb.append(e.getKey());
                    dic.put(e.getKey(),dic.get(e.getKey())-1);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println("The custom sort string is: "+customSortString("ccbad","ccb"));
        System.out.println("The custom sort string is: "+customSortString("cba","abcd"));
        System.out.println("The custom sort string is: "+customSortString("cbafg","abcd"));
        System.out.println("The custom sort string is: "+customSortString("kqep","pekeq"));
        System.out.println("The custom sort string is: "+customSortString("hucw","utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh"));
    }
}
