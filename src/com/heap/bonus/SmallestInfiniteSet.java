package com.heap.bonus;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
//2336. Smallest Number in Infinite Set
public class SmallestInfiniteSet {
    public PriorityQueue<Integer> heap;
    public Set<Integer> isPresent;
    public int currentValue;
    public SmallestInfiniteSet() {
        heap=new PriorityQueue<>();
        isPresent=new HashSet<>();
        currentValue=1;
    }

    public int popSmallest() {
        int ans;
        if(!heap.isEmpty()){
            ans=heap.remove();
            isPresent.remove(ans);
        }else{
            ans=currentValue;
            currentValue++;
        }
        return ans;
    }

    public void addBack(int num) {
        if(currentValue<=num || isPresent.contains(num)){
            return;
        }
        heap.add(num);
        isPresent.add(num);
    }

    //-----------My Solution: Brute ---------------------
    /*public PriorityQueue<Integer> head;
    public SmallestInfiniteSet() {
        head=new PriorityQueue<>();
        for(int i=1;i<=1000;i++){
            head.add(i);
        }
    }

    public int popSmallest() {
        return head.remove();
    }

    public void addBack(int num) {
        if(!head.contains(num)){
            head.add(num);
        }
    }*/

    public static void main(String[] args){
        SmallestInfiniteSet smallestInfiniteSet=new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}
