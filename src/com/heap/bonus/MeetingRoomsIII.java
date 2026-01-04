package com.heap.bonus;

import java.util.*;

public class MeetingRoomsIII {
    public static int mostBooked(int n, int[][] meetings) {
        int[] meetingCount =new int[n];
        PriorityQueue<Integer> unusedRooms=new PriorityQueue<>();
        PriorityQueue<long[]> usedRooms=new PriorityQueue<>((a,b) -> a[0]!=b[0]? Long.compare(a[0],b[0]) : Long.compare(a[1],b[1]));
        for(int i=0;i<n;i++){
            unusedRooms.offer(i);
        }
        Arrays.sort(meetings,(a,b) ->a[0]!=b[0]? a[0]-b[0] : a[1]-b[1]);
        for(int[] meeting : meetings){
            int start=meeting[0],end=meeting[1];
            while(!usedRooms.isEmpty() && usedRooms.peek()[0]<=start){
                int room=(int)usedRooms.poll()[1];
                unusedRooms.offer(room);
            }
            if(!unusedRooms.isEmpty()){
                int room=unusedRooms.poll();
                usedRooms.offer(new long[]{end,room});
                meetingCount[room]++;
            }else{
                long roomAvailabilityTime=usedRooms.peek()[0];
                int room=(int)usedRooms.poll()[1];
                usedRooms.offer(new long[]{roomAvailabilityTime+end-start,room});
                meetingCount[room]++;
            }
        }

        int maxMeetingCount=0,maxMeetingCountRoom=0;
        for(int i=0;i<n;i++){
            if(meetingCount[i]>maxMeetingCount){
                maxMeetingCount= meetingCount[i];
                maxMeetingCountRoom=i;
            }
        }
        return maxMeetingCountRoom;

        //-----------------------My Solution------------------------------------------
        /*Map<Integer,Integer> roomToCountMap=new HashMap<>();
        PriorityQueue<Integer> roomHeapMin=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            roomHeapMin.add(i);
        }
        PriorityQueue<long[]> meetingEndTimeToRoomHeapMin=new PriorityQueue<>((er1,er2) ->{
            if(er1[0]==er2[0]){
                return Long.compare(er1[1],er2[1]);
            }
            return Long.compare(er1[0],er2[0]);
        });
        Arrays.sort(meetings, (a,b) -> a[0]!=b[0] ? Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        System.out.println(Arrays.deepToString(meetings));
        for(int[] meeting : meetings){
            long start=meeting[0], end=meeting[1];
            while(!meetingEndTimeToRoomHeapMin.isEmpty() && meetingEndTimeToRoomHeapMin.peek()[0]<=start){
                long room=meetingEndTimeToRoomHeapMin.remove()[1];
                roomHeapMin.add((int)room);
            }
            if(!roomHeapMin.isEmpty()){
                int room=roomHeapMin.remove();
                meetingEndTimeToRoomHeapMin.add(new long[]{end,room});
                roomToCountMap.put(room,roomToCountMap.getOrDefault(room,0)+1);
            }else{
                long roomAvailableTime=meetingEndTimeToRoomHeapMin.peek()[0];
                long room=meetingEndTimeToRoomHeapMin.remove()[1];
                meetingEndTimeToRoomHeapMin.add(new long[]{roomAvailableTime+end-start,room});
                roomToCountMap.put((int)room,roomToCountMap.getOrDefault((int)room,0)+1);
            }
        }
        PriorityQueue<Integer> roomHeapMax=new PriorityQueue<>((r1,r2) ->{
            if(roomToCountMap.get(r1)==roomToCountMap.get(r2)){
                return r1.compareTo(r2);
            }
            return roomToCountMap.get(r2).compareTo(roomToCountMap.get(r1));
        });
        for(int rm : roomToCountMap.keySet()){
            roomHeapMax.add(rm);
        }
        return roomHeapMax.remove();*/
    }
    public static void main(String[] args){
        //int n = 2; int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        //int n = 3; int[][] meetings = {{1,20},{2,10},{3,5},{4,9},{6,8}};
        int n = 4; int[][] meetings = {{18,19},{3,12},{17,19},{2,13},{7,10}};
        System.out.println("The number of the room that held the most meetings: "+MeetingRoomsIII.mostBooked(n,meetings));
    }
}
