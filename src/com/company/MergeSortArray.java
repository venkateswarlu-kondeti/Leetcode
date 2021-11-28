package com.company;

import java.util.Arrays;

public class MergeSortArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m,j=0;i<m+n && j<n;i++,j++)
        {
            nums1[i]=nums2[j];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args)
    {
        MergeSortArray ma=new MergeSortArray();
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=3;
        int n=3;
        ma.merge(nums1,m,nums2,n);
    }
}
