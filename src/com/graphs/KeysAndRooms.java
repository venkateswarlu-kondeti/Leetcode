package com.graphs;
//  841. Keys and Rooms
import java.util.*;

public class KeysAndRooms {
    public static Set<Integer> seen=new HashSet<>();
    public static boolean canVisitAllRooms(List<List<Integer>> rooms){
        seen.add(0);
        dfs(0,rooms);
        return seen.size()==rooms.size();
    }
    public static void dfs(int node, List<List<Integer>> rooms){
        for(int neighbor : rooms.get(node)){
            if(!seen.contains(neighbor)){
                seen.add(neighbor);
                dfs(neighbor,rooms);
            }
        }
    }
    public static void main(String[] args){
        List<List<Integer>> rooms= Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(2,4),
                Arrays.asList(3,1),
                Arrays.asList(1),
                Arrays.asList(2)
        );
        System.out.println("Visited all rooms? "+KeysAndRooms.canVisitAllRooms(rooms));
    }
}
