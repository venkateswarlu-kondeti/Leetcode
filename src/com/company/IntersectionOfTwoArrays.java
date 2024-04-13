package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        for (int i : nums1) {
            a.add(i);
        }
        for (int j : nums2) {
            b.add(j);
        }
        int c = Math.min(a.size(), b.size());
        if (c == a.size()) {
            for (int m = 0; m < a.size(); m++)
                if (b.contains(a.get(m))) {
                    d.add(a.get(m));
                    b.remove(b.indexOf(a.get(m)));
                }
        } else {
            for (int m = 0; m < b.size(); m++)
                if (a.contains(b.get(m))) {
                    d.add(b.get(m));
                    a.remove(a.indexOf(b.get(m)));
                }
        }

        int[] arr = new int[d.size()];
        for (int k = 0; k < d.size(); k++) {
            arr[k] = d.get(k);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {3,1,2};
        int[] nums2 = {1,1};
        IntersectionOfTwoArrays ta = new IntersectionOfTwoArrays();
        ta.intersect(nums1, nums2);
        System.out.println("The intersection of two arrays is: " + Arrays.toString(ta.intersect(nums1, nums2)));
    }
}
