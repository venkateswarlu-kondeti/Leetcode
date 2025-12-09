package com.graphs;

import java.util.*;
//1971. Find if Path Exists in Graph
public class FindIfPathExists {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        return dfs(graph,seen,source,destination);
    }
    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination){
        if(currNode==destination){
            return true;
        }
        if(!seen[currNode]){
            seen[currNode]=true;
            for(int nextNode : graph.get(currNode)){
                if(dfs(graph,seen,nextNode,destination)){
                    return true;
                }
            }
        }
        return false;

        //--------------------My Solution-----------------------
        /*boolean[] seen=new boolean[n];
        Map<Integer, List<Integer>> graph=new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        seen[source]=true;
        return dfs(source,graph,seen,destination);
    }
    public static boolean dfs(int node, Map<Integer, List<Integer>> graph, boolean[] seen, int destination){
        if(node==destination){
            return true;
        }
        for(int neighbor : graph.get(node)){
            if(!seen[neighbor]){
                seen[neighbor]=true;
                if(dfs(neighbor,graph,seen,destination)){
                    return true;
                }
            }
        }
        return false;*/
    }
    public static void main(String[] args){
        /*int n=3;
        int[][] edges={{0,1},{1,2},{2,0}};
        int source=0;
        int destination=2;*/
        /*int n=6;
        int[][] edges={{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source=0;
        int destination=5;*/
        int n=10;
        int[][] edges={{2,9},{7,8},{5,9},{7,2},{3,8},{2,8},{1,6},{3,0},{7,0},{8,5}};
        int source=1;
        int destination=0;
        System.out.println("Path Exists? "+FindIfPathExists.validPath(n,edges,source,destination));
    }
}
