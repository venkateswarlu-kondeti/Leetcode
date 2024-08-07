package com.slidingwindow;

import java.util.Arrays;

public class MinimumValuetoGetPositiveStepbyStepSum {
    public int minStartValue(int[] nums){
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<prefix.length;i++){
            ans=Math.min(ans,prefix[i]);
        }
        return ans<1? Math.abs(ans)+1 : 1;

        //---------------Other Solution---------------------------------------
        /*int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i< nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int startValue=1;
        int total=0;
        while(startValue>=1){
            for(int j=0;j< nums.length;j++){
                total=prefix[j]+startValue;
                if(total<1){
                    j=nums.length-1;
                }
            }
            if(total<1){
                startValue++;
            }else{
                break;
            }
        }
        return startValue;*/
    }
    public static void main(String[] args){
        MinimumValuetoGetPositiveStepbyStepSum m=new MinimumValuetoGetPositiveStepbyStepSum();
        int[] nums={-3,2,-3,4,2};
        //int[] nums={1,2};
        //int[] nums={1,-2,-3};
        System.out.println("Minimum sum value is: "+ m.minStartValue(nums));
    }
}
