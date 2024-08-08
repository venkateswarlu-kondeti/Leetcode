package com.prefixsum;

import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums){
        int n= nums.length;
        int[] prefix=new int[n];
        int ans=-1;
        int leftSum=0;
        int rightSum=0;
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        System.out.println(Arrays.toString(prefix));
        for(int j=0;j<n;j++){
            leftSum=prefix[j]-nums[j];
            rightSum=prefix[n-1]-prefix[j];
            if(leftSum==rightSum){
                return j;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        FindPivotIndex pi=new FindPivotIndex();
        //int[] nums={1,7,3,6,5,6};
        //int[] nums={1,2,3};
        //int[] nums={2,1,-1};
        int[] nums={-1,-1,0,0,-1,-1};
        System.out.println("Pivot index is: "+pi.pivotIndex(nums));
    }
}
