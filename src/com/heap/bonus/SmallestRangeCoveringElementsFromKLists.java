package com.heap.bonus;

import java.util.*;
//632. Smallest Range Covering Elements from K Lists
public class SmallestRangeCoveringElementsFromKLists {
    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> rangeMin=new PriorityQueue<>((a,b) ->{
            if(a[1]-a[0]==b[1]-b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1]-a[0],b[1]-b[0]);
        });
        PriorityQueue<int[]> minToIndexHeap=new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int maxValue=Integer.MIN_VALUE;

        for(int i=0;i<nums.size();i++){
            minToIndexHeap.add(new int[]{nums.get(i).get(0),i,0});
            maxValue=Math.max(maxValue,nums.get(i).get(0));
        }

        while(minToIndexHeap.size()==nums.size()){
            int[] currData=minToIndexHeap.poll();
            int minValue=currData[0], minRow=currData[1], minCol=currData[2];

            rangeMin.add(new int[]{minValue,maxValue});

            if(minCol+1<nums.get(minRow).size()){
                minToIndexHeap.add(new int[]{nums.get(minRow).get(minCol+1),minRow,minCol+1});
                maxValue=Math.max(maxValue,nums.get(minRow).get(minCol+1));
            }
        }
        return rangeMin.poll();
    }
    public static void main(String[] args){
        /*List<List<Integer>> nums =new ArrayList<>();
        nums.add(List.of(4,10,15,24,26));
        nums.add(List.of(0,9,12,20));
        nums.add(List.of(5,18,22,30));*/

        List<List<Integer>> nums =new ArrayList<>();
        nums.add(List.of(1,2,3));
        nums.add(List.of(1,2,3));
        nums.add(List.of(1,2,3));
        System.out.println("The smallest range that includes at least one number from each of the k lists: "+Arrays.toString(SmallestRangeCoveringElementsFromKLists.smallestRange(nums)));
    }
}
