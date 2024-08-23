package com.graphs;

import java.util.*;

public class ReachableNodesWithRestrictionsBFS {
    public static int reachableNodesBFS(int n,int[][] edges, int[] restricted){
        Set<Integer> seen=new HashSet<>();
        Map<Integer, List<Integer>> graph=new HashMap<>();
        int ans=0;
        for(int r : restricted){
            seen.add(r);
        }
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
            graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        seen.add(0);
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int node= queue.poll();;
            ans++;
            for(int neighbor : graph.get(node)){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        /*int n=7;
        int[][] edges={{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] restricted={4,5};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictionsBFS.reachableNodesBFS(n,edges,restricted));*/

        /*int n=7;
        int[][] edges={{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}};
        int[] restricted={4,2,1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictionsBFS.reachableNodesBFS(n,edges,restricted));*/

        /*int n=2;
        int[][] edges={{0,1}};
        int[] restricted={1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictionsBFS.reachableNodesBFS(n,edges,restricted));*/

        int n=10;
        int[][] edges={{8,2},{2,5},{5,0},{2,7},{1,7},{3,8},{0,4},{3,9},{1,6}};
        int[] restricted={9,8,4,5,3,1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictionsBFS.reachableNodesBFS(n,edges,restricted));
    }
}
