package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 547.Number of Provinces
public class NumberOfProvinces {
    static Map<Integer, List<Integer>> graph=new HashMap<>();
    static boolean[] seen;
    public static int findCircleNum(int[][] isConnected){
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            if(!graph.containsKey(i)){
                graph.put(i,new ArrayList<>());
            }
            for(int j=i+1;j<n;j++){
                if(!graph.containsKey(j)){
                    graph.put(j,new ArrayList<>());
                }
                if(isConnected[i][j]==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        seen=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!seen[i]){
                ans++;
                seen[i]=true;
                dfs(i);
            }
        }
        return ans;
    }
    public static void dfs(int node){
        for(int neighbor : graph.get(node)){
            if(!seen[neighbor]){
                seen[neighbor]=true;
                dfs(neighbor);
            }
        }
    }
    public static void main(String[] args){
        int[][] isConnected={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("The number of provinces is: "+NumberOfProvinces.findCircleNum(isConnected));
    }
}
