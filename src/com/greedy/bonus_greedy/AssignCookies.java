package com.greedy.bonus_greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0, ans=0;
        while(i<s.length && j<g.length){
            if(s[i]>=g[j]){
                ans++;
                j++;
            }
            i++;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println("The max number of your content children: "+AssignCookies.findContentChildren(g,s));
    }
}
