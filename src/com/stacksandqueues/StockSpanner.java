package com.stacksandqueues;
import java.util.*;
public class StockSpanner {
    Stack<int[]> stack=new Stack<>();

    public int next(int price){
        int ans=1;
         while(!stack.empty() && stack.peek()[0]<=price){
             ans+=stack.pop()[1];
         }
         stack.push(new int[]{price,ans});
         return ans;
    }



    //-----------------------My Solution------------------------------------------------------------------------------------
    /*Stack<Integer> queue1;
    HashMap<Integer,Integer> countMap;
    int ans;
    public StockSpanner(){
        queue1=new Stack<>();
        countMap=new HashMap<>();
    }
    public int next(int price){
        if(!queue1.empty() && price==queue1.peek()){
            countMap.put(queue1.size()-1,countMap.getOrDefault(queue1.size()-1,0)+1);
        }else if(!queue1.empty() && price<queue1.peek()){
            queue1.push(price);
            countMap.put(queue1.size()-1,countMap.getOrDefault(queue1.size()-1,0)+1);
            return 1;
        }else{
            queue1.push(price);
            countMap.put(queue1.size()-1,countMap.getOrDefault(queue1.size()-1,0)+1);
        }
        ans=0;
        int k=queue1.size()-1;
        while(k>=0 && price>=queue1.get(k)){
            ans+=countMap.get(k);
            k--;
        }
        return ans;
    }*/
    public static void main(String[] args){
        StockSpanner stockSpanner = new StockSpanner();
        int ss1=stockSpanner.next(100);
        int ss2=stockSpanner.next(80);
        int ss3=stockSpanner.next(60);
        int ss4=stockSpanner.next(70);
        int ss5=stockSpanner.next(60);
        int ss6=stockSpanner.next(75);
        int ss7=stockSpanner.next(85);
        List<Integer> ssList=new ArrayList<>();
        ssList.add(ss1);
        ssList.add(ss2);
        ssList.add(ss3);
        ssList.add(ss4);
        ssList.add(ss5);
        ssList.add(ss6);
        ssList.add(ss7);

        /*int ss1=stockSpanner.next(29);
        int ss2=stockSpanner.next(91);
        int ss3=stockSpanner.next(62);
        int ss4=stockSpanner.next(76);
        int ss5=stockSpanner.next(51);
        List<Integer> ssList=new ArrayList<>();
        ssList.add(ss1);
        ssList.add(ss2);
        ssList.add(ss3);
        ssList.add(ss4);
        ssList.add(ss5);*/
        System.out.println("The online stock span is: "+ssList);
    }
}
