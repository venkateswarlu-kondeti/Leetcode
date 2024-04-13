package com.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheNumbers {
    public List<Integer> findNumbers(int[] nums){
        List<Integer> ans=new ArrayList<>();
        Set<Integer> numSet=new HashSet<>(); // The set will occupy O(n) space
        for(int num : nums){ // This will occupy O(n) time complexity
            numSet.add(num);
        }
        for(int num : nums){ // This will occupy O(n) time complexity
            if(!numSet.contains(num+1) && !numSet.contains(num-1)){ // This will occupy O(1) time complexity
                ans.add(num);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        FindTheNumbers fn=new FindTheNumbers();
        int[] nums={2,1,3,8,15,25,30,29,31};
        System.out.println("The list with unique values of X that doesnt have X+1 and X-1 is: "+fn.findNumbers(nums));
    }
}

// Total Time complexity: O(n)+O(n)*O(1) = 2*O(n) = O(n)
// Total Space complexity: O(n)