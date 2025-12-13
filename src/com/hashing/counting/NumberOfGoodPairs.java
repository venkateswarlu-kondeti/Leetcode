package com.hashing.counting;

import java.util.HashMap;
import java.util.Map;
//1512. Number of Good Pairs
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums){
        Map<Integer,Integer> dic=new HashMap<>();
        int ans=0;
        for(int num : nums){
            ans+=dic.getOrDefault(num,0);
            dic.put(num,dic.getOrDefault(num,0)+1);
        }
        return ans;

        // My Solution
        /*Map<Integer,Integer> dic=new HashMap<>();
        int ans=0;
        for(int num : nums){
            if(dic.containsKey(num)){
                ans+=dic.get(num);
            }
            dic.put(num,dic.getOrDefault(num,0)+1);
        }
        return ans;*/
    }
    public static void main(String[] args){
        NumberOfGoodPairs gp=new NumberOfGoodPairs();
        int[] nums={1,2,3,1,1,3};
        //int[] nums={1,1,1,1};
        //int[] nums={1,2,3};
        System.out.println("The number of good pairs is: "+gp.numIdenticalPairs(nums));
    }
}
