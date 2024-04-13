package com.company;

import java.util.Arrays;

public class TwoSumArray {
    public int[] twoSum(int[] nums, int target) {
        int[] rslt=new int[2];
        for(int i=0;i< nums.length;i++)
        {
            for(int j=i+1;j< nums.length;j++)
            {
                if(nums[j]+nums[i]==target)
                {
                    rslt[0]=i;
                    rslt[1]=j;
                    break;
                }
            }
        }
        return rslt;
    }
    public static void main(String[] args)
    {
        int[] arr={3,3};
        int target=6;
        TwoSumArray ts=new TwoSumArray();
        System.out.println("The two sum is: "+ Arrays.toString(ts.twoSum(arr,target)));
    }
}
