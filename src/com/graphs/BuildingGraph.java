package com.graphs;
// First input format : array of edges
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingGraph {
    public static Map<Integer, List<Integer>> buildGraph(int[][] edges){
        Map<Integer, List<Integer>> graph=new HashMap<>();
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            if(!graph.containsKey(x)){
                graph.put(x,new ArrayList<>());
            }
            graph.get(x).add(y);
        }
        return graph;
    }
    public static void main(String[] args){
        int[][] edges={{0,1},{1,2},{2,0},{2,3}};
        System.out.println("The output is: "+BuildingGraph.buildGraph(edges));
    }
}
