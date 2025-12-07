package com.graphs.bonus_graphs;

import java.util.*;

public class SatisfiabilityOfEqualityEquations {
    public static boolean equationsPossible(String[] equations) {
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(int i=0;i<26;i++){
            graph.put(i,new HashSet<>());
        }
        for(String e : equations){
            if(e.charAt(1)!='!'){
                int x=e.charAt(0)-'a';
                int y=e.charAt(3)-'a';
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
        }
        System.out.println(graph);
        int[] color=new int[26];
        Arrays.fill(color,-1);
        for(int i=0;i<26;i++){
            dfs(i,i,color,graph);
        }
        System.out.println(Arrays.toString(color));
        for(String e : equations){
            int x=e.charAt(0)-'a';
            int y=e.charAt(3)-'a';
            if(e.charAt(1)=='!' && color[x]==color[y]){
                return false;
            }
        }
        return true;
    }
    public static void dfs(int node,int c,int[] color, Map<Integer,Set<Integer>> graph){
        if(color[node]==-1){
            color[node]=c;
            for(int neighbor : graph.get(node)){
                dfs(neighbor,c,color,graph);
            }
        }
    }

    public static void main(String[] args){
        //String[] equations={"a==b","b!=a"};
        //String[] equations={"b==a","a==b"};
        //String[] equations={"a==b","b==c","a==c"};
        String[] equations={"c==c","b==d","x!=z"};
        System.out.println("Satisfiability of Equality Equations is: "+SatisfiabilityOfEqualityEquations.equationsPossible(equations));
    }
}
