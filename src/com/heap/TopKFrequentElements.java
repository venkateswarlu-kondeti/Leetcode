package com.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//347. Top K Frequent Elements
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counts=new HashMap<>();
        for(int num : nums){
            counts.put(num,counts.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>((n1,n2) -> counts.get(n1)-counts.get(n2));
        for(int num : counts.keySet()){
            heap.add(num);
            if(heap.size()>k){
                heap.remove();
            }
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]= heap.remove();
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3}; int k = 2;
        System.out.println("The k most frequent elements are: "+ Arrays.toString(TopKFrequentElements.topKFrequent(nums,k)));
    }
}
