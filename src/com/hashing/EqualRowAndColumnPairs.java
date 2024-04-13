package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid){
        Map<String,Integer> dic=new HashMap<>();
        for(int[] row : grid){
            String key=convertToKey(row);
            dic.put(key,dic.getOrDefault(key,0)+1);
        }
        Map<String,Integer> dic2=new HashMap<>();
        for(int col=0;col<grid[0].length;col++){
            int[] currentCol=new int[grid.length];
            for(int row=0;row<grid.length;row++){
                currentCol[row]=grid[row][col];
            }
            String key=convertToKey(currentCol);
            dic2.put(key,dic2.getOrDefault(key,0)+1);
        }
        int ans=0;
        for(String key : dic.keySet()){
            ans+=dic.get(key)*dic2.getOrDefault(key,0);
        }
        return ans;
    }
    public String convertToKey(int[] nums){
        StringBuilder sb=new StringBuilder();
        for(int num : nums){
            sb.append(num);
            sb.append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        EqualRowAndColumnPairs er=new EqualRowAndColumnPairs();
        int[][] grid={{3,2,1},
                      {1,7,6},
                      {2,7,7}};
        System.out.println("The equal row and column pairs are: "+er.equalPairs(grid));
    }
}
