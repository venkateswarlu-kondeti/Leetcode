package com.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//2260. Minimum Consecutive Cards to Pick Up
public class MinimumConsecutiveCardsToPickUp {
    public int minimumCardPickup(int[] cards){
        Map<Integer,Integer> dic=new HashMap<>();
        int ans=Integer.MAX_VALUE;
         for ( int i=0;i<cards.length;i++){
             int num=cards[i];
             if(dic.containsKey(num)){
                 ans=Math.min(ans,i-dic.get(num)+1);
             }
             dic.put(num,i);
         }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
        /*Map<Integer, List<Integer>> dic=new HashMap<>();
        for(int i=0;i<cards.length;i++){
            if(!dic.containsKey(cards[i])){
                dic.put(cards[i],new ArrayList<>());
            }
            dic.get(cards[i]).add(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int key : dic.keySet()){
            List<Integer> lst=dic.get(key);
            for(int i=0;i<lst.size()-1;i++){
                ans=Math.min(ans,lst.get(i+1)-lst.get(i)+1);
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;*/
    }
    public static void main (String[] args){
        MinimumConsecutiveCardsToPickUp mp=new MinimumConsecutiveCardsToPickUp();
        int[] cards={1, 2, 6, 2, 1};
        System.out.println("The minimum consecutive cards to pickup is: "+mp.minimumCardPickup(cards));
    }
}
