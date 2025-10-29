package com.graphs.bonus_graphs;

public class IslandPerimeter {
    public static int m;
    public static int n;
    public static int islandPerimeter(int[][] grid) {
        m= grid.length;
        n=grid[0].length;
        int ans=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1){
                    ans+=valid(grid,row+0,col+1) ? 0 : 1;
                    ans+=valid(grid,row+1,col+0) ? 0 : 1;
                    ans+=valid(grid,row+0,col-1) ? 0 : 1;
                    ans+=valid(grid,row-1,col+0) ? 0 : 1;
                }
            }
        }
        return ans;
    }
    public static boolean valid(int[][] grid,int row, int col){
        return 0<=row && row<m && 0<=col && col<n && grid[row][col]==1;
    }
    public static void main(String[] args){
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println("The island perimeter is: "+islandPerimeter(grid));
    }
}
