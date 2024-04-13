package com.hashing.counting;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s){
        Map<Character,Integer> dic=new HashMap<>();
        for(char c : s.toCharArray()){
            dic.put(c, dic.getOrDefault(c,0)+1);
        }
        System.out.println(dic);
        List<Character> listCharacter=new ArrayList<>(dic.keySet());
        Collections.sort(listCharacter,(a,b)->dic.get(b)-dic.get(a));
        System.out.println(listCharacter);

        StringBuilder sb=new StringBuilder();
        for(char c : listCharacter){
            int charCount=dic.get(c);
            while(charCount>0){
                sb.append(c);
                charCount--;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        SortCharactersByFrequency sf=new SortCharactersByFrequency();
        String s="tree";
        System.out.println("The sort of characters by frequency is: "+sf.frequencySort(s));
    }
}
