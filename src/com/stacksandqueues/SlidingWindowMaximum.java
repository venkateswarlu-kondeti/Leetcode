package com.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k){
        int[] ans=new int[nums.length-3+1];
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        for(int i=0;i< nums.length;i++){
            if(!queue.isEmpty() && nums[i]>nums[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(i);

            if(queue.getFirst()+3==i){
                queue.removeFirst();
            }

            if(i>=k-1){
                ans[i-k+1]=nums[queue.getFirst()];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={1,3,-1,-3,-2,3,6,7};
        int k=3;
        System.out.println("The maximum of sliding window is: "+ Arrays.toString(maxSlidingWindow(nums,k)));
    }
}
