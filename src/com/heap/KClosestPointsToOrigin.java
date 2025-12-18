package com.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
//973. K Closest Points to Origin
public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap=new PriorityQueue<>((nums1,nums2) ->{
            int sq1=Math.abs(nums1[0]*nums1[0]+nums1[1]*nums1[1]);
            int sq2=Math.abs(nums2[0]*nums2[0]+nums2[1]*nums2[1]);
            return sq2-sq1;
        });

        for(int[] point : points){
            heap.add(point);
            if(heap.size()>k){
                heap.remove();
            }
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i]= heap.remove();
        }
        return ans;
    }
    public static void main(String[] args){
        //int[][] points = {{1,3},{-2,2}}; int k = 1;
        //int[][] points = {{3,3},{5,-1},{-2,4}}; int k = 2;
        //int[][] points = {{-5,4},{-6,-5},{4,6}}; int k = 2;
        int[][] points = {{-41,72},{53,83},{-95,-31},{-61,68},{32,-56},{16,88},{-81,-48},{-31,56},{-57,-74},{24,-42},{-59,72},{-86,40},{34,-85},{-45,22},{-35,-95}}; int k=9;
        System.out.println("The k closest points to the origin (0, 0) : "+Arrays.deepToString(KClosestPointsToOrigin.kClosest(points,k)));
    }
}
