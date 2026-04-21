package com.greedy.bonus_greedy;

import java.util.Arrays;
//1326. Minimum Number of Taps to Open to Water a Garden
public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public static int minTaps(int n, int[] ranges) {
        int m= ranges.length;;
        int[][] tapRange=new int[m][2];
        for(int row=0;row<m;row++){
            tapRange[row][0]=Math.max(0,row-ranges[row]);
            tapRange[row][1]=Math.min(n,row+ranges[row]);
        }
        System.out.println(Arrays.deepToString(tapRange));
        int[] newTapRange =new int[m];
        for(int[] tap : tapRange){
            newTapRange[tap[0]]=Math.max(newTapRange[tap[0]],tap[1]);
        }
        System.out.println(Arrays.toString(newTapRange));
        int tapCount=0,currTap=0,nextTap=0;
        for(int i=0;i<tapRange.length;i++){
            if(i>nextTap){
                return -1;
            }
            if(i>currTap){
                tapCount++;
                currTap=nextTap;
            }
            nextTap=Math.max(nextTap, newTapRange[i]);
        }
        return tapCount;

    }
    public static void main(String[] args){
        //int n=5;
        //int[] ranges={3,4,1,1,0,0};
        //int n=3;
        //int[] ranges={0,0,0,0};
        //int n=7;
        //int[] ranges={1,2,1,0,2,1,0,1};
        //int n=8;
        //int[] ranges={4,0,0,0,4,0,0,0,4};
        //int n=9;
        //int[] ranges={0,5,0,3,3,3,1,4,0,4};
        int n=17;
        int[] ranges={0,3,3,2,2,4,2,1,5,1,0,1,2,3,0,3,1,1};
        System.out.println("The minimum number of taps that should be open to water the whole garden: "+MinimumNumberOfTapsToOpenToWaterAGarden.minTaps(n,ranges));
    }
}
