package com.twopointers;

import java.util.Arrays;

public class MoveZeroesNums {

    public void moveZeroes(int[] nums){
        int left=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[left]=nums[i];
                left++;
            }
        }
        while(left< nums.length){
            nums[left]=0;
            left++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args){
        MoveZeroesNums mz=new MoveZeroesNums();
        //int[] nums={0,1,0,3,12};
        int[] nums={0};
        mz.moveZeroes(nums);
    }
}
