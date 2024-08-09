package com.graphs;

import java.util.*;

public class KeysAndRoomsIterative {
    public static boolean canVisitAllRoomsIterative(List<List<Integer>> rooms){
        Set<Integer> seen=new HashSet<>();
        Stack<Integer> stack=new Stack<>();
        seen.add(0);
        stack.push(0);
        while(!stack.empty()){
            int node=stack.pop();
            for(int neighbor : rooms.get(node)){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return seen.size()== rooms.size();
    }
    public static void main(String[] args){
        List<List<Integer>> rooms= Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(4),
                Arrays.asList(1)
        );
        System.out.println("Visited all rooms? "+KeysAndRoomsIterative.canVisitAllRoomsIterative(rooms));
    }
}
