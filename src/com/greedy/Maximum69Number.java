package com.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Maximum69Number {
    public static int maximum69Number (int num) {
        //Converting num to string.
        String numString=""+num;
        //Replacing the first occurrence of the 6 to 9 if exists.
        return Integer.parseInt(numString.replaceFirst("6","9"));


 //--------------My Solution------------------------
        /*List<Integer> numList=new ArrayList<>();
        while(num>0){
            numList.add(num%10);
            num/=10;
        }
        Collections.reverse(numList);
        System.out.println(numList);
        PriorityQueue<int[]> digitToIndex=new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        for(int i=0;i<numList.size();i++){
            digitToIndex.add(new int[]{numList.get(i),i});
        }
        int[] top= digitToIndex.remove();
        if(top[0]!=9){
            numList.set(top[1],9);
        }
        int ans=0;
        for(int val :numList){
            ans=ans*10+val;
        }
        return ans;*/
    }
    public static void main(String[] args){
        int num = 9996;
        System.out.println("The maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6): "+Maximum69Number.maximum69Number(num));
    }
}
