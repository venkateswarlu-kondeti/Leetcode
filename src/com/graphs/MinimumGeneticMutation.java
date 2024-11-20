package com.graphs;

import java.util.*;

public class MinimumGeneticMutation {
    public static int minMutation(String startGene, String endGene, String[] bank){
        Queue<Pair> queue=new LinkedList<>();
        Set<String> seen=new HashSet<>();
        queue.add(new Pair(startGene,0));
        seen.add(startGene);
        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            String node= pair.node;
            int steps= pair.steps;
            if(node.equals(endGene)){
                return steps;
            }
            for(int i=0;i<startGene.length();i++){
                for(char c: new char[]{'A','C','G','T'}){
                    String neighbor=node.substring(0,i)+c+node.substring(i+1);
                    if(!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)){
                        seen.add(neighbor);
                        queue.add(new Pair(neighbor,steps+1));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        /*String startGene = "AACCGGTT" , endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};*/
        String startGene = "AACCGGTT" , endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println("The minimum genetic mutation is: "+MinimumGeneticMutation.minMutation(startGene,endGene,bank));
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
