package com.stacksandqueues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter(){
        queue=new LinkedList<>(Arrays.asList(1,100,200));
    }
    public int ping(int t){
        while(!queue.isEmpty() && queue.peek()<t-3000){
            queue.poll();
        }
        queue.offer(t);
        System.out.println(queue);
        return queue.size();
    }

    public static void main(String[] args){
        RecentCounter rc=new RecentCounter();
        int val=5000;
        int output=rc.ping(val);
        System.out.println("The recent counter is: "+output);
    }
}
