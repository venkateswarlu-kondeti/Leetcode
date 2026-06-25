package com.binarySearch;

import java.util.Stack;
//1631. Path With Minimum Effort
public class PathWithMinimumEffort {
    public static int m;
    public static int n;
    public static int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
    public static int minimumEffortPath(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        int left=0;
        int right=0;
        for(int[] row : heights){
            for(int num : row){
                right=Math.max(right,num);
            }
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(mid,heights)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static boolean check(int effort, int[][] heights){
        boolean[][] seen=new boolean[m][n];
        Stack<Pair> stack=new Stack<>();
        seen[0][0]=true;
        stack.push(new Pair(0,0));
        while(!stack.empty()){
            Pair pair=stack.pop();
            int row=pair.row, col=pair.col;
            if(row==m-1 && col==n-1){
                return true;
            }
            for(int[] direction : directions){
                int nextRow=row+direction[0],nextCol=col+direction[1];
                if(valid(nextRow,nextCol) && !seen[nextRow][nextCol]){
                    if(Math.abs(heights[row][col]-heights[nextRow][nextCol])<=effort){
                        seen[nextRow][nextCol]=true;
                        stack.push(new Pair(nextRow,nextCol));
                    }
                }
            }
        }
        return false;
    }
    public static boolean valid(int row,int col){
        return row<m && col<n && row>=0 && col>=0;
    }

    public static void main(String[] args){
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println("The minimum effort required to travel from the top-left cell to the bottom-right cell is: "+PathWithMinimumEffort.minimumEffortPath(heights));
    }
}
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
