package com.hashing.counting;

import java.util.HashMap;
import java.util.Map;
//2958. Length of Longest Subarray With at Most K Frequency
public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums,int k){
        int left=0;
        int ans=0;
        Map<Integer,Integer> counts=new HashMap<>();
        for(int right=0;right<nums.length;right++){
            int curr=nums[right];
            counts.put(curr,counts.getOrDefault(curr,0)+1);
            while(counts.get(curr)>k){
                int leftVal=nums[left];
                counts.put(leftVal,counts.get(leftVal)-1);
                left++;
                if(counts.get(leftVal)==0){
                    counts.remove(leftVal);
                }
            }
            ans=Math.max(ans, right-left+1);
        }
        return ans;
    }
    public static void main(String[] args){
        LengthOfLongestSubarrayWithAtMostKFrequency ls=new LengthOfLongestSubarrayWithAtMostKFrequency();
        //int[] nums={1,2,3,1,2,3,1,2};
        //int k=2;
        //int[] nums={1,2,1,2,1,2,1,2};
        //int k=1;
        int[] nums={5,5,5,5,5,5,5};
        int k=4;
        System.out.println("The length of longest subarray with at most k frequency is: "+ls.maxSubarrayLength(nums,k));
    }
}
