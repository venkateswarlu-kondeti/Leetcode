package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//323. Number of Connected Components in an Undirected Graph
public class NumOfConnectedComponentsInUndirectedGraph {
    public static int countComponents(int n, int[][] edges){
        boolean[] seen=new boolean[n];
        Map<Integer, List<Integer>> graph=new HashMap<>();
        int ans=0;
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        System.out.println(graph);
        for(int i=0;i<n;i++){
           if(!seen[i]){
               seen[i]=true;
               dfs(i,graph,seen);
               ans++;
           }
        }
        return ans;
    }
    public static void dfs(int node, Map<Integer, List<Integer>> graph, boolean[] seen){
        if(graph.containsKey(node)){
            for(int neighbor : graph.get(node)){
                if(!seen[neighbor]){
                    seen[neighbor]=true;
                    dfs(neighbor,graph,seen);
                }
            }
        }
    }
    public static void main(String[] args){
        int n=5;
        int[][] edges={{0,1},{1,2},{3,4}};
        System.out.println("The number of connected components in an undirected graph is: "+NumOfConnectedComponentsInUndirectedGraph.countComponents(n,edges));
        /*int n=5;
        int[][] edges={{0,1},{1,2},{2,3},{3,4}};
        System.out.println("The number of connected components in an undirected graph is: "+NumOfConnectedComponentsInUndirectedGraph.countComponents(n,edges));*/
    }
}
