package com.greedy.bonus_greedy;
//2457. Minimum Addition to Make Integer Beautiful
public class MinimumAdditionToMakeIntegerBeautiful {
    public static long makeIntegerBeautiful(long n, int target) {
        long m=10;
        long actualValue=n;
        while(digitSum(n)>target){
            long lastDigit=n%m;
            long difference=m-lastDigit;
            n+=difference;
            m*=10;
        }
        return n-actualValue;
    }

    public static long digitSum(long n){
        long sum=0;
        while(n>0){
            long lastDigit=n%10;
            n/=10;
            sum+=lastDigit;
        }
        return sum;
    }
    public static void main(String[] args){
        //long n = 16;
        //int target = 6;
        //long n = 19;
        //int target = 1;
        //long n = 204932336;
        //int target = 16;
        long n = 601148399401L;
        int target = 40;
        System.out.println("The minimum non-negative integer x such that n + x is beautiful: "+MinimumAdditionToMakeIntegerBeautiful.makeIntegerBeautiful(n,target));
    }
}
