package com.graphs;

import java.lang.reflect.Array;
import java.util.*;
//909. Snakes and Ladders
public class TheSnakesAndLadders {
    public static int snakesAndLadders(int[][] board){
        Map<Integer, int[]> labelToCellMap=new HashMap<>();
        Map<Integer,Integer> labelToDistanceMap=new HashMap<>();
        labelToDistanceMap.put(1,0);
        int n=board.length;
        for(int i=2;i<=n*n;i++){
            labelToDistanceMap.put(i,-1);
        }
        List<Integer> columns=new ArrayList<>();
        int label=1;
        for(int col=0;col<n;col++){
            columns.add(col);
        }
        for(int row=n-1;row>=0;row--){
            for(int column : columns){
                labelToCellMap.put(label,new int[]{row,column});
                System.out.println(Arrays.toString(labelToCellMap.get(label)));
                label++;
            }
            Collections.reverse(columns);
        }
        System.out.println(labelToCellMap);
        System.out.println(labelToDistanceMap);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int curr=queue.remove();
            for(int next=curr+1;next<=Math.min(curr+6,n*n);next++){
                int row=labelToCellMap.get(next)[0];
                int col=labelToCellMap.get(next)[1];
                int destination=board[row][col]!=-1 ? board[row][col] : next;
                if(labelToDistanceMap.get(destination)==-1){
                    labelToDistanceMap.put(destination,labelToDistanceMap.get(curr)+1);
                    queue.add(destination);
                }
            }
        }
        return labelToDistanceMap.get(n*n);
    }
    public static void main(String[] args){
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        //int[][] board = {{-1,-1},{-1,3}};
        System.out.println("The least number of moves is: "+TheSnakesAndLadders.snakesAndLadders(board));
    }
}
