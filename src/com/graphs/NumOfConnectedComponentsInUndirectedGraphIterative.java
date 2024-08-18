package com.graphs;

import java.util.*;

public class NumOfConnectedComponentsInUndirectedGraphIterative {
    public static int countComponentsIterative(int n, int[][] edges){
        boolean[] seen=new boolean[n];
        Map<Integer, List<Integer>> graph=new HashMap<>();
        int ans=0;
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<n;i++){
            if(!seen[i]){
                stack.push(i);
                ans++;
            }
            while(!stack.empty()){
                int node=stack.pop();
                if(graph.containsKey(node)){
                    for(int neighbor : graph.get(node)){
                        if(!seen[neighbor]){
                            seen[neighbor]=true;
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int n=5;
        int[][] edges={{0,1},{1,2},{3,4}};
        System.out.println("The number of connected components in an undirected graph is: "+NumOfConnectedComponentsInUndirectedGraphIterative.countComponentsIterative(n,edges));
    }
}
