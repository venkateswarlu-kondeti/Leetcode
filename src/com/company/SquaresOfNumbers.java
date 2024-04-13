package com.company;

import java.util.Arrays;

public class SquaresOfNumbers {
    /*public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ((int) Math.pow(nums[i], 2));
        }
        Arrays.sort(nums);
        return nums;
    }*/
    public int[] sortedSquares(int[] nums){
        int n=nums.length;
        int[] result=new int[n];
        int left=0;
        int right=n-1;
        for(int i=n-1;i>=0;i--){
            int square;
            if(Math.abs(nums[left])<Math.abs(nums[right])){
                square=nums[right];
                right--;
            }else
            {
                square=nums[left];
                left++;
            }
            result[i]=square*square;
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfNumbers sn = new SquaresOfNumbers();
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println("Array of squares of numbers in non-decreasing order :" + Arrays.toString(sn.sortedSquares(nums)));
    }
}
