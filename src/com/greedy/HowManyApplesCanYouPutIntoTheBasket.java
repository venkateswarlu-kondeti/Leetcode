package com.greedy;

import java.util.Arrays;
//1196. How Many Apples Can You Put into the Basket
public class HowManyApplesCanYouPutIntoTheBasket {
    public static int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int apples=0, units=0;
        for(int i=0;i< weight.length && units+weight[i]<=5000;i++){
            apples++;
            units+=weight[i];
        }
        return apples;



//---------------------My Solution----------------------------
        /*Arrays.sort(weight);
        int ans=0;
        int currWeight=0;
        for(int w :weight){
            currWeight+=w;
            if(currWeight>5000){
                break;
            }
            ans++;
        }
        return ans;*/
    }
    public static void main(String[] args){
        int[] weight = {100,200,150,1000};
        System.out.println("The maximum number of apples you can put in the basket: "+HowManyApplesCanYouPutIntoTheBasket.maxNumberOfApples(weight));
    }
}
