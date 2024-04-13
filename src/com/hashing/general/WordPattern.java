package com.hashing.general;

import java.util.*;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s){
        Map<Character,String > dic=new HashMap<>();
        String[] strs=s.split(" ");
        System.out.println(Arrays.toString(strs));
        if(pattern.length()!= strs.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(dic.containsKey(pattern.charAt(i))){
                if(!dic.get(pattern.charAt(i)).equals(strs[i])){
                    System.out.println(dic);
                    return false;
                }
            }else if(dic.containsValue(strs[i])){
                return false;
            }
            dic.put(pattern.charAt(i),strs[i]);
        }
        System.out.println(dic);
        return true;

        // My Solution
        /*Map<Character,String > dic=new HashMap<>();
        String[] strs=s.split(" ");
        System.out.println(Arrays.toString(strs));
        if(pattern.length()!= strs.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(dic.containsKey(pattern.charAt(i))){
                if(!dic.get(pattern.charAt(i)).equals(strs[i])){
                    System.out.println(dic);
                    return false;
                }
            }
            if(!dic.values().contains(strs[i])){
                dic.put(pattern.charAt(i),strs[i]);
            }else{
                for(Map.Entry<Character,String> e:dic.entrySet()){
                    if(e.getValue().equals(strs[i])){
                        if(e.getKey()!=pattern.charAt(i)){
                            return false;
                        }
                    }
                }
            }
        }
        System.out.println(dic);
        return true;*/
    }
    public static void main(String[] args){
        System.out.println("The word Pattern is: "+wordPattern("abba","dog cat cat dog"));
        System.out.println("The word Pattern is: "+wordPattern("abba","dog cat cat fish"));
        System.out.println("The word Pattern is: "+wordPattern("aaaa","dog cat cat dog"));
        System.out.println("The word Pattern is: "+wordPattern("abba","dog dog dog dog"));
        System.out.println("The word Pattern is: "+wordPattern("aba","cat cat cat dog"));
    }
}
