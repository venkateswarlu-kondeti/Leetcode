package com.strings;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        int val=-1;
        for(int i=0;i<s.length();i++) {
            if (s.contains(s)) {

            }
        }
//        for(int i=0;i<s.length();i++)
//        {
//            char m=s.charAt(i);
//            for(int j=i+1;j<s.length();j++)
//            {
//                if((m==s.charAt(j)))
//                {
//                    cnt++;
//                    break;
//                }
//            }
//            if(cnt==0)
//            {
//                val=i;
//                break;
//            }else
//            {
//                cnt=0;
//            }
//        }
        return val;
    }
    public static void main(String[] args)
    {
        String s="aabb";
        FirstUniqueCharacter f=new FirstUniqueCharacter();
        f.firstUniqChar(s);
        System.out.println(f.firstUniqChar(s));
    }
}
