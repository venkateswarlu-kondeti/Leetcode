package com.workingspace;

public class WindowProblem4 {
    public int findBestSubarray(int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr={3,-1,4,12,-8,5,6};
        int K=4;
        int R;
        WindowProblem4 m=new WindowProblem4();
        R=m.findBestSubarray(arr,K);
        System.out.println("Answer: "+R);
    }

}
