package com.binarySearch;

import java.util.Arrays;
//410. Split Array Largest Sum
public class SplitArrayLargestSum {
    public static int splits;
    public static int splitArray(int[] nums, int k) {
        splits=k;
        int ans=0;
        int left= Arrays.stream(nums).max().getAsInt();
        int right=Arrays.stream(nums).sum();
        while (left<=right){
            int mid=left+(right-left)/2;
            if(check(mid,nums)){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    public static boolean check(int maxSum,int[] nums){
        int count=0,sum=0;
        for(int num : nums){
            sum+=num;
            if(sum>maxSum){
                count++;
                sum=num;
            }
        }
        return count+1<=splits;
    }
    public static void main(String[] args){
        int[] nums = {7,2,5,10,8}; int k = 2;
        //int[] nums = {1,2,3,4,5}; int k = 2;
        System.out.println("The minimized largest sum of the split: "+SplitArrayLargestSum.splitArray(nums,k));
    }
}
