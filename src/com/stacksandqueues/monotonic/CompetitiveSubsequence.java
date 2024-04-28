package com.stacksandqueues.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class CompetitiveSubsequence {
    public  static int[] mostCompetitive(int[] nums, int k){
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[k];
        int count=0;
        for(int num : nums){
            while(!stack.empty() && stack.peek()>num && count< nums.length-k){
                    stack.pop();
                    count++;
            }
                stack.push(num);
        }
        while(stack.size()>k){
            stack.pop();
        }
        System.out.println(stack);
        for(int j=0;j<stack.size();j++){
            ans[j ]=stack.get(j);
        }
        return ans;
    }
    public static void main(String[] args){
        //int[] nums={3,5,2,6};
        //int k=2;
        //int[] nums={71,18,52,29,55,73,24,42,66,8,80,2};
        //int k=3;
        //int[] nums={3, 2, 5, 4};
        //int k=3;
        //int[] nums={2,4,3,3,5,4,9,6};
        //int k=4;
        int[] nums={84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71};
        int k=24;
        System.out.println("The most competitive subsequence is: "+ Arrays.toString(mostCompetitive(nums,k)));
    }
}
