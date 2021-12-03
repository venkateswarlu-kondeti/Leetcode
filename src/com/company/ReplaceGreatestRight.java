package com.company;

import java.util.Arrays;

public class ReplaceGreatestRight {
    public int[] replaceElements(int[] arr) {
        int H=0;
        for(int i=0;i< arr.length;i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]>H)
                {
                    H=arr[j];
                }
            }
            if(i!= arr.length-1) {
                arr[i] = H;
                H = 0;
            }else
            {
                arr[i] = -1;
            }
        }
        return arr;
    }

    public static void main(String[] args)
    {
        ReplaceGreatestRight rgr=new ReplaceGreatestRight();
        int[] arr={17,18,5,4,6,1};
        System.out.println(Arrays.toString(rgr.replaceElements(arr)));
    }
}
