package com.company;

import java.util.Arrays;

public class ThirdDistinctMax {

    public int thirdMax(int[] nums) {
        int m = 0, cnt = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != m) {
                m = nums[i];
                cnt++;
            }
            if (cnt == 3) {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
        if (nums.length < 3 || cnt < 3) {
            m = nums[nums.length - 1];
        }
        return m;
    }

    public static void main(String[] args) {
        ThirdDistinctMax td = new ThirdDistinctMax();
        int[] nums = {2, 2, 3, 1};
        System.out.println(td.thirdMax(nums));
    }
}
