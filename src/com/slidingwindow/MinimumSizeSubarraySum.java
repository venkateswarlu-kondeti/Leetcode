package com.slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums){
        int left=0;
        int curr=0;
        int ans=0;
        int sum=0;
        for(int i=0;i< nums.length;i++){
            sum+=nums[i];
            if(sum>=target){
                ans= nums.length;
            }
        }

        for(int right=0;right<nums.length;right++){
            curr+=nums[right];
            while(curr>=target){
                ans=Math.min(ans,right-left+1);
                curr-=nums[left];
                left++;
            }
        }
        return ans;
    }
    public static void main (String[] args){
        MinimumSizeSubarraySum m=new MinimumSizeSubarraySum();
        //int t=7;
        //int[] nums={2,3,1,2,4,3};
        int t=4;
        int[] nums={1,4,4};
        //int t=11;
        //int[] nums={1,1,1,1,1,1,1,1};
        System.out.println("Minimum Sub array size is: "+m.minSubArrayLen(t,nums));
    }
}
