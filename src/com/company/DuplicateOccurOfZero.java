package com.company;

import java.util.Arrays;

public class DuplicateOccurOfZero {

    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                i++;
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                if(arr.length-1>=i) {
                    arr[i] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        DuplicateOccurOfZero dz = new DuplicateOccurOfZero();
        int[] arry = {1,5,2,0,6,8,0,6,0};
        dz.duplicateZeros(arry);
    }
}

