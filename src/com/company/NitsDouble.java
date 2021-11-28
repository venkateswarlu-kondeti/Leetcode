package com.company;

public class NitsDouble {
    public boolean checkIfExist(int[] arr) {
        Boolean N = false;
        int M=0;
        for(int i=0;i< arr.length;i++)
        {
            for(int j=0;j< arr.length;j++)
            {
                if((arr[j]==(2*arr[i]))&&(i!=j))
                {
                    N=true;
                    M=arr[i];
                    break;
                }
            }
        }
        System.out.println("M = "+M+ " N = "+(2*M));
        return N;
    }

    public static void main(String[] args)
    {
        NitsDouble n=new NitsDouble();
        int[] arr={0,0};
        System.out.println(n.checkIfExist(arr));
    }
}
