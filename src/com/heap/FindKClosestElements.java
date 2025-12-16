package com.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
//658. Find K Closest Elements
public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((n1,n2) -> {
            if(Math.abs(n1-x)==Math.abs(n2-x)){
                return n2-n1;
            }
            return Math.abs(n2-x)-Math.abs(n1-x);
        });
        for(int num :arr){
            heap.add(num);
            if(heap.size()>k){
                heap.remove();
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!heap.isEmpty()){
            ans.add(heap.remove());
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5}; int k = 4, x = 3;
        System.out.println("The k closest integers to x in the array is: "+FindKClosestElements.findClosestElements(arr,k,x));
    }
}
