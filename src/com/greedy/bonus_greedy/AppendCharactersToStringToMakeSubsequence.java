package com.greedy.bonus_greedy;
//2486. Append Characters to String to Make Subsequence
public class AppendCharactersToStringToMakeSubsequence {
    public static int appendCharacters(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(t.charAt(j)==s.charAt(i)){
                j++;
            }
            i++;
        }
        return t.length()-j;
    }
    public static void main(String[] args){
        String s = "coaching", t = "coding";
        System.out.println("The minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s: "+AppendCharactersToStringToMakeSubsequence.appendCharacters(s,t));
    }
}
