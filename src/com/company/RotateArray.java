package com.company;

import java.util.Arrays;
import java.util.Stack;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int val;
        int n= nums.length;

//        while(j<k) { // This solution cannot handle large data as it will throw timeout error.
//            for (int i = nums.length - 1; i > 0; i--) {
//                val = nums[i - 1];
//                nums[i - 1] = nums[i];
//                nums[i] = val;
//            }
//            j++;
//        }

//        for (int j = 0; j < k; j++) { // This solution cannot handle large data as it will throw timeout error.
//            val = nums[nums.length - 1];
//            for (int i = nums.length - 1; i > 0; i--) {
//                nums[i] = nums[i - 1];
//            }
//            nums[0] = val;
//        }

        for(int i=0;i<k;i++)
        {
            val=nums[n-1-i];
            nums[n-1-i]=nums[n-1-k-i];
            nums[n-1-k-i]=nums[0];
            nums[0]=val;
            System.out.println(i+" " + Arrays.toString(nums));
        }
        System.out.println("Rotated Array: " + Arrays.toString(nums));
    }

    public static void main(String[] args) {
//        int[] arr = {-1, -100, 3, 99};
//        int[] arr = {1,2,3,4,5,6,7};
        int[] arr = {1};
        RotateArray r = new RotateArray();
        r.rotate(arr, 2);
//        r.rotate(arr, 3);
    }
}
