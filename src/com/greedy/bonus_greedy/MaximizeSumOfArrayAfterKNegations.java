package com.greedy.bonus_greedy;

import java.util.Arrays;
//1005. Maximize Sum Of Array After K Negations
public class MaximizeSumOfArrayAfterKNegations {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        while(k>0){
            Arrays.sort(nums);
            nums[0]=-nums[0];
            k--;
        }
        return Arrays.stream(nums).sum();
    }
    public static void main(String[] args){
        int[] nums = {4,2,3}; int k = 1;
        System.out.println("The largest possible sum of the array after modifying it in this way: "+MaximizeSumOfArrayAfterKNegations.largestSumAfterKNegations(nums,k));
    }
}
