package com.company;

import java.util.Arrays;

public class SortArrayByPartyElements {
    public int[] sortArrayByParity(int[] nums) {
        int evenCnt = 0, oddCnt = 0, D = 0, m = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                evenCnt--;
            } else {
                D = nums[j];
                while (oddCnt > 0 && evenCnt > 0) {
                    if (nums[m] % 2 == 0) {
                        nums[j] = nums[m];
                        nums[m] = D;
                        oddCnt--;
                        m--;
                        break;
                    } else {
                        m--;
                        oddCnt--;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByPartyElements sa = new SortArrayByPartyElements();
        int[] nums = {1, 0, 3};
        System.out.println(Arrays.toString(sa.sortArrayByParity(nums)));
    }
}
