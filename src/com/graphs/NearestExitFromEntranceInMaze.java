package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public static int m;
    public static int n;
    public static int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public static int nearestExit(char[][] maze, int[] entrance){
        Queue<State> queue=new LinkedList<>();
        int ans=Integer.MAX_VALUE;
        m= maze.length;
        n=maze[0].length;
        boolean[][] seen=new boolean[m][n];
        seen[entrance[0]][entrance[1]]=true;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(maze[row][col]=='+'){
                    seen[row][col]=true;
                }
            }
        }
        queue.add(new State(entrance[0],entrance[1],0));
        while(!queue.isEmpty()){
            State state=queue.remove();
            int row=state.row, col=state.col, steps=state.steps;
            for(int[] direction : directions){
                int nextRow=row+direction[0];
                int nextCol=col+direction[1];
                if(valid(nextRow,nextCol)&& !seen[nextRow][nextCol]){
                    seen[nextRow][nextCol]=true;
                    queue.add(new State(nextRow,nextCol,steps+1));
                } else if (!valid(nextRow,nextCol) && steps>=1) {
                    ans=Math.min(ans,steps);
                }
            }
        }
        return ans==Integer.MAX_VALUE? -1: ans;
    }
    public static boolean valid(int row, int col){
        return 0<=row && row<m && 0<=col && col<n;
    }
    public static void main(String[] args){
        char[][] maze={{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance={1,2};

        /*char[][] maze={{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        int[] entrance={1,0};*/

        /*char[][] maze={{'.','+'}};
        int[] entrance={0,0};*/
        System.out.println("The nearest exit from entrance in the maze is: "+NearestExitFromEntranceInMaze.nearestExit(maze,entrance));
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
