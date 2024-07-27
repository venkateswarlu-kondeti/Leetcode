package com.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        Map<Character,Integer> charToCountMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            charToCountMap.put(s.charAt(i), charToCountMap.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.println(charToCountMap);
        for(int i=0;i<s.length();i++){
            if(charToCountMap.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    //-------------------------My Solution--------------------------------
    /*public int firstUniqChar(String s) {
        Map<Character, List<Integer>> charToIndexListMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!charToIndexListMap.containsKey(s.charAt(i))){
                charToIndexListMap.put(s.charAt(i),new ArrayList<>());
            }
            charToIndexListMap.get(s.charAt(i)).add(i);
        }
        for(char c : s.toCharArray()){
            if(charToIndexListMap.get(c).size()==1){
                return charToIndexListMap.get(c).get(0);
            }
        }
        return -1;
    }*/
    public static void main(String[] args)
    {
        String s="aabb";
        //String s="aab";
        //String s = "leetcode";
        //String s = "loveleetcode";
        //String s = "z";
        FirstUniqueCharacter f=new FirstUniqueCharacter();
        System.out.println(f.firstUniqChar(s));
    }
}
