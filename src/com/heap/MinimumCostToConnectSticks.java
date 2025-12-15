package com.heap;

import java.util.PriorityQueue;
//1167. Minimum Cost to Connect Sticks
public class MinimumCostToConnectSticks {
    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int stick : sticks){
            heap.add(stick);
        }
        int cost=0;
        while (heap.size()>1){
            int stick1=heap.remove();
            int stick2=heap.remove();
            heap.add(stick1+stick2);
            cost+=(stick1+stick2);
        }
        return cost;
    }

    public static void main(String[] args){
        //int[] sticks = {2,4,3};
        int[] sticks = {1,8,3,5};
        System.out.println("The minimum cost of connecting all the given sticks into one stick in this ways is: "+MinimumCostToConnectSticks.connectSticks(sticks));
    }
}
