package com.stacksandqueues.stacks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stack=new Stack<>();
        int[] ans;
        for(int a : asteroids){
            while(!stack.empty() && stack.peek()>0 && a<0 && Math.abs(stack.peek())<Math.abs(a)){
                stack.pop();
            }
            if(!stack.empty() && stack.peek()>0 && a<0 && Math.abs(stack.peek())==Math.abs(a)){
                stack.pop();
                continue;
            }else if(!stack.empty() && stack.peek()>0 && a<0 && Math.abs(stack.peek())>Math.abs(a)){
                continue;
            }
            stack.push(a);
        }
        System.out.println(stack);
        ans=new int[stack.size()];
        for(int j=ans.length-1;j>=0 ;j--){
            ans[j]=stack.pop();
        }
        return ans;
    }
    public static void main(String[] args){
        //int[] asteroids={5,10,-5};
        //int[] asteroids={8,-8};
        //int[] asteroids={10,2,-5};
        //int[] asteroids={-2,-1,1,2};
        //int[] asteroids={-2,-2,-2,1};
        //int[] asteroids={-2,-2,1,-2};
        //int[] asteroids={-2,-2,1,-1};
        //int[] asteroids={-2,1,-2,-2};
        int[] asteroids={-2,1,-1,-2};
        //int[] asteroids={-2,2,-1,-2};
        System.out.println("The array after asteroids collision is: "+ Arrays.toString(asteroidCollision(asteroids)));
    }
}
