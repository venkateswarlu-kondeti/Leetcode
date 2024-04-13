package com.hashing;

import java.util.HashSet;
import java.util.Set;

public class TheMissingNumber {
    public int missingNumber(int[] nums){
        Set<Integer> v=new HashSet<>(); // This costs O(n) Space complexity
        int ans=0;
        for(int num : nums){ // This costs O(n) time complexity
            v.add(num);
        }
        for(int i=0;i<=nums.length;i++){ // This costs O(n) time complexity
            if(!v.contains(i)){ // This costs O(1) time complexity
                ans=i;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        TheMissingNumber mn=new TheMissingNumber();
        //int[] nums={3,0,1};
        //int[] nums={0,1};
        int[] nums={9,6,4,2,3,5,7,0,1};
        System.out.println("The missing number is: "+mn.missingNumber(nums));
    }
}

// Total time complexity: O(n+n) = O(n)
// Total space complexity: O(n)