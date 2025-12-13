package com.hashing;

import java.util.HashMap;
import java.util.Map;
//560. Subarray Sum Equals K
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k){
        Map<Integer,Integer> counts=new HashMap<>();
        counts.put(0,1);
        int ans=0;
        int curr=0;
        for(int num : nums){
            curr+=num;
            ans+=counts.getOrDefault(curr-k,0);
            counts.put(curr,counts.getOrDefault(curr,0)+1);
        }
        return ans;
    }

    public static void main(String[] args){
        SubarraySumEqualsK se=new SubarraySumEqualsK();
        int[] nums={1, 2, 1, 2, 1};
        int k=3;
        System.out.println("Sum of subarray is: "+se.subarraySum(nums,k));
    }
}
