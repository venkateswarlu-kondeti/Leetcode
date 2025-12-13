package com.hashing;

import java.util.*;
//1. Two Sum
public class SumTwoNumbers {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> dic=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int complement=target-num;
            if(dic.containsKey(complement)){ // This operation is O(1)
                return new int[]{i,dic.get(complement)};
            }
            dic.put(num,i);
        }
        return new int[]{-1,-1};
    }

    // If you want to return the pair of numbers summing to target:
    /*public int[] twoSum(int[] nums, int target){
        Set<Integer> dic=new HashSet<>();
        int num;
        for(int i=0;i<nums.length;i++){
            num=nums[i];
            int complement=target-num;
            if(dic.contains(complement)){ // This operation is O(1)
                return new int[]{num,complement};
            }
            dic.add(num);
        }
        return new int[]{-1,-1};
    }*/

    // If want to return boolean:
    /*public Boolean twoSum(int[] nums, int target){
        Set<Integer> dic=new HashSet<>();
        int num;
        Boolean result=true;
        for(int i=0;i<nums.length;i++){
            num=nums[i];
            int complement=target-num;
            if(dic.contains(complement)){ // This operation is O(1)
                return result;
            }
            dic.add(num);
        }
        return false;
    }*/
    public static void main(String[] args){
        SumTwoNumbers st=new SumTwoNumbers();
        int[] nums={5,2,7,10,3,9};
        int t=8;
        System.out.println("Two Sum is: "+ Arrays.toString(st.twoSum(nums,t)));
        //System.out.println("Two Sum exists? "+ st.twoSum(nums,t));
    }
}
