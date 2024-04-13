package com.slidingwindow;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k){
        int left=0;
        int right;
        for(right=0;right< nums.length;right++){
            if(nums[right]==0){
                k--;
            }
            if(k<0){
                k+=1-nums[left];
                left++;
            }
        }
        return right-left;
    }
    public static void main(String[] args){
        MaxConsecutiveOnesIII m=new MaxConsecutiveOnesIII();
        //int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        //int k=2;
        int[] nums={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        System.out.println("Longest array with 1s is: "+m.longestOnes(nums,k));
    }
}
