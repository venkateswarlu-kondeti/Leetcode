package com.strings;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseString {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while(left<right){
            char temp=s[left];
            s[left++]=s[right];
            s[right--]=temp;
        }
        System.out.println(Arrays.toString(s));
    }
    public static void main(String[] args)
    {
        //char[] s={'h','e','l','l','o'};
        char[] s={'M','O','T','H','E','R'};
        ReverseString r=new ReverseString();
        r.reverseString(s);
    }
}
