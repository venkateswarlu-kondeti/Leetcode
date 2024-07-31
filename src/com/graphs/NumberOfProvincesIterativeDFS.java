package com.graphs;

import java.util.*;

public class NumberOfProvincesIterativeDFS {
    public static Map<Integer, List<Integer>> graph=new HashMap<>();
    public static List<Integer> seen;
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
        seen=new ArrayList<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if (!seen.contains(i)) {
                ans++;
                seen.add(i);
                dfs(i);
            }
        }
        return ans;
    }
    public static void dfs(int start){
        Stack<Integer> stack=new Stack<>();
        stack.add(start);
        while(!stack.empty()){
            int node=stack.pop();
            for(int neighbor : graph.get(node)){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
    }
    public static void main(String[] args){
        int[][] isConnected={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("The number of provinces is: "+NumberOfProvincesIterativeDFS.findCircleNum(isConnected));
    }
}
