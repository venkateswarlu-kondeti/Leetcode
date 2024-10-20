package com.graphs;

//1129. Shortest Path with Alternating Colors

import java.util.*;

public class ShortestPathWithAlternatingColors {
    public static int RED=0;
    public static int BLUE=1;
    public static Map<Integer, Map<Integer, List<Integer>>> graph=new HashMap<>();
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges){
        graph.put(RED, new HashMap<>());
        graph.put(BLUE, new HashMap<>());

        addToGraph(RED,redEdges,n);
        addToGraph(BLUE,blueEdges,n);

        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);

        Queue<State> queue=new LinkedList<>();
        queue.add(new State(0,RED,0));
        queue.add(new State(0,BLUE,0));

        boolean[][] seen=new boolean[n][2];
        seen[0][RED]=true;
        seen[0][BLUE]=true;

        while (!queue.isEmpty()){
            State state=queue.remove();
            int node=state.node, color= state.color, steps= state.steps;
            ans[node]=Math.min(ans[node],steps);

            for(int neighbor: graph.get(color).get(node)){
                if(!seen[neighbor][1-color]){
                    seen[neighbor][1-color]=true;
                    queue.add(new State(neighbor,1-color,steps+1));
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE){
                ans[i]=-1;
            }
        }
        return ans;
    }
    public static void addToGraph(int color, int[][] edges, int n){
        for(int i=0;i<n;i++){
            graph.get(color).put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            int x=edge[0], y=edge[1];
            graph.get(color).get(x).add(y);
        }
    }
    public static void main(String[] args){
        /*int n=3;
        int[][] redEdges={{0,1},{1,2}};
        int[][] blueEdges={};*/

        /*int n=3;
        int[][] redEdges={{0,1}};
        int[][] blueEdges={{2,1}};*/

        int n=5;
        int[][] redEdges={{0,1},{2,3}};
        int[][] blueEdges={{1,2},{3,4}};
        System.out.println("The shortest path with alternating colors is: "+ Arrays.toString(ShortestPathWithAlternatingColors.shortestAlternatingPaths(n,redEdges,blueEdges)));
    }
    public static class State{
        int node;
        int color;
        int steps;
        State(int node, int color, int steps){
            this.node=node;
            this.color=color;
            this.steps=steps;
        }
    }
}
