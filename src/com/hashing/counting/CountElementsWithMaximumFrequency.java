package com.hashing.counting;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums){
        Map<Integer,Integer> dic=new HashMap<>();
        for(int num : nums){
            dic.put(num, dic.getOrDefault(num,0)+1);
        }
        System.out.println(dic);
        int maxFrequency=0;
        for(Map.Entry<Integer,Integer> e : dic.entrySet()){
            maxFrequency=Math.max(maxFrequency,e.getValue());
        }
        System.out.println(maxFrequency);
        int ans=0;
        for(Map.Entry<Integer,Integer> e : dic.entrySet()){
            if(e.getValue()==maxFrequency){
                ans+=maxFrequency;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        CountElementsWithMaximumFrequency f=new CountElementsWithMaximumFrequency();
        //int[] nums={1,2,2,3,1,4};
        int[] nums={1,2,3,4,5};
        System.out.println("The count of elements with maximum frequency is: "+f.maxFrequencyElements(nums));
    }
}
