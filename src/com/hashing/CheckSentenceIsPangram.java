package com.hashing;

import java.util.HashSet;
import java.util.Set;
//1832. Check if the Sentence Is Pangram
public class CheckSentenceIsPangram {

    public boolean checkIfPangram(String sentence) {
        Set<Character> c = new HashSet<>();
        for (char currentCharacter : sentence.toCharArray()) {
            c.add(currentCharacter);
        }
        return c.size() == 26? true : false;
    }
    //My Solution:
    /*public boolean checkIfPangram(String sentence) {
        Set<Character> c = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            c.add(sentence.charAt(i));
        }
        return c.size() == 26? true : false;
    }*/
    public static void main(String[] args){
        CheckSentenceIsPangram sp=new CheckSentenceIsPangram();
        String sn= "thequickbrownfoxjumpsoverthelazydog";
        //String sn= "leetcode";
        System.out.println("Is the sentence pangram? "+sp.checkIfPangram(sn));
    }
}
