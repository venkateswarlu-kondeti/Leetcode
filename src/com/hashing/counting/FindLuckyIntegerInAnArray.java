package com.hashing.counting;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr){
        Map<Integer,Integer> dic=new HashMap<>();
        for(int num : arr){
            dic.put(num, dic.getOrDefault(num,0)+1);
        }
        System.out.println(dic);
        int ans=0;
        for(Map.Entry<Integer,Integer> e : dic.entrySet()){
            if(e.getKey()==e.getValue()){
                ans=Math.max(ans,e.getKey());
            }
        }
        return ans==0? -1 : ans;
    }
    public static void main(String[] args){
        FindLuckyIntegerInAnArray l=new FindLuckyIntegerInAnArray();
        //int[] arr={2,2,3,4};
        //int[] arr={1,2,2,3,3,3};
        int[] arr={2,2,2,3,3};
        System.out.println("The lucky integer in an array is: "+l.findLucky(arr));
    }
}
