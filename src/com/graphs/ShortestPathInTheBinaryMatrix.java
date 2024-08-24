package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

//1091. Shortest Path in Binary Matrix
public class ShortestPathInTheBinaryMatrix {
    public static int n;
    public static int[][] directions=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static int shortestPathBinaryMatrix(int[][] grid){
        if(grid[0][0]==1){
            return -1;
        }
        n= grid.length;;
        boolean[][] seen=new boolean[n][n];
        seen[0][0]=true;
        Queue<State> queue=new LinkedList<>();
        queue.add(new State(0,0,1));
        while(!queue.isEmpty()){
            State state=queue.remove();
            int row=state.row, col=state.col, steps=state.steps;
            if(row==n-1 && col==n-1){
                return steps;
            }
            for(int[] direction : directions){
                int nextRow=row+direction[0];
                int nextCol=col+direction[1];
                if(valid(nextRow,nextCol,grid) && !seen[nextRow][nextCol]){
                    seen[nextRow][nextCol]=true;
                    queue.add(new State(nextRow,nextCol,steps+1));
                }
            }
        }
        return -1;
    }
    public static boolean valid(int row, int col, int[][] grid){
        return 0<=row && row<n && 0<=col && col<n && grid[row][col]==0;
    }
    public static void main(String[] args){
        int[][] grid={{0,0,1,1,1,1},{0,1,0,1,1,1},{0,1,1,0,1,1},{0,0,0,0,0,1},{1,1,1,1,0,0},{1,1,1,1,1,0}};
        System.out.println("The shortest path in the Binary Matrix is: "+ShortestPathInTheBinaryMatrix.shortestPathBinaryMatrix(grid));
    }
    public static class State{
        int row;
        int col;
        int steps;
        State(int row, int col, int steps){
            this.row=row;
            this.col=col;
            this.steps=steps;
        }
    }
}
