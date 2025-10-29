package com.graphs.bonus_graphs;

import java.util.*;

public class MaximalNetworkRank {
    public static int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int[] road : roads){
            int x=road[0];
            int y=road[1];
            graph.computeIfAbsent(x,k->new HashSet<>()).add(y);
            graph.computeIfAbsent(y,k->new HashSet<>()).add(x);
        }
        int currVal=0;
        int ans=0;
        for(int node1=0;node1<n;node1++){
            for(int node2=node1+1;node2<n;node2++){
                currVal=graph.getOrDefault(node1,new HashSet<>()).size()+graph.getOrDefault(node2,new HashSet<>()).size();
                if(graph.getOrDefault(node1,new HashSet<>()).contains(node2)){
                    currVal--;
                }
                ans=Math.max(ans,currVal);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int n=4;
        int[][] roads={{0,1},{0,3},{1,2},{1,3}};
        //int n=5;
        //int[][] roads={{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}};
        //int n=8;
        //int[][] roads={{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}};
        System.out.println("The maximal network rank is: "+maximalNetworkRank(n,roads));
    }
}
