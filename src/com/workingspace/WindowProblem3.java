package com.workingspace;

public class WindowProblem3 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (left <= right && curr >= k) {
                curr /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr={10,5,2,6};
        int K=100;
        int R;
        WindowProblem3 m=new WindowProblem3();
        R=m.numSubarrayProductLessThanK(arr,K);
        System.out.println("Answer: "+R);
    }

}
