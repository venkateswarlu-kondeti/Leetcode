package com.greedy.bonus_greedy;

import java.util.Arrays;
//2410. Maximum Matching of Players With Trainers
public class MaximumMatchingOfPlayersWithTrainers {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0,j=0,ans=0;
        while(i<players.length && j<trainers.length){
            if(players[i]<=trainers[j]){
                i++;
                ans++;
            }
            j++;
        }
        return  ans;
    }
    public static void main(String[] args){
        int[] players = {4,7,9};
        int[] trainers = {8,2,5,8};
        System.out.println("The maximum number of matchings between players and trainers that satisfy these conditions: "+MaximumMatchingOfPlayersWithTrainers.matchPlayersAndTrainers(players,trainers));
    }
}
