package com.greedy;

import java.util.Arrays;
//2294. Partition Array Such That Maximum Difference Is K
public class PartitionArraySuchThatMaximumDifferenceIsK {
    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=1;
        int x=nums[0];
        for(int i=1;i< nums.length;i++){
            if(nums[i]-x>k){
                ans++;
                x=nums[i];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        //int[] nums = {3,6,1,2,5}; int k = 2;
        int[] nums = {1,2,3}; int k = 1;
        System.out.println("The minimum number of subsequences needed: "+PartitionArraySuchThatMaximumDifferenceIsK.partitionArray(nums,k));
    }
}


