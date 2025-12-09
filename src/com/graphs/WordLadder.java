package com.graphs;

import java.util.*;
//127. Word Ladder
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Map<String,List<String>> graph=new HashMap<>();
        for(String word : wordList){
            for(int i=0;i<beginWord.length();i++){
                String newWord=word.substring(0,i)+"*"+word.substring(i+1,beginWord.length());
                graph.computeIfAbsent(newWord, k->new ArrayList<>()).add(word);
            }
        }
        System.out.println(graph);
        Queue<Pair> queue=new LinkedList<>();
        Set<String> seen=new HashSet<>();
        queue.add(new Pair(beginWord,1));
        seen.add(beginWord);
        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            String node=pair.node;
            int steps=pair.steps;
            for(int i=0;i<node.length();i++){
                String newNode=node.substring(0,i)+"*"+node.substring(i+1,node.length());

                for(String neighbor : graph.getOrDefault(newNode, new ArrayList<>())){
                    if(neighbor.equals(endWord)){
                        return steps+1;
                    }
                    if(!seen.contains(neighbor)){
                        seen.add(neighbor);
                        queue.add(new Pair(neighbor,steps+1));
                    }
                }
            }
        }
        return 0;

        //--------------------------Another Solution---------------------------------------------------------
        /*Map<String,List<String>> graph=new HashMap<>();
        if(!wordList.contains(endWord) || (wordList.contains(endWord) && wordList.size()==2)){
            return 0;
        }
        String str1=beginWord;
        for(String str2 : wordList){
            int i=0, count=0;
            while(i<beginWord.length()){
                if(str1.charAt(i)!=str2.charAt(i)){
                    count++;
                }
                i++;
            }
            if(count==1){
                graph.computeIfAbsent(str1, k->new ArrayList<>()).add(str2);
            }
        }
        for(int i=0;i< wordList.size();i++){
            for(int j=0;j< wordList.size();j++){
                if(i==j){
                    continue;
                }
                int k=0,cnt=0;
                while(k<beginWord.length()){
                    if(wordList.get(i).charAt(k)!=wordList.get(j).charAt(k)){
                        cnt++;
                    }
                    k++;
                }
                if(cnt==1){
                    graph.computeIfAbsent(wordList.get(i),l->new ArrayList<>()).add(wordList.get(j));
                }
            }
        }
        System.out.println(graph);
        Queue<Pair> queue=new LinkedList<>();
        Set<String> seen=new HashSet<>();
        queue.add(new Pair(beginWord,1));
        seen.add(beginWord);
        int ans=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            String node=pair.node;
            int steps=pair.steps;
            if(node.equals(endWord)){
                ans=Math.min(ans,steps);
            }
            for(String neighbor : graph.getOrDefault(node, new ArrayList<>())){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    queue.add(new Pair(neighbor,steps+1));
                }
            }
        }
         return ans!=Integer.MAX_VALUE? ans : 0;*/
    }
    public static void main(String[] args){
        /*String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");*/
        /*String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot","dog","dot");*/
        /*String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");*/
        /*String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hit","cog");*/
        String beginWord = "talk";
        String endWord = "tail";
        List<String> wordList = Arrays.asList("talk","tons","fall","tail","gale","hall","negs");
        System.out.println("The number of words in the shorted transformation sequence is: "+WordLadder.ladderLength(beginWord,endWord,wordList));
    }
    public static class Pair{
        String node;
        int steps;
        Pair(String node, int steps){
            this.node=node;
            this.steps=steps;
        }
    }
}
