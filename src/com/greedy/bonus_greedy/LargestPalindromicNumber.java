package com.greedy.bonus_greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//2384. Largest Palindromic Number
public class LargestPalindromicNumber {
    public static String largestPalindromic(String num) {
        Map<Integer,Integer> counts=new HashMap<>();
        for(int i=0; i<num.length();i++){
            int currValue= Integer.valueOf(String.valueOf(num.charAt(i)));
            counts.put(currValue,counts.getOrDefault(currValue,0)+1);
        }
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b) ->  b[0]-a[0]);
        int maxValue=Integer.MIN_VALUE;
        for(int numVal : counts.keySet()){
            maxHeap.add(new int[]{numVal,counts.get(numVal),counts.get(numVal)%2});
        }
        StringBuilder sb=new StringBuilder();
        while (!maxHeap.isEmpty()){
            int[] currArray=maxHeap.remove();
            int currValue=currArray[0], currCount=currArray[1], currState=currArray[2];
            if(currState==1){
                maxValue=Math.max(maxValue,currValue);
                currCount-=1;
            }
            currCount/=2;
            while (currCount>0){
                sb.append(currValue);
                currCount--;
            }
        }
        if(sb.toString()=="" || Double.valueOf(sb.toString())==0){
            return maxValue!=Integer.MIN_VALUE ? String.valueOf(maxValue): String.valueOf(0);
        }
        String str=sb.toString();
        String revStr=sb.reverse().toString();
        return maxValue!=Integer.MIN_VALUE ? str+maxValue+revStr : str+revStr;
    }
    public static void main(String[] args){
        //String num = "444947137";
        //String num = "00000007";
        //String num = "00001105";
        //String num="00009";
        //String num="5736732";
        //String num="00000";
        //String num = "00011";
        //String num = "97231404236749078329522372611037933";
        //String num = "0123456789";
        //String num = "40708519380447979360431739409470518694192098870989646268669201803";
        String num = "111";
        System.out.println("The largest palindromic integer: "+LargestPalindromicNumber.largestPalindromic(num));
    }
}
