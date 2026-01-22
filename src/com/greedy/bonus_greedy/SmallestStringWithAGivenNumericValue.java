package com.greedy.bonus_greedy;

import java.util.Arrays;
//1663. Smallest String With A Given Numeric Value
public class SmallestStringWithAGivenNumericValue {
    public static String getSmallestString(int n, int k) {
        char[] result=new char[n];
        for(int position=n-1;position>=0;position--){
            int add=Math.min(k-position,26);
            result[position]=(char)(add+'a'-1);
            k-=add;
        }
        return new String(result);

 //----------------------My Solution-----------------------------------
        /*char[] arr=new char[26];
        for(int i=0;i<26;i++){
            arr[i]=(char) ('a'+i);
        }
        StringBuilder sb=new StringBuilder();
        for(int j= arr.length-1;j>=0;j--){
            while(k>=j+1 && k-j-1>=n-1){
                sb.append(arr[j]);
                k=k-(j+1);
                n=n-1;
            }
        }
        sb.reverse();
        return sb.toString();*/
    }
    public static void main(String[] args){
        //int n = 3, k = 27;
        int n = 5, k = 73;
        System.out.println("The lexicographically smallest string with length equal to n and numeric value equal to k: "+SmallestStringWithAGivenNumericValue.getSmallestString(n,k));
    }
}

