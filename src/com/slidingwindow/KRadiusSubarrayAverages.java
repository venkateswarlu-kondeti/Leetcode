package com.slidingwindow;

import java.util.Arrays;

public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k){
        int n= nums.length;
        long[] prefix=new long[n+1];
        int[] avg=new int[n];
        for(int i=0;i< n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        for(int j=0;j< n;j++){
            if( j<k || j+k+1>n){
                avg[j]=-1;
            }else {
                avg[j]=(int)((prefix[j+k+1]-prefix[j-k])/(2*k+1));
            }
        }
        return avg;
    }
    public static void main(String[] args){
        KRadiusSubarrayAverages r=new KRadiusSubarrayAverages();
        int[] nums={7,4,3,9,1,8,5,2,6};
        int k=3;
        //int[] nums={100000};
        //int k=0;
        //int[] nums={8};
        //int k=100000;
        System.out.println("K radius subarray averages is :"+ Arrays.toString(r.getAverages(nums,k)));
    }
}
