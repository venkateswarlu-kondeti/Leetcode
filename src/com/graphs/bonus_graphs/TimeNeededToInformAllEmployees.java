package com.graphs.bonus_graphs;

import java.util.*;
//1376. Time Needed to Inform All Employees
public class TimeNeededToInformAllEmployees {
    //--------------DFS-------------------------------------
    /*public static int maxTime=Integer.MIN_VALUE;
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer,ArrayList<Integer>> edgeListMap=new HashMap<>();
        for(int i=0;i<n;i++){
             edgeListMap.put(i, new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                edgeListMap.get(manager[i]).add(i);
            }
        }
        System.out.println(edgeListMap);
        dfs(edgeListMap,informTime,headID,0);
        return maxTime;
    }
    public static void dfs(Map<Integer,ArrayList<Integer>> edges, int[] informTime, int currHead, int time){
        maxTime=Math.max(maxTime,time);
        for(int neighbor : edges.get(currHead)){
            dfs(edges,informTime,neighbor,time+informTime[currHead]);
        }
    }*/

    //---------BFS-------------------------------------

    public static int maxTime=Integer.MIN_VALUE;
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime){
        Map<Integer,ArrayList<Integer>> edgeListMap=new HashMap<>();
        for(int i=0;i<n;i++){
            edgeListMap.put(i, new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                edgeListMap.get(manager[i]).add(i);
            }
        }
        System.out.println(edgeListMap);
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(headID,0));
        while (!queue.isEmpty()){
            Pair pair=queue.remove();
            int parent=pair.parent;
            int time=pair.time;
            maxTime=Math.max(maxTime,time);
            for(int neighbor : edgeListMap.get(parent)){
                queue.add(new Pair(neighbor,time+informTime[parent]));
            }
        }
        return maxTime;
    }
    public static class Pair{
        int parent;
        int time;
        public Pair(int parent, int time){
            this.parent=parent;
            this.time=time;
        }
    }

    public static void main(String[] args){
        /*int n=6;
        int headID=2;
        int[] manager={2,2,-1,2,2,2};
        int[] informTime={0,0,1,0,0,0};*/
        int n=15;
        int headID=0;
        int[] manager={-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime={1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println("The time needed to inform all the employees is: "+TimeNeededToInformAllEmployees.numOfMinutes(n,headID,manager,informTime));
    }
}
