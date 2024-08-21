package com.graphs;

import java.util.Stack;

public class NumberOfIslandsIteratively {
    public static int m;
    public static int n;
    public static boolean[][] seen;
    public static int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public static int numIslandsIterative(char[][] grid){
        m=grid.length;
        n=grid[0].length;
        seen=new boolean[m][n];
        int ans=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]=='1' && !seen[row][col]){
                    ans++;
                    seen[row][col]=true;
                    calculateIslands(row,col,grid);
                }
            }
        }
        return ans;
    }
    public static boolean valid(int row, int col, char[][] grid){
        return 0<=row && row<m && 0<=col && col<n && grid[row][col]=='1';
    }
    public static void calculateIslands(int startRow, int startCol, char[][] grid){
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
                }
            }
        }
    }
    public static void main(String[] args){
        char[][] grid={{'1','1','0','0','0','1'},{'0','1','0','0','0','0'},{'0','1','1','0','1','1'},{'0','0','0','0','0','1'},{'1','1','1','1','0','1'},{'1','1','1','1','0','1'}};
        System.out.println("The number of Islands is: "+NumberOfIslandsIteratively.numIslandsIterative(grid));
    }
}
