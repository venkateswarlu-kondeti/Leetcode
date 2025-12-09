package com.graphs;

import java.util.LinkedList;
import java.util.Queue;
//1293. Shortest Path in a Grid with Obstacles Elimination
public class ShortestPathGridObstacles {
    public static int m;
    public static int n;
    public static int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public static int shortestPath(int[][] grid, int k){
        m=grid.length;
        n=grid[0].length;
        boolean[][][] seen=new boolean[m][n][k+1];
        Queue<State> queue=new LinkedList<>();
        queue.add(new State(0,0,k,0));
        seen[0][0][k]=true;
        while(!queue.isEmpty()){
            State state=queue.remove();
            int row=state.row;
            int col=state.col;
            int steps=state.steps;
            int remain=state.remain;
            if(row==m-1 && col==n-1){
                return steps;
            }
            for(int[] direction : directions){
                int nextRow=row+direction[0];
                int nextCol=col+direction[1];
                if(valid(nextRow,nextCol)){
                    if(grid[nextRow][nextCol]==0){
                        if(!seen[nextRow][nextCol][remain]){
                            seen[nextRow][nextCol][remain]=true;
                            queue.add(new State(nextRow,nextCol,remain,steps+1));
                        }
                    }else if(remain>0 && !seen[nextRow][nextCol][remain-1]){
                        seen[nextRow][nextCol][remain-1]=true;
                        queue.add(new State(nextRow,nextCol,remain-1,steps+1));
                    }
                }
            }
        }
        return -1;
    }
    public static boolean valid(int row, int col){
        return 0<=row && row<m && 0<=col && col<n;
    }
    public static void main(String[] args){
        int[][] grid={{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int k=1;
        System.out.println("The shortest path in a grid with obstacles elimination is: "+ShortestPathGridObstacles.shortestPath(grid,k));
    }
    public static class State {
        int row;
        int col;
        int remain;
        int steps;
        State(int row, int col, int remain, int steps){
            this.row=row;
            this.col=col;
            this.remain=remain;
            this.steps=steps;
        }
    }
}
