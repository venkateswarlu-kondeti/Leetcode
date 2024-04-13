package com.hashing.checkingForExistence;

import java.util.HashSet;
import java.util.Set;

public class ContainsTheDuplicate {
    public boolean containsDuplicate(int[] nums){
        Set<Integer> s=new HashSet<>(); // Space Complexity: O(n)
        boolean ans=false;
        for(int num : nums){ // Time Complexity: O(n)
            if(s.contains(num)){
                ans=true;
                break;
            }
            s.add(num);
        }
        return ans;
    }
    public static void main(String[] args){
        ContainsTheDuplicate d=new ContainsTheDuplicate();
        //int[] nums={1,2,3,1};
        //int[] nums={1,2,3,4};
        int[] nums={1,1,1,3,3,4,3,2,4,2};
        System.out.println("Contains Duplicate? "+d.containsDuplicate(nums));
    }
}
 // Total Space Complexity: O(n)
 // Total Time Complexity: O(n)