package com.slidingwindow;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k){
        double curr=0;
        for(int i=0;i<k;i++){
            curr+=nums[i];
        }
        double ans=curr;
        for(int j=k;j< nums.length;j++){
            curr+=nums[j]-nums[j-k];
            ans=Math.max(ans,curr);
        }
        return ans/k;
    }
    public static void main(String[] args){
        MaximumAverageSubarrayI f=new MaximumAverageSubarrayI();
        //int[] nums={1,12,-5,-6,50,3};
        //int[] nums={5};
        int[] nums={0,4,0,3,2};
        //int k=4;
        //int k=1;
        int k=1;
        System.out.println("Max average is: "+f.findMaxAverage(nums,k));
    }
}
