package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
//295. Find Median from Data Stream
public class MedianFinder {
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
    public MedianFinder() {

    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.add(minHeap.remove());
        }
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        return  (maxHeap.peek()+minHeap.peek())/2.0;
    }
    public static void main(String[] args){
        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("The median value is: "+medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("The median value is: "+medianFinder.findMedian());
    }
}
