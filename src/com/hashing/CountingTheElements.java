package com.hashing;

import java.util.HashSet;
import java.util.Set;

public class CountingTheElements {
    public int countElements(int[] arr){
        Set<Integer> elements=new HashSet<>(); // This costs O(n) space complexity
        int dup=0;
        int count=0;
        for(int val : arr){ // This costs O(n) time complexity
            if(elements.contains(val)){ // This costs O(1) time complexity
                dup++;
            }
            elements.add(val);
        }
        for(int val : arr){ // This costs O(n) time complexity
            if(elements.contains(val+1)){ // This costs O(1) time complexity
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        CountingTheElements ce=new CountingTheElements();
        //int[] arr={1,2,3};
        int[] arr={1,1,3,3,5,5,7,7};
        System.out.println("The elements counted are: "+ce.countElements(arr));
    }
}

// Total time complexity: O(n)+O(n) = O(n)
// Total Space complexity: O(n)