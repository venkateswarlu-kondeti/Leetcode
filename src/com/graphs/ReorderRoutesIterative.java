package com.graphs;

import java.util.*;

public class ReorderRoutesIterative {
    public static Set<String> roads=new HashSet<>();
    public static Map<Integer, List<Integer>> graph=new HashMap<>();
    public static Set<Integer> seen=new HashSet<>();
    public static int minReorderIterative(int n, int[][] connections){
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] connection : connections){
            int x=connection[0];
            int y=connection[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
            roads.add(convertToHashIterative(x,y));
        }
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        stack.add(0);
        seen.add(0);
        while(!stack.empty()){
            int node=stack.pop();
            for(int neighbor : graph.get(node)){
                if(!seen.contains(neighbor)){
                    if(roads.contains(convertToHashIterative(node,neighbor))){
                        ans++;
                    }
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return ans;
    }
    public static String convertToHashIterative(int x, int y){
        return String.valueOf(x)+","+String.valueOf(y);
    }
    public static void main(String[] args){
        int n=6;
        int[][] connections={{0,1},{3,1},{2,3},{4,0},{5,4}};
        System.out.println("The number of paths to be flipped to make all paths lead to the city zero is: "+ReorderRoutesIterative.minReorderIterative(n,connections));
    }
}
