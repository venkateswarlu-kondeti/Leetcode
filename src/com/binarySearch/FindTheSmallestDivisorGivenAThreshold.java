package com.binarySearch;
//1283. Find the Smallest Divisor Given a Threshold
public class FindTheSmallestDivisorGivenAThreshold {
    public static int limit;
    public static int smallestDivisor(int[] nums, int threshold) {
        limit=threshold;
        int left=1;
        int right=0;
        for(int num :nums){
            right=Math.max(right,num);
        }
        System.out.println(right);
        while (left<=right){
            int mid=left+(right-left)/2;
            if(check(mid,nums)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public static boolean check(int k, int[] nums){
        int sum=0;
        for(double num : nums){
            sum+=Math.ceil(num/k);
        }
        return sum<=limit;
    }
    public static void main(String[] args){
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println("The smallest divisor such that the result mentioned above is less than or equal to threshold: "+FindTheSmallestDivisorGivenAThreshold.smallestDivisor(nums,threshold));
    }
}
