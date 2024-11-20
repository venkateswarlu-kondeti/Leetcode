package com.graphs;

import java.util.*;

public class DetonateTheMaximumBombs {
    public static Map<Integer, List<Integer>> graph;
    public static Set<Integer> seen;
    public static int maximumDetonation(int[][] bombs){
        graph=new HashMap<>();
        for(int i=0;i<bombs.length;i++){
            for(int j=0;j<bombs.length;j++){
                if(i==j){
                    continue;
                }
                // The below condition is Euclidean distance formula: d^2=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)
                if((long)bombs[i][2]*bombs[i][2]>=(long)(bombs[i][0]-bombs[j][0])*(bombs[i][0]-bombs[j][0])+(long)(bombs[i][1]-bombs[j][1])*(bombs[i][1]-bombs[j][1])){
                    graph.computeIfAbsent(i, k->new ArrayList<>()).add(j);
                }
            }
        }
        System.out.println(graph);
        int ans=0;
        seen=new HashSet<>();
        for(int i=0; i<bombs.length;i++){
            seen.add(i);
            ans=Math.max(ans,bfs(i,graph));
            seen.clear();
        }
        return ans;
    }
    public static int bfs(int i,Map<Integer,List<Integer>> graph){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        while (!queue.isEmpty()){
            int node= queue.remove();
            for(int neighbor : graph.getOrDefault(node,new ArrayList<>())){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return seen.size();
    }
    public static void main(String[] args){
        //int[][] bombs = {{2,1,3},{6,1,4}};
        //int[][] bombs = {{1,1,5},{10,10,5}};
        //int[][] bombs = {{4,4,3},{4,4,3}};
        //int[][] bombs = {{1,1,100000},{100000,100000,1}};
        int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
        System.out.println("The maximum detonate bombs are: "+DetonateTheMaximumBombs.maximumDetonation(bombs));
    }
}
