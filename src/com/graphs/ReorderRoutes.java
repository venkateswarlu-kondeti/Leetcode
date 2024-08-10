package com.graphs;
//  1466. Reorder Routes to Make All Paths Lead to the City Zero
import java.util.*;

//1466. Reorder Routes to Make All Paths Lead to the City Zero
public class ReorderRoutes {
    public static Set<String> roads=new HashSet<>();
    public static Map<Integer, List<Integer>> graph=new HashMap<>();
    public static Set<Integer> seen=new HashSet<>();
    public static int minReorder(int n, int[][] connections){
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] connection : connections){
            int x=connection[0];
            int y=connection[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
            roads.add(convertToHash(x,y));
        }
        seen.add(0);
        return dfs(0);
    }
    public static int dfs(int node){
        int ans=0;
        for(int neighbor : graph.get(node)){
            if(!seen.contains(neighbor)){
                if(roads.contains(convertToHash(node,neighbor))){
                    ans++;
                }
                seen.add(neighbor);
                ans+=dfs(neighbor);
            }
        }
        return ans;
    }
    public static String convertToHash(int x, int y){
        return String.valueOf(x)+","+String.valueOf(y);
    }
    public static void main(String[] args){
        int n=6;
        int[][] connections={{0,1},{3,1},{2,3},{4,0},{5,4}};
        System.out.println("The number of paths to be flipped to make all paths lead to the city zero is: "+ReorderRoutes.minReorder(n,connections));
    }
}
