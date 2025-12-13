package com.hashing.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//1657. Determine if Two Strings Are Close
public class DetermineIfTwoStringsAreClose {
    public static boolean closeStrings(String word1, String word2){
        Map<Character,Integer> wordDic1=new HashMap<>();
        Map<Character,Integer> wordDic2=new HashMap<>();
        for(char c: word1.toCharArray()){
            wordDic1.put(c,wordDic1.getOrDefault(c,0)+1);
        }
        for(char c: word2.toCharArray()){
            wordDic2.put(c,wordDic2.getOrDefault(c,0)+1);
        }
        System.out.println(wordDic1);
        System.out.println(wordDic2);
        for(char c : word1.toCharArray()){
            if(!wordDic2.containsKey(c)){
                return false;
            }
        }
        List<Integer> l=new ArrayList<>();
        for(Map.Entry<Character,Integer> e: wordDic2.entrySet()){
            l.add(e.getValue());
        }
        for(Map.Entry<Character,Integer> e: wordDic1.entrySet()){
            if(!l.contains(e.getValue())){
                return false;
            }
            l.remove(e.getValue());
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("Is the strings are close?: "+closeStrings("abc","bca"));
        System.out.println("Is the strings are close?: "+closeStrings("a","aa"));
        System.out.println("Is the strings are close?: "+closeStrings("cabbba","abbccc"));
        System.out.println("Is the strings are close?: "+closeStrings("abbzzca","babzzcz"));
    }
}
