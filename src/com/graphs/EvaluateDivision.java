package com.graphs;
// 399. Evaluate Division

import java.util.*;

public class EvaluateDivision {
    public static Map<String, Map<String, Double>> graph=new HashMap<>();
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        for(int i=0;i< equations.size();i++){
            String numerator=equations.get(i).get(0), denominator=equations.get(i).get(1);
            double val=values[i];
            if(!graph.containsKey(numerator)){
                graph.put(numerator,new HashMap<>());
            }
            if(!graph.containsKey(denominator)){
                graph.put(denominator,new HashMap<>());
            }
            graph.get(numerator).put(denominator,val);
            graph.get(denominator).put(numerator,1/val);
        }
        double[] ans=new double[queries.size()];
        for(int i=0;i< queries.size();i++){
            ans[i]=answerQuery(queries.get(i).get(0),queries.get(i).get(1));
        }
        return ans;
    }
    public static double answerQuery(String start, String end){
        if(!graph.containsKey(start)){
            return -1;
        }
        Queue<Pair> queue=new LinkedList<>();
        Set<String> seen=new HashSet<>();
        seen.add(start);
        queue.add(new Pair(start,1));
        while (!queue.isEmpty()){
            Pair pair=queue.remove();
            String node=pair.node;
            double ratio=pair.ratio;
            if(node.equals(end)){
                return ratio;
            }
            for(String neighbor : graph.get(node).keySet()){
                if(!seen.contains(neighbor)){
                    seen.add(neighbor);
                    queue.add(new Pair(neighbor,ratio*graph.get(node).get(neighbor)));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a","b"),
                Arrays.asList("b","c")
        );
        double[] values = {2.0,3.0};
        List<List<String>>  queries =Arrays.asList(
                Arrays.asList("a","c"),
                Arrays.asList("b","a"),
                Arrays.asList("a","e"),
                Arrays.asList("a","a"),
                Arrays.asList("x","x")
        );
        System.out.println("The array of answers of all queries is: "+Arrays.toString(EvaluateDivision.calcEquation(equations,values,queries)));
    }
    public static class Pair{
        String node;
        double ratio;
        Pair(String node, double ratio){
            this.node=node;
            this.ratio=ratio;
        }
    }
}
