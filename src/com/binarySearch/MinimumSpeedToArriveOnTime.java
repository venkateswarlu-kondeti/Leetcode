package com.binarySearch;
//1870. Minimum Speed to Arrive on Time
public class MinimumSpeedToArriveOnTime {
    public static double limit;
    public static int minSpeedOnTime(int[] dist, double hour) {
        if(dist.length>Math.ceil(hour)){
            return -1;
        }
        limit=hour;
        int left=1;
        int right=(int)Math.pow(10,7);
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(mid,dist)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static boolean check(int k,int[] dist){
        double t=0;
        for(double d : dist){
            t=Math.ceil(t);
            t+=d/k;
        }
        return t<=limit;
    }

    public static void main(String[] args){
        int[] dist = {1,3,2};
        int hour = 6;
        System.out.println("The minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time: "+MinimumSpeedToArriveOnTime.minSpeedOnTime(dist,hour));
    }
}
