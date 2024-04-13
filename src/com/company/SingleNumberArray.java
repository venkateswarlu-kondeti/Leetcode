package com.company;

import java.util.HashSet;

public class SingleNumberArray {
    public int singleNumber(int[] nums) {
        int val = 0;
        HashSet<Integer> numset=new HashSet<Integer>();
        HashSet<Integer> numsdup=new HashSet<Integer>();
        for(int i: nums)
        {
            if(numset.add(i)==false)
            {
                numsdup.add(i);
            }
        }
        for(int j:numset) {
            if (!numsdup.contains(j)) {
                val=j;
            }
        }
      return val;
    }
    public static void main(String[] args)
    {
        int[] arr={1};
        SingleNumberArray sn=new SingleNumberArray();
        System.out.println("The single number is: "+sn.singleNumber(arr));
    }
}
