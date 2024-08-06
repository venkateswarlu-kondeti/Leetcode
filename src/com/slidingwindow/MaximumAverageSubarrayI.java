package com.slidingwindow;

public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k){
        int currCount=0;
        double sum=0;
        int left=0;
        double ans=Integer.MIN_VALUE;
        for(int right=0;right<nums.length;right++){
            currCount++;
            sum+=nums[right];
            while(currCount>k){
                currCount--;
                sum-=nums[left];
                left++;
            }
            if(currCount==k){
                ans=Math.max(ans,sum);
            }
        }
        return ans/k;
    //------------------------Another Solution--------------------------
        /*double curr=0;
        for(int i=0;i<k;i++){
            curr+=nums[i];
        }
        double ans=curr;
        for(int j=k;j< nums.length;j++){
            curr+=nums[j]-nums[j-k];
            ans=Math.max(ans,curr);
        }
        return ans/k;*/
    }
    public static void main(String[] args){
        MaximumAverageSubarrayI f=new MaximumAverageSubarrayI();
        //int[] nums={1,12,-5,-6,50,3};
        //int[] nums={5};
        //int[] nums={0,4,0,3,2};
        //int k=4;
        //int k=1;
        //int k=1;
        int[] nums={-6662,5432,-8558,-8935,8731,-3083,4115,9931,-4006,-3284,-3024,1714,-2825,-2374,-2750,-959,6516,9356,8040,-2169,-9490,-3068,6299,7823,-9767,5751,-7897,6680,-1293,-3486,-6785,6337,-9158,-4183,6240,-2846,-2588,-5458,-9576,-1501,-908,-5477,7596,-8863,-4088,7922,8231,-4928,7636,-3994,-243,-1327,8425,-3468,-4218,-364,4257,5690,1035,6217,8880,4127,-6299,-1831,2854,-4498,-6983,-677,2216,-1938,3348,4099,3591,9076,942,4571,-4200,7271,-6920,-1886,662,7844,3658,-6562,-2106,-296,-3280,8909,-8352,-9413,3513,1352,-8825};
        int k=90;
        System.out.println("Max average is: "+f.findMaxAverage(nums,k));
    }
}
