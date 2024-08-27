package com.stacksandqueues;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack=new Stack<>();
        int[] answer=new int[temperatures.length];
        for(int i=0;i< temperatures.length;i++){
            while(!stack.empty() && temperatures[stack.peek()]<temperatures[i]){
                int j=stack.pop();
                answer[j]=i-j;
            }
            stack.push(i);
        }
        return answer;
    }
    public static void main(String[] args){
        //int[] temp={40,35,32,37,50};
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println("The days between warmer and colder temperatures are: "+ Arrays.toString(dailyTemperatures(temperatures)));
    }
}
