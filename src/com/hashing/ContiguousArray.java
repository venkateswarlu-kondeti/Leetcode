package com.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//525. Contiguous Array
public class ContiguousArray {
    public static int findMaxlength(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int maxLength = 0;
        int count = 0;
        counts.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count = count + ((nums[i] == 1) ? 1 : -1);
            if (counts.containsKey(count)) {
                maxLength = Math.max(maxLength, i - counts.get(count));
            } else {
                counts.put(count, i);
            }
        }
        return maxLength;

        //----------------------------My Solution------------------------------------
        /*Map<Integer,Integer> dic=new HashMap<>();
        int n= nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0]==1? 1:-1;
        for(int i=1;i<prefix.length;i++){
            int num=nums[i]==1?1 : -1;
            prefix[i]=prefix[i-1]+num;
        }
        System.out.println(Arrays.toString(prefix));
        dic.put(0,-1);
        int ans=0;
        for(int i=0;i< prefix.length;i++){
            if(dic.containsKey(prefix[i])){
                ans=Math.max(ans,i-dic.get(prefix[i]));
            }else{
                dic.put(prefix[i],i);
            }
        }
        return ans;*/
    }

    public static void main(String[] args) {
        System.out.println("The max length of contiguous array is: " + findMaxlength(new int[]{0,1}));
        System.out.println("The max length of contiguous array is: " + findMaxlength(new int[]{0,1,0}));
        System.out.println("The max length of contiguous array is: " + findMaxlength(new int[]{0,1,1,0,1,1,1,0}));
        System.out.println("The max length of contiguous array is: " + findMaxlength(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1}));
        System.out.println("The max length of contiguous array is: " + findMaxlength(new int[]{0,0,1,0,0,0,1,1}));
        System.out.println("The max length of contiguous array is: " + findMaxlength(new int[]{1,1,1,1,1,1,1,1}));
    }
}
