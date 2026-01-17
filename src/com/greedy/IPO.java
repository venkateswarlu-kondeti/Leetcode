package com.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//502. IPO
public class IPO {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int[][] projects=new int[n][2];
        for(int i=0;i<n;i++){
            projects[i]=new int[]{capital[i],profits[i]};
        }
        Arrays.sort(projects,(a,b) ->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> maxProfitHeap=new PriorityQueue<>(Comparator.reverseOrder());
        int i=0;
        for(int j=0;j<k;j++){
            while(i<n && projects[i][0]<=w){
                maxProfitHeap.add(projects[i][1]);
                i++;
            }
            if(maxProfitHeap.isEmpty()){
                return w;
            }
            w+=maxProfitHeap.remove();
        }
        return w;
    }
    public static void main(String[] args){
        int k = 2; int w = 0; int[] profits = {1,2,3}; int[] capital = {0,1,1};
        System.out.println("The final maximized capital is: "+IPO.findMaximizedCapital(k,w,profits,capital));
    }
}
