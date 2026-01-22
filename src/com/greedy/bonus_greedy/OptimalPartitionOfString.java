package com.greedy.bonus_greedy;

import java.util.Arrays;
//2405. Optimal Partition of String
public class OptimalPartitionOfString {
    public static int partitionString(String s) {
        int[] lastSeen=new int[26];
        Arrays.fill(lastSeen,-1);
        int count=1, substringStart=0;

        for(int i=0;i<s.length();i++){
            if(lastSeen[s.charAt(i) - 'a'] >= substringStart){
                count++;
                substringStart=i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }
        return count;

//-------------------My Solution-----------------------
        /*StringBuilder sb =new StringBuilder();
        int ans=1;
        for(char c : s.toCharArray()){
            if(!sb.toString().contains(String.valueOf(c))){
                sb.append(c);
                continue;
            }
            sb.setLength(0);
            sb.append(c);
            ans++;
        }
        return ans;*/
    }
    public static void main(String[] args){
        String s = "abacaba";
        System.out.println("The minimum number of substrings in such a partition: "+OptimalPartitionOfString.partitionString(s));
    }
}
