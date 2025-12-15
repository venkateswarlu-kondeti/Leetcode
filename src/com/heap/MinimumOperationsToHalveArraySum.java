package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
//2208. Minimum Operations to Halve Array Sum
public class MinimumOperationsToHalveArraySum {
    public static int halveArray(int[] nums){
        double target=0;
        PriorityQueue<Double> heap=new PriorityQueue<>(Comparator.reverseOrder());
        for(double num : nums){
            target+=num;
            heap.add(num);
        }
        int ans=0;
        target/=2;
        while (target>0){
            ans++;
            double x=heap.remove();
            target-=(x/2);
            heap.add(x/2);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={5,19,8,1};
        System.out.println("The minimum operations to halve array sum is: "+MinimumOperationsToHalveArraySum.halveArray(nums));
    }
}
