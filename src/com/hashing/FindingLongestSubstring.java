package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindingLongestSubstring {
    public int findLongestSubstring(String s, int k){
        Map<Character,Integer> counts=new HashMap<>();
        int left=0;
        int ans=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            counts.put(c,counts.getOrDefault(c,0)+1);
            while(counts.size()>k){
                char removeChar=s.charAt(left);
                counts.put(removeChar,counts.getOrDefault(removeChar,0)-1);
                if(counts.get(removeChar)==0){
                    counts.remove(removeChar);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
    public static void main(String[] args){
        FindingLongestSubstring fls=new FindingLongestSubstring();
        String s="eceba";
        int k=2;
        System.out.println("The longest substring is: "+fls.findLongestSubstring(s,k));
    }
}
