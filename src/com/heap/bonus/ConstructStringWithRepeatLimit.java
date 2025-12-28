package com.heap.bonus;
//2182. Construct String With Repeat Limit
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ConstructStringWithRepeatLimit {
    public static PriorityQueue<Character> maxHeap;
    public static Map<Character,Integer> charToCountMap;
    public static String repeatLimitedString(String s, int repeatLimit) {
        maxHeap=new PriorityQueue<>((ch1,ch2) -> ch2-ch1);
        charToCountMap=new HashMap<>();
        for(char c: s.toCharArray()){
            charToCountMap.put(c,charToCountMap.getOrDefault(c,0)+1);
        }
        System.out.println(charToCountMap);
        for(char c: charToCountMap.keySet()){
            maxHeap.add(c);
        }
        StringBuilder sb=new StringBuilder();
        while(!maxHeap.isEmpty()){
            char ch=maxHeap.poll();
            int count=charToCountMap.get(ch);

            int use=Math.min(count,repeatLimit);
            for(int i=0;i<use;i++){
                sb.append(ch);
            }
            charToCountMap.put(ch,count-use);
            if(charToCountMap.get(ch)>0 && !maxHeap.isEmpty()){
                char nextCh=maxHeap.poll();
                sb.append(nextCh);
                charToCountMap.put(nextCh,charToCountMap.get(nextCh)-1);
                if(charToCountMap.get(nextCh)>0){
                    maxHeap.offer(nextCh);
                }
                maxHeap.offer(ch);
            }
        }
        return sb.toString();




        //-----------------------------My Solution-------------------------------------
        /*heap=new PriorityQueue<>((ch1,ch2) -> ch2-ch1);
        charToCountMap=new HashMap<>();
        for(char c: s.toCharArray()){
            charToCountMap.put(c,charToCountMap.getOrDefault(c,0)+1);
        }
        System.out.println(charToCountMap);
        for(char c: charToCountMap.keySet()){
            heap.add(c);
        }
        int charCount=0;
        Character currChar=null;
        StringBuilder sb=new StringBuilder();
        while(heap.size()>0) {
            charCount = charToCountMap.get(heap.peek());
            currChar = heap.peek();
            if (charCount<= repeatLimit) {
                heap.remove();
                while (charCount > 0) {
                    sb.append(currChar);
                    charToCountMap.put(currChar, charToCountMap.getOrDefault(currChar, 0) - 1);
                    charCount--;
                }
            } else {
                charCount = repeatLimit;
                while (charCount > 0) {
                    sb.append(currChar);
                    charToCountMap.put(currChar, charToCountMap.getOrDefault(currChar, 0) - 1);
                    charCount--;
                }
                heap.remove();
                if(!heap.isEmpty() && charToCountMap.get(heap.peek())>1){
                    sb.append(heap.peek());
                    charToCountMap.put(heap.peek(), charToCountMap.getOrDefault(heap.peek(), 0) - 1);
                }else if(!heap.isEmpty() && charToCountMap.get(heap.peek())==1){
                    charToCountMap.put(heap.peek(), charToCountMap.getOrDefault(heap.peek(), 0) - 1);
                    sb.append(heap.remove());
                }else{
                    continue;
                }
                heap.add(currChar);
            }
        }
        System.out.println(charToCountMap);
        return sb.toString();*/
    }

    public static void main(String[] args){
       //String s = "cczazcc"; int repeatLimit = 3;
       //String s = "aababab"; int repeatLimit = 2;
       //String s = "robnsdvpuxbapuqgopqvxdrchivlifeepy"; int repeatLimit=2;
       String s = "xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt"; int repeatLimit=1;
       System.out.println("The lexicographically largest repeatLimitedString possible is: "+ConstructStringWithRepeatLimit.repeatLimitedString(s,repeatLimit));
    }
}
