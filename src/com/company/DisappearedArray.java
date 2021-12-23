package com.company;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DisappearedArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap <Integer,Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],nums[i]);
        }
        for(int i = 1; i < nums.length+1 ; i++){
            if(map.containsKey(i) == false){
                l.add(i);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        DisappearedArray da = new DisappearedArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(da.findDisappearedNumbers(nums));
    }
}
