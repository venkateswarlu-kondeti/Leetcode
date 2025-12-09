package com.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
//1306. Jump Game III
public class JumpGameIII {
    public static boolean canReach(int[] arr, int start){
        //---------------------Using BFS------------------------------------
        /*Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int node= queue.poll();
            if(arr[node]==0){
                return true;
            }
            if(arr[node]<0){
                continue;
            }
            if(node+arr[node]<arr.length){
                queue.offer(node+arr[node]);
            }
            if(node-arr[node]>=0){
                queue.offer(node-arr[node]);
            }
            arr[node]=-arr[node];
        }
        return false;*/
        //-----------------Using DFS------------------------------------
        if(start>=0 && start< arr.length && arr[start]>=0){
            if(arr[start]==0){
                return true;
            }
            arr[start]=-arr[start];
            return canReach(arr,start+arr[start])||canReach(arr,start-arr[start]);
        }
        return false;
        //--------------My Solution--------------------------------------
        /*Queue<Integer> queue=new LinkedList<>();
        Set<Integer> seen=new HashSet<>();
        queue.add(start);
        seen.add(start);
        while (!queue.isEmpty()){
            int node= queue.remove();
            if(arr[node]==0){
                return true;
            }
            for(int neighbor : new int[]{node-arr[node],node+arr[node]}){
                if(!seen.contains(neighbor) && neighbor>=0 && neighbor< arr.length){
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;*/
    }
    public static void main(String[] args){
        /*int[] arr = {4,2,3,0,3,1,2};
        int start = 5;*/
        /*int[] arr = {4,2,3,0,3,1,2};
        int start = 0;*/
        int[] arr = {3,0,2,1,2};
        int start = 2;
        System.out.println("Can reach index with zero value: "+JumpGameIII.canReach(arr,start));
    }
}
