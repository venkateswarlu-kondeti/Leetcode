package com.heap;

import java.util.PriorityQueue;
//215. Kth Largest Element in an Array
public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int num : nums){
            heap.add(num);
            if(heap.size()>k){
                heap.remove();
            }
        }
        return heap.remove();
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4}; int k = 2;
        //int[] nums = {3,2,3,1,2,4,5,5,6}; int k = 4;
        System.out.println("The kth largest element in the array is: "+KthLargestElementInAnArray.findKthLargest(nums,k));
    }
}
