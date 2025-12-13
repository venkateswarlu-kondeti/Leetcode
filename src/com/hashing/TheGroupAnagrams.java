package com.hashing;

import java.util.*;
//49. Group Anagrams
public class TheGroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> groups=new HashMap<>();
        for(String s : strs){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(!groups.containsKey(key)){
                groups.put(key,new ArrayList<String>());
            }
            groups.get(key).add(s);
        }
        return new ArrayList<>(groups.values());
    }
    public static void main(String[] args){
        TheGroupAnagrams a=new TheGroupAnagrams();
        String[] str={"eat","tea","tan","ate","nat","bat"};
        System.out.println("The group of anagrams is: "+a.groupAnagrams(str));
    }
}
