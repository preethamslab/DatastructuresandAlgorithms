package com.algoexpert.arrays.algos;

public class KadaneAlgo
{
    // maximum sum of subarray
    // maximum ending here or num,
    public static void main(String[] args) {
        System.out.println(kadanesAlgorithm(new int[]{3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4}));
    }

    public static int kadanesAlgorithm(int[] array)
    {
        int maxendingHere = array[0];
        int maxSoFar = array[0];

        for(int i=1; i< array.length;i++)
        {
            maxendingHere = Math.max(array[i],maxendingHere+array[i]);
            maxSoFar = Math.max(maxendingHere,maxSoFar);
        }

        return maxSoFar;
    }

}
