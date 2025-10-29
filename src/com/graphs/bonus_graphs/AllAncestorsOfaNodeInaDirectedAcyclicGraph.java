package com.graphs.bonus_graphs;

import java.util.*;

//All Ancestors of a Node in a Directed Acyclic Graph
public class AllAncestorsOfaNodeInaDirectedAcyclicGraph {
    //public static Map<Integer, List<Integer>> graph;
    public static List<List<Integer>> graph;
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        /*graph=new HashMap<>();
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
        }*/
        graph=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[1]).add(edge[0]);
        }
        //System.out.println(graph);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=n-1; i>=0;i--){
            ans.add(getNodeAncestors(i));
        }
        Collections.reverse(ans);
        return ans;
    }
    public static List<Integer> getNodeAncestors(int child){
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> ancestorSet=new HashSet<>();
        queue.add(child);
        while (!queue.isEmpty()){
            int node=queue.remove();
            for(int ancestor : graph.get(node)){
                ancestorSet.add(ancestor);
                queue.add(ancestor);
            }
        }
        List<Integer> ancestorList=new ArrayList<>(ancestorSet);
        Collections.sort(ancestorList);
        return ancestorList;
    }

    public static void main(String[] args){
       int n = 8;
       int[][] edgeList = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
       System.out.println("Ancestors of a Node in a Directed Acyclic Graph is: "+AllAncestorsOfaNodeInaDirectedAcyclicGraph.getAncestors(n,edgeList));
    }
}
