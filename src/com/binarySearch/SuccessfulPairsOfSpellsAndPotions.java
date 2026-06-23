package com.binarySearch;

import java.util.Arrays;
//2300. Successful Pairs of Spells and Potions
public class SuccessfulPairsOfSpellsAndPotions {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans=new int[spells.length];
        int m= potions.length;

        for(int i=0;i<spells.length;i++){
            int j=binarySearch(potions,success/(double) spells[i]);
            ans[i]=m-j;
        }
        return ans;
    }
    public static int binarySearch(int[] arr,double target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args){
        int[] spells = {5,1,3}, potions = {1,2,3,4,5}; long success = 7;
        System.out.println("The number of potions that will form a successful pair: "+Arrays.toString(SuccessfulPairsOfSpellsAndPotions.successfulPairs(spells,potions,success)));
    }
}
