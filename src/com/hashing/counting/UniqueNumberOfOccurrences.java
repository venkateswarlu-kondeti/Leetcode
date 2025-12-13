package com.hashing.counting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//1207. Unique Number of Occurrences
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr){
        Map<Integer,Integer> dic=new HashMap<>();
        Set<Integer> s=new HashSet<>();
        for(int num : arr){
            dic.put(num,dic.getOrDefault(num,0)+1);
        }
        System.out.println(dic);
        for(Map.Entry<Integer,Integer> e: dic.entrySet()){
            if(s.contains(e.getValue())){
                return false;
            }
            s.add(e.getValue());
        }
        return true;
    }
    public static void main(String[] args){
        UniqueNumberOfOccurrences uo=new UniqueNumberOfOccurrences();
        //int[] arr={1,2,2,1,1,3};
        //int[] arr={1,2};
        int[] arr={-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println("The unique number of occurrences is: "+uo.uniqueOccurrences(arr));
    }
}
