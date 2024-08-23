package com.graphs;

import java.util.*;

public class ReachableNodesWithRestrictions {
    public static Set<Integer> seen;
    public static Map<Integer,List<Integer>> graph;
    public static int reachableNodes(int n, int[][] edges, int[] restricted){
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
        System.out.println(graph);
        seen.add(0);
        ans++;
        return dfs(0,seen, ans);
    }
    public static int dfs(int node, Set<Integer> seen, int ans){
        for(int neighbor : graph.get(node)){
            if(!seen.contains(neighbor)){
                seen.add(neighbor);
                ans++;
                ans=dfs(neighbor,seen, ans);
            }
        }
        return ans;
    }

    //-----------------------Other solution---------------------------------------------------------
    /*public static Set<Integer> seen;
    public static Map<Integer,List<Integer>> graph;
    public static Set<Integer> restrictedValues;
    public static int reachableNodes(int n, int[][] edges, int[] restricted){
        restrictedValues=new HashSet<>();
        for(int r : restricted){
            restrictedValues.add(r);
        }
        seen=new HashSet<>();
        graph=new HashMap<>();
        for(int[] edge : edges){
            int x=edge[0];
            int y=edge[1];
                graph.computeIfAbsent(x, val -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
        }
        System.out.println(graph);
        seen.add(0);
        dfs(0,restrictedValues);
        return seen.size();
    }
    public static void dfs(int node, Set<Integer> restrictedValues){
        for(int neighbor : graph.get(node)){
            if(!seen.contains(neighbor) && !restrictedValues.contains(neighbor)){
                seen.add(neighbor);
                dfs(neighbor,restrictedValues);
            }
        }
    }*/
    public static void main(String[] args){
        /*int n=7;
        int[][] edges={{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] restricted={4,5};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictions.reachableNodes(n,edges,restricted));*/

        /*int n=7;
        int[][] edges={{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}};
        int[] restricted={4,2,1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictions.reachableNodes(n,edges,restricted));*/

        /*int n=2;
        int[][] edges={{0,1}};
        int[] restricted={1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictions.reachableNodes(n,edges,restricted));*/

        int n=10;
        int[][] edges={{8,2},{2,5},{5,0},{2,7},{1,7},{3,8},{0,4},{3,9},{1,6}};
        int[] restricted={9,8,4,5,3,1};
        System.out.println("The reachable nodes with restrictions are: "+ReachableNodesWithRestrictions.reachableNodes(n,edges,restricted));
    }
}
