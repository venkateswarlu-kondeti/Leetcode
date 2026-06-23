package com.binarySearch;

import java.util.Arrays;
//2389. Longest Subsequence With Limited Sum
public class LongestSubsequenceWithLimitedSum {
    public static int[] answerQueries(int[] nums, int[] queries) {
        int n=nums.length;
        int m= queries.length;
        int[] answer=new int[m];
        Arrays.sort(nums);
        int[] prefixSum=new int[n];
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        for(int i=0;i< queries.length;i++){
            answer[i]=longestBinarySearch(prefixSum,queries[i]);
        }
        System.out.println(Arrays.toString(prefixSum));
        return answer;
    }
    public static int longestBinarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                return mid+1;
            }
            if(arr[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args){
        //int[] nums = {4,5,2,1}, queries = {3,10,21};
        int[] nums = {2,3,4,5}, queries = {1};
        System.out.println("The Longest Subsequence With Limited Sum: "+Arrays.toString(LongestSubsequenceWithLimitedSum.answerQueries(nums,queries)));
    }
}
