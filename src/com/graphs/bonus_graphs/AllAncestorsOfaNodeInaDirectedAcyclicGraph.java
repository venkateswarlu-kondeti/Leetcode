package com.graphs.bonus_graphs;

import java.util.*;

//2192. All Ancestors of a Node in a Directed Acyclic Graph
public class AllAncestorsOfaNodeInaDirectedAcyclicGraph {
    public static Map<Integer, List<Integer>> graph;
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        graph=new HashMap<>();
        for(int[] edge : edges){
            if(!graph.containsKey(edge[1])){
                graph.put(edge[1],new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            if(!graph.containsKey(i)){
                graph.put(i,new ArrayList<>());
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0; i<n;i++){
            ans.add(getNodeAncestors(i));
        }
        return ans;
    }
    public static List<Integer> getNodeAncestors(int child){
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> visited=new ArrayList<>();
        queue.add(child);
        while (!queue.isEmpty()){
            int node=queue.remove();
            for(int ancestor : graph.get(node)){
                if(!visited.contains(ancestor)){
                    visited.add(ancestor);
                    queue.add(ancestor);
                }
            }
        }
        Collections.sort(visited);
        return visited;
    }

    public static void main(String[] args){
       int n = 8;
       int[][] edgeList = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
       System.out.println("Ancestors of a Node in a Directed Acyclic Graph is: "+AllAncestorsOfaNodeInaDirectedAcyclicGraph.getAncestors(n,edgeList));
    }
}
