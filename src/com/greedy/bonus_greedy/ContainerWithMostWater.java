package com.greedy.bonus_greedy;

import java.util.PriorityQueue;
//11. Container With Most Water
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int i=0, j=height.length-1, ans=0;
        while(i<j){
            int currHeight=Math.min(height[i],height[j]);
            ans=Math.max(ans,currHeight*(j-i));
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("The maximum amount of water a container can store: "+ContainerWithMostWater.maxArea(height));
    }
}
