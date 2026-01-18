package com.greedy.bonus_greedy;

import java.util.Arrays;

//1833. Maximum Ice Cream Bars
public class MaximumIceCreamBars {
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i=0, ans=0;
        while (i<costs.length && costs[i]<=coins){
            coins-=costs[i];
            i++;
            ans++;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] costs = {1,3,2,4,1}; int coins = 7;
        System.out.println("The maximum number of ice cream bars the boy can buy with coins: "+MaximumIceCreamBars.maxIceCream(costs,coins));
    }
}
