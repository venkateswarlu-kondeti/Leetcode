package com.hashing;

import java.util.HashMap;
import java.util.Map;
//771. Jewels and Stones
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones){
        Map<Character,Integer> dic=new HashMap<>();
        int ans=0;
        for(char c : stones.toCharArray()){
            dic.put(c,dic.getOrDefault(c,0)+1);
        }
        System.out.println(dic);
        for(char c : jewels.toCharArray()){
            if(dic.containsKey(c)){
                ans+=dic.get(c);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        JewelsAndStones js=new JewelsAndStones();
        String jewels = "aA", stones = "aAAbbbb";
        //String jewels = "z", stones = "ZZ";
        System.out.println("The number of jewels and stones are: "+js.numJewelsInStones(jewels,stones));
    }
}
