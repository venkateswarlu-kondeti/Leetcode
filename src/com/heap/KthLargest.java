package com.heap;

import java.util.PriorityQueue;
//703. Kth Largest Element in a Stream
public class KthLargest {
    public PriorityQueue<Integer> heap;
    public int k;
    public KthLargest(int k, int[] nums) {
        heap=new PriorityQueue<>();
        this.k=k;
        for(int num : nums){
            heap.add(num);
        }
    }

    public int add(int val) {
        heap.add(val);
        while(heap.size()>k){
            heap.remove();
        }
        return heap.peek();
    }
    public static void main(String[] args){
        int[] nums={4,5,8,2}; int k=3;
        KthLargest kthLargest=new KthLargest(k,nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
