package com.workingspace;

public class WindowProblem1 {
    public int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,1,2,5};
        WindowProblem1 m=new WindowProblem1();
        int R;
        R=m.findLength(arr, 4);
        System.out.println("Answer: "+R);
    }
}
