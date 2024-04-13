package com.company;

import java.util.HashSet;

public class ContainsDuplicateArray {
    public boolean containsDuplicate(int[] nums) {
        boolean status = false;
        HashSet<Integer> numset = new HashSet<Integer>();
        for (int j : nums) {
            if (numset.add(j) == false) {
                status = true;
            }
        }
        return status;
    }

    public static void main(String[] args) {
        ContainsDuplicateArray cd = new ContainsDuplicateArray();
        int[] arr = {3};
        System.out.println("Duplicate in the array: " + cd.containsDuplicate(arr));
    }
}
