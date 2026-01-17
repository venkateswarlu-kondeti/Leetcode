package com.greedy;

import java.util.Arrays;
//881. Boats to Save People
public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        int ans=0,i=0,j=people.length-1;
        Arrays.sort(people);
        while (i<=j){
            if(people[i]+people[j]<=limit){
                i++;
            }
            j--;
            ans++;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] people = {3,2,2,1}; int limit = 3;
        System.out.println("The minimum number of boats to carry every given person: "+BoatsToSavePeople.numRescueBoats(people,limit));
    }
}
