package com.greedy;

import java.util.*;
//1481. Least Number of Unique Integers after K Removals
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> counts=new HashMap<>();
        for(int num : arr){
            counts.put(num,counts.getOrDefault(num,0)+1);
        }
        List<Integer> ordered=new ArrayList<>();
        for(int freq : counts.values()){
            ordered.add(freq);
        }
        Collections.sort(ordered,Comparator.reverseOrder());

        while(k>0){
            int freq=ordered.get(ordered.size()-1);
            if(freq<=k){
                k-=freq;
                ordered.remove(ordered.size()-1);
            }else {
                break;
            }
        }
        return ordered.size();
    }
    public static void main(String[] args){
        int[] arr = {5,5,4}; int k = 1;
        System.out.println("The least number of unique integers after removing exactly k elements: "+LeastNumberOfUniqueIntegersAfterKRemovals.findLeastNumOfUniqueInts(arr,k
        ));
    }
}
