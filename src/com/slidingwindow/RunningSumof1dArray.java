package com.slidingwindow;

import java.util.Arrays;

public class RunningSumof1dArray {
    public int[] runningSum(int[] nums){
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1; i< nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        return prefix;
    }

    public static void main(String[] args){
        RunningSumof1dArray r=new RunningSumof1dArray();
        //int[] nums={1,2,3,4};
        //int[] nums={1,1,1,1,1};
        int[] nums={3,1,2,10,1};
        System.out.println("Running sum is: "+ Arrays.toString(r.runningSum(nums)));
    }
}
