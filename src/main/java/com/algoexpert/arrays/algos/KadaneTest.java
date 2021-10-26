package com.algoexpert.arrays.algos;

public class KadaneTest
{

    public static void main(String[] args) {
        System.out.println(kadaneAlgo(new int[]{3,5,-9,1,3}));
    }

    public static int kadaneAlgo(int[] arr)
    {
        int maxSoFar = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length;i++)
        {
            int temp = maxSoFar + arr[i];
            max = Integer.max(temp,max);
            maxSoFar = Integer.max(arr[i],max );
        }
        return maxSoFar;
    }

}
