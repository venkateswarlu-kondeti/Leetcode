package com.graphs.bonus_graphs;

import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//994. Rotting Oranges
public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        int[][] directions={{1,0},{0,1},{-1,0},{0,-1}};
        int minutes=0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<State> queue=new LinkedList<>();
        Boolean[][] seen=new Boolean[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1 || grid[row][col]==2){
                    seen[row][col]=false;
                }
            }
        }
        System.out.println(Arrays.deepToString(seen));
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==2){
                    seen[row][col]=true;
                    queue.add(new State(row,col));
                }
            }
        }
        while(!queue.isEmpty()){
            int length=queue.size();
            for(int i=0;i<length;i++){
                State state=queue.remove();
                int row=state.row;
                int col=state.col;
                for(int[] direction : directions){
                    int nextRow=row+direction[0];
                    int nextCol=col+direction[1];
                    if(valid(nextRow,nextCol,m,n,grid) && !seen[nextRow][nextCol]){
                        seen[nextRow][nextCol]=true;
                        queue.add(new State(nextRow,nextCol));
                    }
                }
            }
            if(!queue.isEmpty())
                minutes++;
        }
        System.out.println(Arrays.deepToString(seen));
        for(Boolean[] s : seen){
            if(Arrays.asList(s).contains(false)){
                return -1;
            }
        }
        return minutes;
    }
    public static Boolean valid(int row,int col,int m,int n, int[][] grid){
        return 0<=row && row<m && 0<=col && col<n && grid[row][col]==1;
    }
    public static class State{
        int row;
        int col;
        State(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public static void main(String[] args){
        //int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        //int[][] grid={{2,1,1},{0,1,1},{1,0,1}};
        //int[][] grid={{0,2}};
        int[][] grid={{1,2}};
        System.out.println("Minimum number of minutes that must elapse until no cell has a fresh orange is: "+RottingOranges.orangesRotting(grid));
    }
}
