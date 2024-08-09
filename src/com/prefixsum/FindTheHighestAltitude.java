package com.prefixsum;

import java.util.Arrays;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain){
        int n=gain.length;
        int ans=0;
        int[] prefix=new int[n+1];
        prefix[0]=0;
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+gain[i];
        }
        System.out.println(Arrays.toString(prefix));
        for(int p : prefix){
            ans=Math.max(ans,p);
        }
        return ans;
    }

    public static void main(String[] args){
        FindTheHighestAltitude fh=new FindTheHighestAltitude();
        //int[] g={-5,1,5,0,-7};
        int[] g={-4,-3,-2,-1,4,3,2};
        System.out.println("The highest altitude is: "+fh.largestAltitude(g));
    }
}
