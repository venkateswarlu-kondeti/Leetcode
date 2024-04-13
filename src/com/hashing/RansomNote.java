package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine){
        Map<Character,Integer> dic=new HashMap<>(); // Space Complexity : O(n)
        for(char c : magazine.toCharArray()){       // Time complexity : O(n)
            dic.put(c,dic.getOrDefault(c,0)+1);
        }
        System.out.println(dic);
        int ransomNoteCount=0;
        for(char c : ransomNote.toCharArray()){ // Time complexity : O(m)
            if(dic.containsKey(c)){
                dic.put(c,dic.get(c)-1);
                ransomNoteCount++;
                if(dic.get(c)==0){
                    dic.remove(c);
                }
            }
        }
        System.out.println(dic);
        return (ransomNoteCount==ransomNote.length())? true : false;
    }
    public static void main(String[] args){
        RansomNote rn=new RansomNote();
        String ransomNote = "aa", magazine = "aab";
        //String ransomNote = "aa", magazine = "ab";
        //String ransomNote = "a", magazine = "b";
        System.out.println("The ransom note is: "+rn.canConstruct(ransomNote,magazine));
    }
}

// Total Space Complexity : O(n)
// Total Time Complexity : O(n+m)=O(n)