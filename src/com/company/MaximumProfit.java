package com.company;

public class MaximumProfit {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])
            {
                maxProfit=maxProfit+(prices[i]-prices[i-1]);
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,1};
        int R;
        MaximumProfit mp = new MaximumProfit();
        R = mp.maxProfit(arr);
        System.out.println("Total Profit: " + R);
    }
}
