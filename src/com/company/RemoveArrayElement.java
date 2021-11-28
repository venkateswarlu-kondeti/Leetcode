package com.company;

import java.util.Arrays;
public class RemoveArrayElement {
    public int removeElement(int[] nums, int val) {
        int cnt=0;
        for(int i: nums){
            if (i!=val)
            {
             nums[cnt]=i;
             cnt++;
            }
        }
        System.out.println("Output - " + Arrays.toString(nums));
        return cnt;
    }
    public static void main(String[] args) {
        RemoveArrayElement re = new RemoveArrayElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(re.removeElement(nums, val));
    }
}

