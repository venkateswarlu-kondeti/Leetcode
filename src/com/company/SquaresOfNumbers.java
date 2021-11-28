package com.company;

import java.util.Arrays;

public class SquaresOfNumbers {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ((int) Math.pow(nums[i], 2));
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        SquaresOfNumbers sn = new SquaresOfNumbers();
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println("Array of squares of numbers in non-decreasing order :" + Arrays.toString(sn.sortedSquares(nums)));
    }
}
