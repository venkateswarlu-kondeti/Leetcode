package com.greedy.bonus_greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//409. Longest Palindrome
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        Map<Character,Integer> counts=new HashMap<>();
        for(char c: s.toCharArray()){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }

        boolean hasOddValue=false;
        int ans=0;
        for(int freq : counts.values()){
            if(freq%2==0){
                ans+=freq;
            }else {
                ans+=freq-1;
                hasOddValue=true;
            }
        }
        return hasOddValue ? ans+1 : ans;




//----------------------My Solution-----------------------------------
        /*Map<Character,Integer> counts=new HashMap<>();
        for(char c: s.toCharArray()){
            counts.put(c,counts.getOrDefault(c,0)+1);
        }
        if (counts.size()==1){
            return counts.get(s.charAt(0));
        }
        PriorityQueue<Character> freqMaxHeap=new PriorityQueue<>((a,b) ->counts.get(b)-counts.get(a));
        for (char c : counts.keySet()){
            freqMaxHeap.add(c);
        }
        System.out.println(counts);
        System.out.println(freqMaxHeap);

        int ans=0, oddCount=0;
        while (!freqMaxHeap.isEmpty()){
            char currChar=freqMaxHeap.remove();
            if(counts.get(currChar)%2==0){
                ans+=counts.get(currChar);
            } else if (counts.get(currChar)%2==1 && oddCount<1) {
                ans+=counts.get(currChar);
                oddCount++;
            }else if (counts.get(currChar)%2==1 && counts.get(currChar)!=1) {
            ans += counts.get(currChar) - 1;
        }
        }
        return ans;*/
    }
    public static void main(String[] args){
        String s = "abccccdd";
        //String s = "a";
        //String s = "ccc";
        //String s = "ababababa";
        System.out.println("The length of the longest palindrome that can be built with those letters: "+LongestPalindrome.longestPalindrome(s));
    }
}
