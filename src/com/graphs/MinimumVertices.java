package com.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1557. Minimum Number of Vertices to Reach All Nodes
public class MinimumVertices {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges){
        int[] indegree=new int[n];
        for(List<Integer> edge : edges){
            indegree[edge.get(1)]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int n=6;
        List<List<Integer>> edges= Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(0,2),
                Arrays.asList(3,4),
                Arrays.asList(4,2),
                Arrays.asList(2,5)
        );
        System.out.println("The minimum number of vertices to reach all nodes is: "+MinimumVertices.findSmallestSetOfVertices(n,edges));
    }
}
