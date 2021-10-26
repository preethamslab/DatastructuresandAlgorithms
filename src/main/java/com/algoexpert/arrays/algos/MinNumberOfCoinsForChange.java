package com.algoexpert.arrays.algos;

import java.util.*;

public class MinNumberOfCoinsForChange
{
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        Map<Integer,Integer> arr = new HashMap<>();

        for(int denom: denoms)
        {
            System.out.println("denom" + denom + " = " +n/denom);
            if(n/denom > 0)
            {
                arr.put(denom,n/denom);
            }
        }

        Integer[] keyset= arr.keySet().toArray(new Integer[0]);
        Arrays.sort(keyset, Comparator.reverseOrder());

        int sum =0;

        return -1;
    }

    public static void main(String[] args) {
        minNumberOfCoinsForChange(7, new int[]{10,5,1});
    }
}
