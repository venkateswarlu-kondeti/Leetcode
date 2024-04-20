package com.stacksandqueues.monotonic;

import java.util.*;

public class SpecialDiscount {
    public static int[] finalPrices(int[] prices){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i< prices.length;i++){
            if(!stack.empty() && stack.peek()>=prices[i]){
                    prices[i-1]=stack.pop()-prices[i];
            }else if(!stack.empty() && stack.peek()<prices[i]){
                int j=i;
                while(j<prices.length && stack.peek()<prices[j]){
                    j++;
                }
                if(j<prices.length){
                    prices[i-1]=stack.pop()-prices[j];
                }
            }
            stack.push(prices[i]);
        }
        System.out.println(stack);
        return prices;
    }
    public static void main(String[] args){
        //int[] prices={8,4,6,2,3};
        //int[] prices={1,2,3,4,5};
        //int[] prices={10,1,1,6};
        int[] prices={8,7,4,2,8,1,7,7,10,1};
        System.out.println("Final prices with a special discount in a shop is: "+ Arrays.toString(finalPrices(prices)));
    }
}
