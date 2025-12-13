package com.hashing.counting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//1695. Maximum Erasure Value
public class MaximumErasureValue {
    public static int maximumUniqueSubarray(int[] nums){
        Set<Integer> s=new HashSet<>();
        int sum=0;
        int ans=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(s.contains(nums[right])){
                sum-=nums[left];
                s.remove(nums[left]);
                left++;
            }
            ans=Math.max(ans,sum);
            s.add(nums[right]);
        }
        return ans;
    }
    public static void main(String[] args){
        //System.out.println("The maximum erasure value is: "+maximumUniqueSubarray(new int[]{4,2,4,5,6}));
        //System.out.println("The maximum erasure value is: "+maximumUniqueSubarray(new int[]{2, 4, 3, 5, 4, 1}));
        //System.out.println("The maximum erasure value is: "+maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
        System.out.println("The maximum erasure value is: "+maximumUniqueSubarray(new int[]{187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434}));
    }
}
