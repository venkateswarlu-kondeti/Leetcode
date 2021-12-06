package com.company;

import java.util.Arrays;

public class MoveZerosArray {
    public void moveZeroes(int[] nums) {
        int cnt = 0, m = 0, k = nums.length - 1;
        for (int i : nums) {
            if (i == 0) {
                cnt++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[m] = nums[j];
                m++;
            }
        }
        while (cnt > 0) {
            nums[k] = 0;
            cnt--;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZerosArray mz = new MoveZerosArray();
        int[] nums = {0};
        mz.moveZeroes(nums);
    }
}
