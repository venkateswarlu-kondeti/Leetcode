package com.company;

public class MaxConsecutiveOnes {
    int cnt, maxConsOnes;

    public int findMaxConsecutiveOnes(int[] nums) {

        for (int i : nums) {
            if (i == 1) {
                cnt++;
                maxConsOnes = Math.max(cnt, maxConsOnes);
            } else {
                cnt = 0;
            }
        }
        return maxConsOnes;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes maxCnt = new MaxConsecutiveOnes();
        int[] nums = {1, 0, 1, 0, 1, 0};
        System.out.println("The number of consecutive 1's in an array is : " + maxCnt.findMaxConsecutiveOnes(nums));
    }
}

