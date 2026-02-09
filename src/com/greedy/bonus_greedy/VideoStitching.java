package com.greedy.bonus_greedy;

import java.util.*;

public class VideoStitching {
    public static int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(a,b) ->{
            if(a[0]==b[0]){
               return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        System.out.println(Arrays.deepToString(clips));
        int currEndTime=0,maxEndTime=0,i=0,ans=0;
        while(currEndTime<time){
            while(i< clips.length && clips[i][0]<=currEndTime){
                maxEndTime=Math.max(maxEndTime,clips[i][1]);
                i++;
            }
            if(maxEndTime==currEndTime){
                return -1;
            }else{
                currEndTime=maxEndTime;
                ans++;
            }

            if(currEndTime>=time){
                return ans;
            }
        }
        return -1;








        /*PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b) ->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        for(int[] clip : clips){
            minHeap.add(new int[]{clip[0],clip[1]});
        }
        List<int[]> filteredClips=new ArrayList<>();
        int[] limit={0,time};
        int min=minHeap.peek()[0], max=minHeap.peek()[1];
        while(!minHeap.isEmpty()){
            int[] curr= minHeap.remove();
            if(curr[1]>limit[0]){
                limit[0]=curr[1];
                filteredClips.add(curr);
            }
        }
        for(int[] clip : filteredClips){
            System.out.println(Arrays.toString(clip));
        }
        Set<Integer> finalClips=new HashSet<>();
        finalClips.add(min);
        for(int i=1;i<filteredClips.size();i++){
            if(filteredClips.get(i)[0]<=max){
                finalClips.add(max);
            }else if(filteredClips.get(i)[0]<=filteredClips.get(i-1)[1]){
                finalClips.add(filteredClips.get(i)[0]);
            }else{
                return -1;
            }

            if(filteredClips.get(i)[1]>=time){
                return finalClips.size();
            }
        }
        return -1;*/
    }
    public static void main(String[] args){
        //int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}; int time = 10;
        //int[][] clips = {{0,4},{2,8}}; int time = 5;
        //int[][] clips = {{0,2},{4,8}}; int time = 5;
        int[][] clips = {{0,1},{1,2}}; int time = 5;
        //int[][] clips = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}}; int time = 9;
        System.out.println("The minimum number of clips: "+VideoStitching.videoStitching(clips,time));
    }
}
