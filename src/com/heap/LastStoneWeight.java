package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
//1046. Last Stone Weight
public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> heap=new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones){
            heap.add(stone);
        }
        while(heap.size()>1){
            int first=heap.remove();
            int second=heap.remove();
            if(first!=second){
                heap.add(first-second);
            }
        }
        return heap.isEmpty() ? 0 : heap.remove();
    }
    public static void main(String[] args){
        int[] heap={2,7,4,1,8,1};
        System.out.println("The last stone weight is: "+LastStoneWeight.lastStoneWeight(heap));
    }
}
