package com.stacksandqueues.monotonic;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public static long subArrayRanges(int[] nums){
        Stack<Integer> stack=new Stack<>();
        long totalMinVal=0,totalMaxVal=0,mid,midValue,Occurance;
        for(int i=0;i<=nums.length;i++){
                while (!stack.empty() && (i== nums.length || nums[stack.peek()]>=nums[i])){
                    mid=stack.peek();
                    midValue= nums[stack.pop()];
                    Occurance=(i-mid)*(mid-(stack.empty()? -1 : stack.peek()));
                    totalMinVal+=Occurance*midValue;
                }
                stack.push(i);
        }
        stack.clear();
        for(int i=0;i<=nums.length;i++){
                while (!stack.empty() && (i== nums.length || nums[stack.peek()]<=nums[i])){
                    mid=stack.peek();
                    midValue= nums[stack.pop()];
                    Occurance=(i-mid)*(mid-(stack.empty()? -1 : stack.peek()));
                    totalMaxVal+=Occurance*midValue;
                }
                stack.push(i);
        }
        return totalMaxVal-totalMinVal;
    }
    public static void main(String[] args){
        //int[] nums={1,2,3};
        //int[] nums={1,3,3};
        int[] nums={4,-2,-3,4,1};
        System.out.println("The sum of subarray ranges is: "+subArrayRanges(nums));
    }
}
