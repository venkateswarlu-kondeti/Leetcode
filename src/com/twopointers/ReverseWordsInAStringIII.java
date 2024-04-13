package com.twopointers;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s){
        String reverseStr=null;
        if(s.length()>=1){
            StringBuilder sb=new StringBuilder();
            for(int i=s.length()-1;i>=0;i--){
                sb.append(s.charAt(i));
            }
            String sr=sb.toString();
            System.out.println(sr);
            int left;
            int right=sr.length();
            StringBuilder sb1=new StringBuilder();
            for(int j=sr.length()-1;j>=0;j--){
                if(sr.charAt(j)==' '){
                    left=j+1;
                    sb1.append(sr.substring(left,right));
                    sb1.append(sr.charAt(j));
                    right=j;
                }else if(j==0){
                    left=j;
                    sb1.append(sr.substring(left,right));
                }
            }
            reverseStr=sb1.toString();

        }
        return reverseStr;
    }

    public static void main(String[] args){
        ReverseWordsInAStringIII rs=new ReverseWordsInAStringIII();
        //String s="Let's take LeetCode contest";
        String s="Mr Ding";
        System.out.println("Reverse String is: "+rs.reverseWords(s));
    }
}
