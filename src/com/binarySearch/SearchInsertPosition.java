package com.binarySearch;

import java.util.Arrays;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args){
        //int[] nums = {1,3,5,6}; int target = 5;
        //int[] nums = {1,3,5,6}; int target = 2;
        int[] nums = {1,3,5,6}; int target = 7;
        System.out.println("The index if the target is found: "+SearchInsertPosition.searchInsert(nums,target));
    }
}
