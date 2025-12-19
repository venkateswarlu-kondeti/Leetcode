package com.heap.bonus;

import java.util.*;
//692. Top K Frequent Words
public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> wordFreq=new HashMap<>();
        for(String w : words){
            wordFreq.put(w,wordFreq.getOrDefault(w,0)+1);
        }
        System.out.println(wordFreq);
        PriorityQueue<String> heap=new PriorityQueue<>((w1,w2) -> {
            if(wordFreq.get(w1)==wordFreq.get(w2)){
                return w1.compareTo(w2);
            }
            return wordFreq.get(w2)-wordFreq.get(w1);
        });
        List<String> ans=new ArrayList<>();
        for(String w :wordFreq.keySet()){
            heap.add(w);
        }
        while(k>0){
            ans.add(heap.remove());
            k--;
        }
        return ans;
    }
    public static void main(String[] args){
        //String[] words = {"i","love","leetcode","i","love","coding"}; int k = 2;
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"}; int k = 4;
        System.out.println("The k most frequent strings: "+TopKFrequentWords.topKFrequent(words,k));
    }
}
