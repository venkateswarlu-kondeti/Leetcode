package com.company;

import java.util.Arrays;

public class RemoveDuplicateElements {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1, len = nums.length;
        Arrays.sort(nums);
        while (i < len && j < len) {
            if (nums[j] == nums[i]) {
                for (int k = j; k < len; k++) {
                    nums[k - 1] = nums[k];
                }
                len--;
            } else {
                i++;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

    public static void main(String[] args) {
        RemoveDuplicateElements rd = new RemoveDuplicateElements();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(rd.removeDuplicates(nums));
    }
}


