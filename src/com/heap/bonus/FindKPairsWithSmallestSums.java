package com.heap.bonus;

import java.util.*;
//373. Find K Pairs with Smallest Sums
public class FindKPairsWithSmallestSums {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<List<Integer>> heap=new PriorityQueue<>((a,b) -> a.get(0)-b.get(0));
        Set<Pair> visited=new HashSet<>();
        int i=0,j=0;
        visited.add(new Pair(i,j));
        heap.add(new ArrayList<>(Arrays.asList(nums1[i]+nums2[j],i,j)));
        while(ans.size()<k && !heap.isEmpty()){
            List<Integer> top=heap.remove();
            i=top.get(1);
            j=top.get(2);

            ans.add(new ArrayList<>(Arrays.asList(nums1[i],nums2[j])));

            if(i+1< nums1.length && !visited.contains(new Pair(i+1,j))){
                heap.add(new ArrayList<>(Arrays.asList(nums1[i+1]+nums2[j],i+1,j)));
                visited.add(new Pair(i+1,j));
            }
            if(j+1< nums2.length && !visited.contains(new Pair(i,j+1))){
                heap.add(new ArrayList<>(Arrays.asList(nums1[i]+nums2[j+1],i,j+1)));
                visited.add(new Pair(i,j+1));
            }

        }
        //System.out.println(heap);
        return ans;
    }
    public static class Pair{
        int num1Index;
        int num2Index;
        Pair(int num1Index,int num2Index){
            this.num1Index=num1Index;
            this.num2Index=num2Index;
        }
        //Without Override HashSet treats every object as unique, Duplicate pairs will NOT be detected.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return num1Index == p.num1Index && num2Index == p.num2Index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num1Index, num2Index);
        }
    }
    public static void main(String[] args){
        //int[] nums1 = {1,7,11}, nums2 = {2,4,6}; int k = 3;
        //int[] nums1 = {1,1,2}, nums2 = {1,2,3}; int k = 2;
        //int[] nums1 = {1,2,4,5,6}, nums2 = {3,5,7,9}; int k = 3;
        int[] nums1 = {1,2,4,5,6}, nums2 = {3,5,7,9}; int k = 20;
        System.out.println("The k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums is: "+FindKPairsWithSmallestSums.kSmallestPairs(nums1,nums2,k));
    }
}
