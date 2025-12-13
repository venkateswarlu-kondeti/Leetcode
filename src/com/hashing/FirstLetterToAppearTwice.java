package com.hashing;

import java.util.HashSet;
import java.util.Set;
//2351. First Letter to Appear Twice
public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s){
        Set<Character> seen=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(seen.contains(c)){ // This operation is O(1)
                return c;
            }
            seen.add(c);
        }
        return ' ';
    }
    public static void main(String[] args){
        FirstLetterToAppearTwice fl=new FirstLetterToAppearTwice();
        String s="abcdeda";
        System.out.println("Repeated character is: "+fl.repeatedCharacter(s));
    }
}
