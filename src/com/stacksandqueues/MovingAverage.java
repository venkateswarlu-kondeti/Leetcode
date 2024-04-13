package com.stacksandqueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverage {
    int size,ans=0,firstVal=0;
    Queue<Integer> queue=new LinkedList<>();
    public MovingAverage(int size){
        this.size=size;
    }
    public double next(int val){
        queue.offer(val);
        firstVal=queue.size()>size ? queue.poll() : 0;
        ans+=val-firstVal;
        System.out.println(queue);
      return (double) ans/queue.size();
    }
    public static void main(String[] args){
        MovingAverage ma=new MovingAverage(3);
        double output1=ma.next(1);
        double output2=ma.next(10);
        double output3=ma.next(3);
        double output4=ma.next(5);
        List<Double> outputList=new ArrayList<>();
        //outputList.add(ma.);
        outputList.add(output1);
        outputList.add(output2);
        outputList.add(output3);
        outputList.add(output4);
        System.out.println("The moving average from data stream is: "+outputList);
    }
}
