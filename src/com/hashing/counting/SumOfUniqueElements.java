package com.hashing.counting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfUniqueElements {
    public int sunOfUnique(int[] nums){
        Map<Integer,Integer>  dic=new HashMap<>();
        for(int num : nums){
            dic.put(num, dic.getOrDefault(num, 0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer> e : dic.entrySet()){
            if(e.getValue()==1){
                ans+=e.getKey();
            }
        }
        System.out.println(dic);
        return ans;
    }
    public static void main(String[] args){
        SumOfUniqueElements u=new SumOfUniqueElements();
        //int[] nums={1,2,3,2};
        //int[] nums={1,1,1,1,1};
        int[] nums={1,2,3,4,5};
        System.out.println("The sum of uniques elements is: "+u.sunOfUnique(nums));
    }
}
