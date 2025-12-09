package com.graphs;
//695. Max Area of Island
public class MaxAreaOfIsland {
    int[][] grid;
    boolean[][] seen;
    public int maxAreaOfIsland(int[][] grid){
        this.grid=grid;
        seen=new boolean[grid.length][grid[0].length];
        int ans=0;
        for(int r=0;r< grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                ans=Math.max(ans,area(r,c));
            }
        }
        return ans;
    }
    public int area(int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>= grid[0].length || seen[r][c] || grid[r][c]==0){
            return 0;
        }
        seen[r][c]=true;
        return (1+area(r+1,c)+area(r-1,c)+area(r,c+1)+area(r,c-1));
    }
    //-----------------My Solution---------------------------------

    /*public static int m;
    public static int n;
    public static int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public static boolean[][] seen;
    public static int maxAreaOfIsland(int[][] grid){
        m= grid.length;
        n=grid[0].length;
        int ans=0;
        int area=0;
        seen=new boolean[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1 && !seen[row][col]){
                    area++;
                    seen[row][col]=true;
                    int a=dfs(row,col,grid,area);
                    ans=Math.max(ans,a);
                }
                area=0;
            }
        }
        return ans;
    }
    public static boolean valid(int row, int col, int[][] grid){
        return 0<=row && row<m && 0<=col && col<n && grid[row][col]==1;
    }
    public static int dfs(int row, int col, int[][] grid, int area){
        for(int[] direction : directions){
            int nextRow=row+direction[0];
            int nextCol=col+direction[1];
            if(valid(nextRow,nextCol,grid) && !seen[nextRow][nextCol]){
                area++;
                seen[nextRow][nextCol]=true;
                area=dfs(nextRow,nextCol,grid, area);
            }
        }
        return area;
    }*/
    public static void main(String[] args){
        /*int[][] grid={{0,0,0,0,0,0,0,0}};
        System.out.println("The Max area of the island is: "+MaxAreaOfIsland.maxAreaOfIsland(grid));*/
        /*int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println("The Max area of the island is: "+MaxAreaOfIsland.maxAreaOfIsland(grid));*/
        int[][] grid={{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxAreaOfIsland ma=new MaxAreaOfIsland();
        System.out.println("The Max area of the island is: "+ma.maxAreaOfIsland(grid));
    }
}
