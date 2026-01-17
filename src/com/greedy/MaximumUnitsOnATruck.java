package com.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumUnitsOnATruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b) ->b[1]-a[1]);
        int unitCount=0;
        for(int[] boxType : boxTypes){
            int boxCount=Math.min(truckSize,boxType[0]);
            unitCount+=boxCount*boxType[1];
            truckSize-=boxCount;
            if(truckSize==0){
                break;
            }
        }
        return unitCount;

//---------------------My Solution-----------------------------------------
        /*PriorityQueue<int[]> boxTypesHeap=new PriorityQueue<>((a,b) ->b[1]-a[1]);
        for(int[] boxType : boxTypes){
            boxTypesHeap.add(new int[]{boxType[0],boxType[1]});
        }
        int ans=0;
        while(truckSize!=0 && !boxTypesHeap.isEmpty()){
            int[] currBoxes=boxTypesHeap.remove();
            if(currBoxes[0]<=truckSize){
                ans+=currBoxes[0]*currBoxes[1];
                truckSize-=currBoxes[0];
            }else{
                ans+=truckSize*currBoxes[1];
                truckSize=0;
            }
        }
        return ans;*/
    }
    public static void main(String[] args){
        //int[][] boxTypes = {{1,3},{2,2},{3,1}}; int truckSize = 4;
        //int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}}; int truckSize = 10;
        int[][] boxTypes = {{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}}; int truckSize = 35;
        System.out.println("The maximum total number of units that can be put on the truck is: "+MaximumUnitsOnATruck.maximumUnits(boxTypes,truckSize));
    }
}
