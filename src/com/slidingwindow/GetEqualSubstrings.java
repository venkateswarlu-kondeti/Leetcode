package com.slidingwindow;

public class GetEqualSubstrings {
    public int equalSubstring(String s, String t, int maxCost){
        int left=0;
        int ans=0;
        int curr=0;
        for(int right=0;right<s.length();right++){
            curr+=Math.abs((int)s.charAt(right)-(int)t.charAt(right));
            while(curr>maxCost){
                curr-=Math.abs((int)s.charAt(left)-(int)t.charAt(left));
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
    public static void main( String[] args){
        GetEqualSubstrings ge=new GetEqualSubstrings();
        //String s = "abcd";
        //String t = "bcdf";
        //int c=3;
        //String s = "abcd";
        //String t = "cdef";
        //int c=3;
        //String s = "abcd";
        //String t = "acde";
        //int c=0;
        String s = "krrgw";
        String t = "zjxss";
        int c=19;
        //String s = "pxezla";
        //String t = "loewbi";
        //int c=25;
        //String s = "jzmhzdq";
        //String t = "rymuemg";
        //int c=17;
        System.out.println("Equal substrings with budget is: "+ge.equalSubstring(s,t,c));

    }
}
