package com.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumArray {
    int ans=0;
    int[] prefix;
    int[] nums;
    public NumArray(int[] nums){
        this.nums=nums;
        prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i< nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
    System.out.println(Arrays.toString(prefix));
    }
    public int sumRange(int left, int right){
        ans=prefix[right]-(prefix[left]-nums[left]);
        return ans;
    }

    public static void main(String[] args){
        int[] nums={-2, 0, 3, -5, 2, -1};
        NumArray numArray=new NumArray(nums);
        List<Integer> l=new ArrayList<>();
        l.add(numArray.sumRange(0,2));
        l.add(numArray.sumRange(2,5));
        l.add(numArray.sumRange(0,5));
        System.out.println(l);
    }
}
