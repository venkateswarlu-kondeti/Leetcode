package com.hashing.checkingForExistence;

import java.util.*;
//1436. Destination City
public class DestinationCity {
    public String destCity(List<List<String>> paths){
        Set<String> dic=new HashSet<>(); // Space Complexity: O(n)
        for(int i=0;i<paths.size();i++){ // Time Complexity: O(n)
            dic.add(paths.get(i).get(0));
        }
        for(int i=0;i<paths.size();i++){ // Time Complexity: O(n)
            String state=paths.get(i).get(1);
            if(!dic.contains(state)){
                return state;
            }
        }
        return "";

        // My Solution
        /*Map<String,Integer> dic=new HashMap<>();
        for(List<String> l : paths){
            for(int i=0;i<l.size();i++){
                if (dic.containsKey(l.get(i))) {
                    dic.remove(l.get(i));
                }else{
                    dic.put(l.get(i), i);
                }
            }
        }
        System.out.println(dic);
        String ans=null;
        for(Map.Entry<String,Integer> e : dic.entrySet()){
            if(e.getValue()==1){
                ans=e.getKey();
            }
        }
        return ans;*/
    }
    public static void main(String[] args){
        DestinationCity dc=new DestinationCity();
        List<String> l1=new ArrayList<>();
        l1.add("London");
        l1.add("New York");
        List<String> l2=new ArrayList<>();
        l2.add("New York");
        l2.add("Lima");
        List<String> l3=new ArrayList<>();
        l3.add("Lima");
        l3.add("Sao Paulo");
        List<List<String>> l=new ArrayList<>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
        System.out.println(l);
        System.out.println("The destination city is: "+dc.destCity(l));
    }
}