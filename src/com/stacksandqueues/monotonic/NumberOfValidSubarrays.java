package com.stacksandqueues.monotonic;
import java.util.Stack;

public class NumberOfValidSubarrays {
    public static int validSubarrays(int[] nums){
        Stack<Integer> stack=new Stack<>();
        int ans=0;
        for(int i=0;i< nums.length;i++){
            while(!stack.empty() && nums[stack.peek()]>nums[i]){
                ans+=i-stack.pop();
            }
            stack.push(i);
        }
        while(!stack.empty()){
            ans+=nums.length-stack.pop();
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={1,4,2,5,3};
        //int[] nums={3,2,1};
        //int[] nums={2,2,2};
        //int[] nums={15,1,15,20,10,17,19,17};
        //int[] nums={14,20,5,13,18,8,2,14,3,13};
        System.out.println("The number of valid subarrays are: "+validSubarrays(nums));
    }
}
