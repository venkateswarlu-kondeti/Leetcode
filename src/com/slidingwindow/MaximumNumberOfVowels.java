package com.slidingwindow;




import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfVowels {

    public int maxVowels(String s, int k){
        Set<Character> vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int left=0;
        int currLength=0;
        int vowelCount=0;
        int ans=0;
        for(int right=0;right<s.length();right++){
            if(vowels.contains(s.charAt(right))){
                vowelCount++;
            }
            currLength++;
            while(currLength>k){
                if(vowels.contains(s.charAt(left))){
                    vowelCount--;
                }
                left++;
                currLength--;
            }
            if(currLength==k){
                ans=Math.max(ans,vowelCount);
            }
        }
        return ans;

        /*int count = 0;
        Set<Character> vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int i=0;i<k;i++){
            count+=vowels.contains(s.charAt(i))?1 : 0;
        }
        int ans=count;

        for(int j=k;j<s.length();j++){
            count+=vowels.contains(s.charAt(j))? 1 : 0;
            count-=vowels.contains(s.charAt(j-k))? 1 : 0;
            ans=Math.max(ans,count);
        }
        return ans;*/
    }
    public static void main(String[] args){
        MaximumNumberOfVowels mn=new MaximumNumberOfVowels();
        //String s="abciiidef";
        //int k=3;
        //String s="aeiou";
        //int k=2;
        String s="leetcode";
        int k=3;
        //String s="weallloveyou";
        //int k=7;
        //String s="ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        //int k=33;
        System.out.println("Maximum number of vowels in a Substring of given length is: "+mn.maxVowels(s,k));
    }
}
