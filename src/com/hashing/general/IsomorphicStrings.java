package com.hashing.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//205. Isomorphic Strings
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t){
        Map<Character,Character> dic=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(dic.containsKey(s.charAt(i))){
                if(dic.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else if(dic.containsValue(t.charAt(i))){
                return false;
            }
            dic.put(s.charAt(i),t.charAt(i));
        }
        System.out.println(dic);
        return true;


        // Other Solution
        /*Map<Character,Character> dic=new HashMap<>();
        Set<Character> setS=new HashSet<>();
        Set<Character> setT=new HashSet<>();
        for(char c : s.toCharArray()){
            setS.add(c);
        }
        for(char c : t.toCharArray()){
            setT.add(c);
        }
        if(setS.size()!=setT.size()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(dic.containsKey(s.charAt(i))){
                if(dic.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
            dic.put(s.charAt(i),t.charAt(i));
        }
        System.out.println(dic);
        return true;*/
    }
    public static void main(String[] args){
        System.out.println("The isomorphic strings are: "+isIsomorphic("egg","add"));
        System.out.println("The isomorphic strings are: "+isIsomorphic("foo","bar"));
        System.out.println("The isomorphic strings are: "+isIsomorphic("paper","title"));
        System.out.println("The isomorphic strings are: "+isIsomorphic("bbbaaaba","aaabbbba"));
        System.out.println("The isomorphic strings are: "+isIsomorphic("badc","baba"));
    }
}
