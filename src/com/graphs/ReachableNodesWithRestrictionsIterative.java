package com.graphs;

import java.util.*;

public class ReachableNodesWithRestrictionsIterative {
    public static Set<Integer> seen;
    public static Map<Integer, List<Integer>> graph;
    public static int reachableNodesIterative(int n, int[][] edges, int[] restricted){
        seen=new HashSet<>();
        int ans=0;
        for(int r : restricted){
            seen.add(r);
        }
        graph=new HashMap<>();
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        seen.add(0);
        ans++;
        while(!stack.empty()){
            int node=stack.pop();
            for(int neighbor : graph.get(node)){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    stack.push(neighbor);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        /*int n=7;
        int[][] edges={{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] restricted={4,5};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictionsIterative.reachableNodesIterative(n,edges,restricted));*/

        /*int n=7;
        int[][] edges={{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}};
        int[] restricted={4,2,1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictionsIterative.reachableNodesIterative(n,edges,restricted));*/

        int n=2;
        int[][] edges={{0,1}};
        int[] restricted={1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictionsIterative.reachableNodesIterative(n,edges,restricted));

        /*int n=10;
        int[][] edges={{8,2},{2,5},{5,0},{2,7},{1,7},{3,8},{0,4},{3,9},{1,6}};
        int[] restricted={9,8,4,5,3,1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictionsIterative.reachableNodesIterative(n,edges,restricted));*/
    }
}
