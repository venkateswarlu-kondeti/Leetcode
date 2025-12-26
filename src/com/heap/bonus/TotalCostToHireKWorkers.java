package com.heap.bonus;

import java.util.*;

public class TotalCostToHireKWorkers {
    public static long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headHeap=new PriorityQueue<>();
        PriorityQueue<Integer> tailHeap=new PriorityQueue<>();
        int i=0;
        int j=costs.length-1;
        long ans=0;
        while(k>0){
            while(headHeap.size()<candidates && i<=j){
                headHeap.add(costs[i]);
                i++;
            }
            while(tailHeap.size()<candidates && j>=i){
                tailHeap.add(costs[j]);
                j--;
            }
            if(!headHeap.isEmpty() && !tailHeap.isEmpty() && headHeap.peek()==tailHeap.peek()){
                ans+=headHeap.remove();
            }else if (!headHeap.isEmpty() && !tailHeap.isEmpty() && headHeap.peek()>tailHeap.peek()) {
                ans+=tailHeap.remove();
            }else if(!headHeap.isEmpty()) {
                ans+=headHeap.remove();
            }else if(!tailHeap.isEmpty()) {
                ans+=tailHeap.remove();
            }
            k--;
        }
        return ans;
    }
    public static void main(String[] args){
        //int[] costs = {17,12,10,2,7,2,11,20,8}; int k = 3, candidates = 4;
        //int[] costs = {1,2,4,1}; int k = 3, candidates = 3;
        int[] costs = {57,33,26,76,14,67,24,90,72,37,30}; int k = 11, candidates = 2;
        System.out.println("The total cost to hire exactly k workers: "+TotalCostToHireKWorkers.totalCost(costs,k,candidates));
    }
}
