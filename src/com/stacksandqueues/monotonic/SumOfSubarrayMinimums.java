package com.stacksandqueues.monotonic;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static int sumSubarrayMins(int[] arr){
        int MOD = 1000000007;
        Stack<Integer> stack=new Stack<>();
        long ans=0;
        int mid;
        long count;
        for(int i=0;i<arr.length;i++){
            while(!stack.empty() && arr[stack.peek()]>=arr[i]){
                mid=stack.pop();
                count=(mid-(stack.empty()? -1 : stack.peek()))*(i-mid)%MOD;
                ans+=(count*arr[mid])%MOD;
            }
            stack.push(i);
        }
        while(!stack.empty()){
            mid=stack.pop();
            count=(mid-(stack.empty()? -1 : stack.peek()))*(arr.length-mid)%MOD;
            ans+=(count*arr[mid])%MOD;
        }
        ans%=MOD;
        System.out.println(stack);
        System.out.println(ans);
        return (int)ans;
    }
    public static void main(String[] args){
        //int[] arr={3,1,2,4};
        int[] arr={11,81,94,43,3};
        //int[] arr={3,4,4,5,4,1};
        System.out.println("The sum of subarray minimums is: "+sumSubarrayMins(arr));
    }
}
