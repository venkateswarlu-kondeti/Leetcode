package com.hashing.checkingForExistence;



import java.util.*;
//1496. Path Crossing
public class PathCrossing {
    public boolean isPathCrossing(String path){
        Map<Character,List<Integer>> dic=new HashMap<>();
        dic.put('N',new ArrayList<>());
        dic.get('N').add(0);
        dic.get('N').add(1);
        dic.put('S',new ArrayList<>());
        dic.get('S').add(0);
        dic.get('S').add(-1);
        dic.put('E',new ArrayList<>());
        dic.get('E').add(1);
        dic.get('E').add(0);
        dic.put('W',new ArrayList<>());
        dic.get('W').add(-1);
        dic.get('W').add(0);

        System.out.println(dic);
        Set<List<Integer>> s=new HashSet<>();
        List<Integer> l=new ArrayList<>();
        l.add(0);
        l.add(0);
        s.add(l);
        System.out.println(s);
        int x=0;
        int y=0;
        for(char c : path.toCharArray()){
            x+=dic.get(c).get(0);
            y+=dic.get(c).get(1);
            List<Integer> l1=new ArrayList<>();
            l1.add(x);
            l1.add(y);
            if(s.contains(l1)){
                return true;
            }
            s.add(l1);
            System.out.println(s);
        }
        return false;
        /*Map<String,List<Integer>> dic=new HashMap<>();
        int x=0;
        int y=0;
        List<Integer> l=new ArrayList<>();
        for(char c : path.toCharArray()){
            if(c=='N'){
                y++;
                if(x==0 && y==0){
                    return true;
                }

                l.add(x);
                l.add(y);
                if(dic.values().contains(l)){
                    System.out.println(dic);
                    return true;
                }
                String str= String.valueOf(c+x+y);
                dic.put(str, new ArrayList<>());
                dic.get(str).add(x);
                dic.get(str).add(y);
                l.clear();
            }else if(c=='E'){
                x++;
                if(x==0 && y==0){
                    return true;
                }
                l.add(x);
                l.add(y);
                if(dic.values().contains(l)){
                    System.out.println(dic);
                    return true;
                }
                String str= String.valueOf(c+x+y);
                dic.put(str, new ArrayList<>());
                dic.get(str).add(x);
                dic.get(str).add(y);
                l.clear();
            }else if(c=='S'){
                y--;
                if(x==0 && y==0){
                    return true;
                }
                l.add(x);
                l.add(y);
                if(dic.values().contains(l)){
                    System.out.println(dic);
                    return true;
                }
                String str= String.valueOf(c+x+y);
                dic.put(str, new ArrayList<>());
                dic.get(str).add(x);
                dic.get(str).add(y);
                l.clear();
            }else{
                x--;
                if(x==0 && y==0){
                    return true;
                }
                l.add(x);
                l.add(y);
                if(dic.values().contains(l)){
                    System.out.println(dic);
                    return true;
                }
                String str= String.valueOf(c+x+y);
                dic.put(str, new ArrayList<>());
                dic.get(str).add(x);
                dic.get(str).add(y);
                l.clear();
            }
        }
        System.out.println(dic);
        return false;*/
    }
    public static void main(String[] args){
        PathCrossing pc=new PathCrossing();
        //String path="NES";
        //String path="NESWW";
        //String path="SS";
        //String path="ES";
        //String path="NNSWWEWSSESSWENNW";
        String path="EESWN";
        System.out.println("The path crossing is : "+pc.isPathCrossing(path));
    }
}
