package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfaPairWithEqualSumOfDigits {
    public int maximumSum(int[] nums){
        Map<Integer,Integer> dic=new HashMap<>();
        int ans=-1;
        for(int num : nums){
            int digitSum=getDigitSum(num);
            System.out.println("digitSum is: "+digitSum);
            if(dic.containsKey(digitSum)){
                ans=Math.max(ans,num+dic.get(digitSum));
            }
            dic.put(digitSum,Math.max(dic.getOrDefault(digitSum,0),num));
        }
        System.out.println("dic is: "+dic);
        return ans;
    }

    public int getDigitSum(int num){
        int digitSum=0;
        while(num>0){
            digitSum+=num%10;
            num/=10;
        }
        return digitSum;
    }
    public static void main(String[] args){
        MaxSumOfaPairWithEqualSumOfDigits ds=new MaxSumOfaPairWithEqualSumOfDigits();
        int[] nums={12,21,23,45,32,54};
        System.out.println("The maximum sum of a pair with equal sum of digits is: "+ds.maximumSum(nums));
    }
}
