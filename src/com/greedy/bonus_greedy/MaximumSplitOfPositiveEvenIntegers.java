package com.greedy.bonus_greedy;

import java.util.ArrayList;
import java.util.List;

public class MaximumSplitOfPositiveEvenIntegers {
    public static List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum%2==1){
            return new ArrayList<>();
        }
        long split=2;
        List<Long> ans=new ArrayList<>();
        while(finalSum>=split){
            ans.add(split);
            finalSum-=split;
            split+=2;
        }
        long lastValue=ans.get(ans.size()-1);
        ans.remove(ans.size()-1);
        ans.add(lastValue+finalSum);
        return ans;
    }
    public static void main(String[] args){
        long finalSum = 12;
        //long finalSum = 7;
        //long finalSum = 28;
        //long finalSum = 6914017674L;
        System.out.println("A list of integers that represent a valid split containing a maximum number of integers: "+MaximumSplitOfPositiveEvenIntegers.maximumEvenSplit(finalSum));
    }
}
