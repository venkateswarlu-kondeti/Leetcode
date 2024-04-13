package com.company;

import java.util.Arrays;

public class RotateImageArray {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int val;
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                val = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = val;
            }
        }
        System.out.println("Final: " + Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}
                         ,{4, 5, 6}
                         ,{7, 8, 9}};
//        int[][] matrix= {{5,1,9,11}
//                        ,{2,4,8,10}
//                        ,{13,3,6,7}
//                        ,{15,14,12,16}};
//        int[][] matrix = {{1, 2}
//                         ,{3, 4}};
        RotateImageArray rm = new RotateImageArray();
        rm.rotate(matrix);
    }
}
