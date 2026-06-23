package com.binarySearch;
//74. Search a 2D Matrix
public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int left=0;
        int right=m*n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int row=mid / n;
            int col=mid % n;
            int num=matrix[row][col];

            if(num==target){
                return true;
            }

            if(num>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
     return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}}; int target = 3;
        System.out.println("The search of a 2D matrix is: "+SearchA2DMatrix.searchMatrix(matrix,target));
    }
}
