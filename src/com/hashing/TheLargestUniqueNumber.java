package com.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheLargestUniqueNumber {
    public int largestUniqueNumber(int[] nums){
        Map<Integer,Integer> counts=new HashMap<>();
        int ans=-1;
        for(int num : nums){
            counts.put(num,counts.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : counts.entrySet()){
            if(entry.getValue()==1){
                ans=Math.max(ans,entry.getKey());
            }
        }
        return ans;

        // my Solution------------------------------
        /*Map<Integer,Integer> counts=new HashMap<>();
        int ans=-1;
        for(int num : nums){
            counts.put(num,counts.getOrDefault(num,0)+1);
        }
        System.out.println(counts);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i= nums.length-1;i>=0;i--){
            if(counts.get(nums[i])==1){
                ans=Math.max(ans,nums[i]);
            }
        }
        return ans;*/
    }
    public static void main(String[] args){
        TheLargestUniqueNumber un=new TheLargestUniqueNumber();
        int[] nums = {5,7,3,9,4,9,8,3,1};
        //int[] nums = {9,9,8,8};
        System.out.println("The largest unique number is: "+un.largestUniqueNumber(nums));
    }
}
