package com.graphs.bonus_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n>1){
            return -1;
        }else if(trust.length==0 && n==1){
            return 1;
        }
        Map<Integer, List<Integer>> graph=new HashMap<>();
        for(int[] t : trust){
            int x=t[0];
            int y=t[1];
            if(!graph.containsKey(x)){
                graph.put(x,new ArrayList<>());
            }
            graph.get(x).add(y);
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(!graph.containsKey(i)){
                ans=i;
            }
        }
        for(List<Integer> lst : graph.values()){
            if(!lst.contains(ans)){
               return -1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        //int n=2;
        //int[][] trust={{1,2}};
        //int n=3;
        //int[][] trust={{1,3},{2,3}};
        //int n=3;
        //int[][] trust={{1,3},{2,3},{3,1}};
        int n=4;
        int[][] trust={{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println("The town judge is: "+findJudge(n,trust));
    }
}
