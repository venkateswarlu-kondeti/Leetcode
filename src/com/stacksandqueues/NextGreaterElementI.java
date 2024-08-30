package com.stacksandqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        int[] ans=new int[nums1.length];
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> valMap=new HashMap<>();

        for(int i=0;i< nums2.length;i++){
            while(!stack.empty() && nums2[i]>stack.peek()){
                valMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.empty()){
            valMap.put(stack.pop(),-1);
        }
        for(int i=0;i< nums1.length;i++){
            ans[i]=valMap.get(nums1[i]);
        }
        return ans;

        //----------My Solution-----------------------------------------------
        /*int[] ans=new int[nums1.length];
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        HashMap<Integer,Integer> valMap=new HashMap<>();
        for(int i=0;i< nums2.length;i++){
            valMap.put(nums2[i],i);
        }
        System.out.println(valMap);
        for(int j=0;j< nums1.length;j++){
            int k=valMap.get(nums1[j]);
            while(k< nums2.length){
                if(!queue.isEmpty() && queue.getFirst()<nums2[k]){
                    ans[j]=nums2[k];
                    break;
                }
                queue.addLast(nums2[k]);
                ans[j]=-1;
                k++;
            }
            queue.clear();
        }
        return ans;*/
    }
    public static void main(String[] args){
        //int[] nums1={4,1,2};
        //int[] nums2={1,3,4,2};
        int[] nums1={2,4};
        int[] nums2={1,2,3,4};
        System.out.println("The array of the next greatest element is: "+ Arrays.toString(nextGreaterElement(nums1,nums2)));
    }
}
