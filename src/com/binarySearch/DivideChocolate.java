package com.binarySearch;

import java.util.Arrays;

//1231. Divide Chocolate
public class DivideChocolate {
    public static int cuttings;
    public static int maximizeSweetness(int[] sweetness, int k) {
        cuttings=k+1;
        /*int left=0,total=0;
        for(int s : sweetness){
            left=Math.min(left,s);
            total+=s;
        }
        int right=total/cuttings;*/
        int left= Arrays.stream(sweetness).min().getAsInt();
        int right=Arrays.stream(sweetness).sum()/cuttings;
        while(left<right){
            int mid=(left+right+1)/2;
            if(check(mid,sweetness)){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    public static boolean check(int maxSweet, int[] sweetness){
        int count=0, sum=0;
        for(int sweet : sweetness){
            sum+=sweet;
            if(sum>=maxSweet){
                count++;
                sum=0;
            }
        }
        return count>=cuttings;
    }
    public static void main(String[] args){
        //int[] sweetness = {1,2,3,4,5,6,7,8,9};
        //int k = 5;
        //int[] sweetness = {5,6,7,8,9,1,2,3,4};
        //int k = 8;
        int[] sweetness = {1,2,2,1,2,2,1,2,2};
        int k = 2;
        System.out.println("The maximum total sweetness of the piece you can get by cutting the chocolate bar optimally: "+DivideChocolate.maximizeSweetness(sweetness,k));
    }
}
