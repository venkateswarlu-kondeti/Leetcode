package com.company;

import java.util.Arrays;

public class HeightCheckerArray {
    public int heightChecker(int[] heights) {
        int indices=0;
        int[] expected=new int[heights.length];
        for(int i=0;i<heights.length;i++)
        {
            expected[i]=heights[i];
        }
        Arrays.sort(expected);
        System.out.println(Arrays.toString(expected));
        for(int j=0;j<heights.length;j++)
        if(heights[j]!=expected[j])
        {
            indices++;
        }
        return indices;
    }
    public static void main(String[] args)
    {
        HeightCheckerArray hc=new HeightCheckerArray();
        int[] heights={1,2,3,4,5};
        System.out.println(hc.heightChecker(heights));
    }
}
