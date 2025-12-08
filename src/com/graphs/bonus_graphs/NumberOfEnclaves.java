package com.graphs.bonus_graphs;

import java.util.LinkedList;
import java.util.Queue;
//1020. Number of Enclaves
public class NumberOfEnclaves {
    public static int m;
    public static int n;
    public static boolean[][] seen;
    public static int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
    public static int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        seen=new boolean[m][n];
        int ans=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1 && !seen[row][col]){
                    seen[row][col]=true;
                    ans+=getIsland(row,col,1, grid);
                }
            }
        }
        return ans;
    }
    public static int getIsland(int row,int col,int step, int[][] grid){
        Queue<State> queue=new LinkedList<>();
        queue.add(new State(row,col));
        int steps=step;
        boolean offBoundary=false;
        while(!queue.isEmpty()){
            State state=queue.remove();
            int currentRow=state.row, currentCol=state.col;
            for(int[] direction : directions){
                int nextRow=currentRow+direction[0], nextCol=currentCol+direction[1];
                if(valid(nextRow,nextCol) && grid[nextRow][nextCol]==1 && !seen[nextRow][nextCol]){
                    seen[nextRow][nextCol]=true;
                    steps++;
                    queue.add(new State(nextRow,nextCol));
                }
                if(!valid(nextRow,nextCol)){
                    offBoundary=true;
                }
            }
        }
        return offBoundary ? 0 :steps;
    }
    public static boolean valid(int row, int col){
        return 0<=row && row<m && 0<=col && col<n;
    }
    public static void main(String[] args){
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        //int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        //int [][] grid ={{0,1,1,0,0,0,0,1,1,0,0,0},{1,0,1,1,1,0,1,0,1,1,1,0},{1,1,0,1,0,0,1,1,0,1,1,1},{1,0,0,1,1,0,1,0,1,0,1,0},{1,0,0,0,0,1,0,0,1,1,0,1},{1,1,1,0,0,0,1,0,0,1,1,1},{1,1,1,0,0,0,0,1,0,1,0,1},{0,1,1,1,1,0,0,1,1,0,0,0},{0,1,0,1,0,1,0,1,0,0,0,1},{0,0,1,0,1,1,0,0,0,1,1,1}};
        //int[][] grid ={{0,0,0,1,1,1,0,1,1,1,1,1,0,0,0},{1,1,1,1,0,0,0,1,1,0,0,0,1,1,1},{1,1,1,0,0,1,0,1,1,1,0,0,0,1,1},{1,1,0,1,0,1,1,0,0,0,1,1,0,1,0},{1,1,1,1,0,0,0,1,1,1,0,0,0,1,1},{1,0,1,1,0,0,1,1,1,1,1,1,0,0,0},{0,1,0,0,1,1,1,1,0,0,1,1,1,0,0},{0,0,1,0,0,0,0,1,1,0,0,1,0,0,0},{1,0,1,0,0,1,0,0,0,0,0,0,1,0,1},{1,1,1,0,1,0,1,0,1,1,1,0,0,1,0}};
        System.out.println("The number of enclaves are: "+numEnclaves(grid));
    }
    public static class State{
        int row;
        int col;
        public State(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
}
