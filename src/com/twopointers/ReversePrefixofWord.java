package com.twopointers;

public class ReversePrefixofWord {

    public String reversePrefix(String word, char ch){
        String revPrefix=word;
        if(word.contains(String.valueOf(ch))){
            StringBuilder sb=new StringBuilder();
            int firstOccurance=0;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)==ch){
                    firstOccurance=i;
                    break;
                }
            }
            firstOccurance++;
            String segmt=word.substring(0,firstOccurance);
            for(int j=segmt.length()-1;j>=0;j--){
                sb.append(segmt.charAt(j));
            }
            while(firstOccurance<word.length()){
                sb.append(word.charAt(firstOccurance));
                firstOccurance++;
            }
            revPrefix=sb.toString();
            return revPrefix;
        }
        return revPrefix;
    }

    public static void main (String[] args){
        ReversePrefixofWord rp=new ReversePrefixofWord();
        //String w = "abcdefd";
        //char c='d';
        //String w = "xyxzxe";
        //char c='z';
        String w = "abcd";
        char c='z';
        System.out.println("Reverse prefix is: "+rp.reversePrefix(w,c));
    }
}
