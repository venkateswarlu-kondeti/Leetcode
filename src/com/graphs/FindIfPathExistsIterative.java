package com.graphs;

import java.util.*;

public class FindIfPathExistsIterative {
    public static boolean validPathIterative(int n, int[][] edges, int source, int destination) {
        boolean[] seen=new boolean[n];
        Map<Integer, List<Integer>> graph=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        seen[source]=true;
        stack.push(source);
        while (!stack.empty()){
            int currNode=stack.pop();
            if(currNode==destination){
                return true;
            }
            for(int nextNode : graph.get(currNode)){
                if(!seen[nextNode]){
                    seen[nextNode]=true;
                    stack.push(nextNode);
                }
            }
        }
        return false;
        //-------------------------My Solution---------------------------------
        /*boolean[] seen = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        seen[source] = true;
        stack.push(source);
        while (!stack.empty()) {
            int node = stack.pop();
            if (node == destination) {
                return true;
            }
            for (int neighbor : graph.get(node)) {
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return false;*/
    }
    public static void main(String[] args){
        int n=10;
        int[][] edges={{2,9},{7,8},{5,9},{7,2},{3,8},{2,8},{1,6},{3,0},{7,0},{8,5}};
        int source=1;
        int destination=0;
        System.out.println("Path Exists? "+FindIfPathExistsIterative.validPathIterative(n,edges,source,destination));
    }
}
