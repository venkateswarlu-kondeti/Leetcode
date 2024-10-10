package com.stacksandqueues;
import java.util.*;
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> deq=new ArrayDeque<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<k;i++){
            while(!deq.isEmpty() && nums[i]>= nums[deq.peekLast()]){
                deq.removeLast();
            }
            deq.addLast(i);
        }
        result.add(nums[deq.peekFirst()]);
        for(int i=k;i< nums.length;i++){
            if(deq.peekFirst()==i-k){
                deq.removeFirst();
            }
            while(!deq.isEmpty() && nums[i]>= nums[deq.peekLast()]){
                deq.removeLast();
            }
            deq.addLast(i);
            result.add(nums[deq.peekFirst()]);
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args){
        /*int[] nums={1,3,-1,-3,-2,3,6,7};
        int k=3;*/
        /*int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;*/
        /*int[] nums={1};
        int k=1;*/
        /*int[] nums={7,2,4};
        int k=2;*/
        int[] nums={1,3,1,2,0,5};
        int k=3;
        System.out.println("The maximum of sliding window is: "+ Arrays.toString(maxSlidingWindow(nums,k)));
    }
}
