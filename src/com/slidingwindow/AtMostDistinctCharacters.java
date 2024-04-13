package com.slidingwindow;

public class AtMostDistinctCharacters {
    public int distinctCharacters(String s, int k){
        int left=0;
        int count=1;
        int ans=0;
        for(int right=1;right<s.length();right++){
            if(s.charAt(left)!=s.charAt(right)){
                count++;
                while(count>k){
                    count--;
                    left++;
                }
                ans=Math.max(ans,right-left+1);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        AtMostDistinctCharacters dc=new AtMostDistinctCharacters();
        //String s="eceba";
        //String s="ecebaee";
        String s="ecebaeeaaaahhdtkksssnfjfm";
        int k=2;
        System.out.println("At most distinct characters is: "+dc.distinctCharacters(s, k));
    }
}
