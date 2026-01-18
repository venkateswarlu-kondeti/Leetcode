package com.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//1338. Reduce Array Size to The Half
public class ReduceArraySizeToTheHalf {
    public static int minSetSize(int[] arr) {
        Map<Integer,Integer> counts=new HashMap<>();
        for(int a : arr){
            counts.put(a,counts.getOrDefault(a,0)+1);
        }
        System.out.println(counts);
        PriorityQueue<Integer> freqMaxHeap=new PriorityQueue<>((a,b) ->counts.get(b)-counts.get(a));
        for(int num : counts.keySet()){
            freqMaxHeap.add(num);
        }
        int fullLength= arr.length, halfLength= arr.length/2, ans=0;

        while(fullLength>halfLength){
            int currValue=freqMaxHeap.remove();
            ans++;
            fullLength-=counts.get(currValue);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println("The minimum size of the set so that at least half of the integers of the array are removed: "+ReduceArraySizeToTheHalf.minSetSize(arr));
    }
}
