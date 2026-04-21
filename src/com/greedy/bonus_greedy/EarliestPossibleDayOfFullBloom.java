package com.greedy.bonus_greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
//2136. Earliest Possible Day of Full Bloom
public class EarliestPossibleDayOfFullBloom {
    public static int earliestFullBloom(int[] plantTime, int[] growTime) {
        int m= plantTime.length;
        int[][] plantAndGrowTime=new int[m][2];
        for(int row=0;row<m;row++){
            plantAndGrowTime[row][0]=plantTime[row];
            plantAndGrowTime[row][1]=growTime[row];
        }
        Arrays.sort(plantAndGrowTime,(a,b)->{
            if(b[1]==a[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[1],a[1]);
        });
        int currPlantTime=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            currPlantTime+=plantAndGrowTime[i][0];
            int currBloomTime=currPlantTime+plantAndGrowTime[i][1];
            ans=Math.max(ans,currBloomTime);
        }
        return ans;
  //------------------------Other Solution------------------------------------------------
        /*PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->{
            if(b[1]==a[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(b[1],a[1]);
        });
        for(int i=0;i<plantTime.length;i++){
            queue.add(new int[]{plantTime[i],growTime[i]});
        }
        int currPlantTime=0;
        int ans=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int[] currSet= queue.remove();
            currPlantTime+=currSet[0];
            int currBloomTime=currPlantTime+currSet[1];
            ans=Math.max(ans,currBloomTime);
        }
        return ans;*/
    }
    public static void main(String[] args){
        //int[] plantTime = {1,4,3}, growTime = {2,3,1};
        //int[] plantTime = {1,2,3,2}, growTime = {2,1,2,1};
        //int[] plantTime = {1}, growTime = {1};
        int[] plantTime={3,11,29,4,4,26,26,12,13,10,30,19,27,2,10}, growTime={10,13,22,17,18,15,21,11,24,14,18,23,1,30,6};
        System.out.println("The earliest possible day where all seeds are blooming: "+EarliestPossibleDayOfFullBloom.earliestFullBloom(plantTime,growTime));
    }
}
