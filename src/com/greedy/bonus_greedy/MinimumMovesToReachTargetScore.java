package com.greedy.bonus_greedy;

public class MinimumMovesToReachTargetScore {
    public static int minMoves(int target, int maxDoubles) {
        int ans=0;
        while(target>1){
            if(maxDoubles>0){
                if(target%2==0){
                    target/=2;
                    maxDoubles--;
                }else {
                    target--;
                }
                ans++;
            }else{
                ans+=target-1;
                target=1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        //int target = 5, maxDoubles = 0;
        int target = 19, maxDoubles = 2;
        //int target = 10, maxDoubles = 4;
        System.out.println("The minimum number of moves needed to reach target starting with 1: "+MinimumMovesToReachTargetScore.minMoves(target,maxDoubles));
    }
}
