package com.twopointers;

public class ReverseOnlyLettersStr {

    public String reverseOnlyLetters(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            int charValue=(int)s.charAt(i);
            if((charValue>=65 && charValue<=90)||(charValue>=97 && charValue<=122)){
                sb.append(s.charAt(i));
            }
        }
        String revletter=sb.toString();
        StringBuilder sb1=new StringBuilder(revletter);
        for(int j=0;j<s.length();j++){
            int asciiValue=(int)s.charAt(j);
            if((asciiValue>=33 && asciiValue<=122) && !((asciiValue>=65 && asciiValue<=90)||(asciiValue>=97 && asciiValue<=122)) && (s.charAt(j)!='\"') && (s.charAt(j)!='\\')){
                sb1.insert(j,s.charAt(j));
            }
        }
        String revStr=sb1.toString();
        return revStr;
    }

    public static void main(String[] args){
        ReverseOnlyLettersStr r=new ReverseOnlyLettersStr();
        //String s="Test1ng-Leet=code-Q!";
        //String s="a-bC-dEf-ghIj";
        String s="ab-cd";
        System.out.println("Reverse only letters is: "+r.reverseOnlyLetters(s));
    }
}
