package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer> dic=new HashMap<>();
        int left=0;
        int ans=0;
        for(int right=0;right<s.length();right++){
            char curr=s.charAt(right);
            while(dic.containsKey(curr)){
                dic.remove(s.charAt(left));
                left++;
            }
            ans=Math.max(ans,right-left+1);
            dic.put(curr,right);
        }
        return ans;
    }
    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters rc=new LongestSubstringWithoutRepeatingCharacters();
        //String s="abcabcbb";
        //String s="bbbbb";
        //String s="pwwkew";
        //String s=" ";
        String s="aab";
        System.out.println("The longest substring without repeating characters is: "+rc.lengthOfLongestSubstring(s));
    }
}
