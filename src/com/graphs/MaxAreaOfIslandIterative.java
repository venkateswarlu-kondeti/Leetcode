package com.graphs;

import java.util.Stack;

public class MaxAreaOfIslandIterative {
    public static int m;
    public static int n;
    public static boolean[][] seen;
    public static int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public static int maxAreaOfIslandIterative(int[][] grid){
        m= grid.length;
        n=grid[0].length;
        seen=new boolean[m][n];
        int area=0;
        int ans=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1 && !seen[row][col]){
                    area++;
                    seen[row][col]=true;
                    int a=calculateArea(row,col,grid,area);
                    ans=Math.max(ans, a);
                }
                area=0;
            }
        }
        return ans;
    }
    public static boolean valid(int row, int col, int[][] grid){
        return 0<=row && row<m && 0<=col && col<n && grid[row][col]==1;
    }
    public static int calculateArea(int startRow, int startCol, int[][] grid, int area){
        Stack<Integer> rowStack=new Stack<>();
        Stack<Integer> colStack=new Stack<>();
        rowStack.push(startRow);
        colStack.push(startCol);
        while(!rowStack.empty()){
            int row=rowStack.pop();
            int col=colStack.pop();
            for(int[] direction : directions){
                int nextRow=row+direction[0];
                int nextCol=col+direction[1];
                if(valid(nextRow,nextCol,grid) && !seen[nextRow][nextCol]){
                    seen[nextRow][nextCol]=true;
                    rowStack.push(nextRow);
                    colStack.push(nextCol);
                    area++;
                }
            }
        }
        return area;
    }
    public static void main(String[] args){
        int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println("The Max area of the island is: "+MaxAreaOfIslandIterative.maxAreaOfIslandIterative(grid));
    }
}
