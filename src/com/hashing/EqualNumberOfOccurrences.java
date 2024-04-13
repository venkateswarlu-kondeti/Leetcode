package com.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s){
        Map<Character,Integer> counts=new HashMap<>();
        for(char c : s.toCharArray()){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }
        Set<Integer> frequencies=new HashSet<>(counts.values());
        return frequencies.size()==1;
    }
    public static void main(String[] args){
        EqualNumberOfOccurrences en=new EqualNumberOfOccurrences();
        String s="abacbc";
        //String s="aaabb";
        System.out.println("Is All characters have equal number of occurrences? "+en.areOccurrencesEqual(s));
    }
}
