package com.company;

public class EvenNumberOfDigits {

int len,cnt;
    public int findNumbers(int[] nums) {
        for(int i: nums){
            String value=Integer.toString(i);
            len=value.length();
            if (len%2==0)
            {
                cnt++;
            }
        }

    return cnt;
    }

    public static void main(String[] args)
    {
        EvenNumberOfDigits ed=new EvenNumberOfDigits();
        int[] nums={555,901,482,1771};
        System.out.println("Count of Even number of digits :"+ed.findNumbers(nums));
    }
}