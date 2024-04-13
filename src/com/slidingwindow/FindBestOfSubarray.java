package com.slidingwindow;

public class FindBestOfSubarray {
    public int findBestSubarray(int[] nums, int k){
        int curr=0;
        for (int i=0;i<4;i++){
            curr+=nums[i];
        }
        int ans=curr;
        for(int j=k;j< nums.length;j++){
            curr+=nums[j]-nums[j-k];
            ans=Math.max(ans,curr);
        }
        return ans;
    }
    public static void main(String[] args){
        FindBestOfSubarray f=new FindBestOfSubarray();
        int[] nums={3,-1,4,12,-8,5,6};
        int k=4;
        System.out.println("The best sub array is: "+f.findBestSubarray(nums, k));
    }
}
