package com.stacksandqueues.queues;

import java.util.*;
public class Dota2Senate {
    public static String predictPartyVictory(String senate){
        Queue<Character> queue1=new LinkedList<>();
        Queue<Character> queue2=new LinkedList<>();
        List<Character> charList=new ArrayList<>();
        for(char c : senate.toCharArray()){
            charList.add(c);
        }
        while(charList.contains('R') && charList.contains('D')){
            for(char c : charList){
                if(!queue1.isEmpty() && queue1.peek()!=c){
                    queue2.add(queue1.remove());
                    continue;
                }
                queue1.add(c);
            }
            System.out.println("queue2 : "+queue2);
            System.out.println("queue1 : "+queue1);
            while(!queue2.isEmpty()){
                queue1.add(queue2.remove());
            }
            System.out.println("queue2 : "+queue2);
            System.out.println("queue1 : "+queue1);
            charList.clear();
            while(!queue1.isEmpty()){
                charList.add(queue1.remove());
            }
        }
        System.out.println("charList : "+charList);
        return charList.get(0)=='R' ? "Radiant" : "Dire";
    }
    public static void main(String[] args){
        String senate="RD";
        //String senate="RDD";
        //String senate="DDR";
        //String senate="DDRRR";
        //String senate="DRRDRDRDRDDRDRDR";
        //String senate="DRRDRDRDRDDRDRDRD";
        System.out.println("Dota2 Senate is: "+predictPartyVictory(senate));
    }
}
