package com.graphs;

import java.util.*;

public class FindIfPathExistsUsingBFS {
    public static boolean validPathUsingBFS(int n, int[][] edges, int source, int destination){
        boolean[] seen=new boolean[n];
        Map<Integer, List<Integer>> graph=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        seen[source]=true;
        queue.offer(source);
        while (!queue.isEmpty()){
            int currNode=queue.poll();
            if(currNode==destination){
                return true;
            }
            for(int nextNode : graph.get(currNode)){
                if(!seen[nextNode]){
                    seen[nextNode]=true;
                    queue.offer(nextNode);
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int n=10;
        int[][] edges={{2,9},{7,8},{5,9},{7,2},{3,8},{2,8},{1,6},{3,0},{7,0},{8,5}};
        int source=1;
        int destination=0;
        System.out.println("Path Exists? "+FindIfPathExistsUsingBFS.validPathUsingBFS(n,edges,source,destination));
    }
}
