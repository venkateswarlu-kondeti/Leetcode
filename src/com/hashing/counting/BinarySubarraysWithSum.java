package com.hashing.counting;
import java.util.HashMap;
import java.util.Map;
//930. Binary Subarrays With Sum
public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal){
        Map<Integer,Integer> dic=new HashMap<>();
        int sum=0;
        int left=0;
        for(int num : nums){
            sum+=num;
        }
        if(sum==0 && goal==0){
            int n=nums.length;
            return n*(n+1)/2;
        }else{
            sum=0;
        }
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            if(sum==goal){
                dic.put(sum,dic.getOrDefault(sum,0)+1);
            }
            if(sum>goal||right==nums.length-1){
                left++;
                right=left-1;
                sum=0;
            }
        }
        return dic.getOrDefault(goal,0);
   }
    public static void main(String[] args){
        System.out.println("The number of sub arrays with the given sum is: "+numSubarraysWithSum(new int[]{1,0,1,0,1},2));
        System.out.println("The number of sub arrays with the given sum is: "+numSubarraysWithSum(new int[]{0,0,0,0,0},0));
        System.out.println("The number of sub arrays with the given sum is: "+numSubarraysWithSum(new int[]{0,0,0,0,1},2));
        System.out.println("The number of sub arrays with the given sum is: "+numSubarraysWithSum(new int[]{0,1,1,1,1},3));
        System.out.println("The number of sub arrays with the given sum is: "+numSubarraysWithSum(new int[]{0,0,0,0,0,0,1,0,0,0},0));
    }
}
