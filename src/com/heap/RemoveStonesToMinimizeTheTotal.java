package com.heap;

import com.graphs.OpenTheLock;

import java.util.*;

public class RemoveStonesToMinimizeTheTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Double> heap=new PriorityQueue<>(Comparator.reverseOrder());
        for(double pile : piles){
            heap.add(pile);
        }
        int ans=0;
        while(k!=0){
            heap.add(Math.ceil(heap.remove()/2));
            k--;
        }
        while(!heap.isEmpty()){
            ans+=heap.remove();
        }
        return ans;
    }
    public static void main(String[] args){
        //int[] piles={5,4,9}; int k=2;
        int[] piles={4,3,6,7}; int k=3;
        System.out.println("The minimum possible total number of stones remaining after applying the k operations is: "+RemoveStonesToMinimizeTheTotal.minStoneSum(piles,k));
    }
}
