package com.hashing;

import java.util.*;
//2225. Find Players With Zero or One Losses
public class ZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches){
        Map<Integer,Integer> loser=new HashMap<>();
        Set<Integer> winnerAndLoser=new HashSet<>();
        List<List<Integer>> answer=Arrays.asList(new ArrayList<>(),new ArrayList<>());
        for(int[] arr : matches){
            winnerAndLoser.add(arr[0]);
            winnerAndLoser.add(arr[1]);
            loser.put(arr[1],loser.getOrDefault(arr[1],0)+1);
        }
        for(int wl : winnerAndLoser){
            if(!loser.containsKey(wl)){
                answer.get(0).add(wl);
            }else if(loser.get(wl)==1){
                answer.get(1).add(wl);
            }
        }
        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));
        return answer;

        //This is my Solution-----------------------------------
        /*Map<Integer,Integer> loser=new HashMap<>();
        Set<Integer> winner=new HashSet<>();
        List<List<Integer>> answer=Arrays.asList(new ArrayList<>(),new ArrayList<>());
        for(int[] arr : matches){
            winner.add(arr[0]);
            loser.put(arr[1],loser.getOrDefault(arr[1],0)+1);
        }
        System.out.println(loser);
        System.out.println(winner);
        for(int l : loser.keySet()){
            if(loser.get(l)==1){
                answer.get(1).add(l);
            }
        }
        for(int w : winner){
            if(!loser.containsKey(w)){
                answer.get(0).add(w);
            }
        }
        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));
        return answer;*/
    }

    public static void main(String[] args){
        ZeroOrOneLosses z=new ZeroOrOneLosses();
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        //int[][] matches = {{2,3},{1,3},{5,4},{6,4}};
        System.out.println("Players With Zero or One Losses is: "+z.findWinners(matches));
    }
}
