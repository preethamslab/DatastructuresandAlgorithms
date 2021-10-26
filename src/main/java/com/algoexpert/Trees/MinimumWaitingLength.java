package com.algoexpert.Trees;

import java.util.Arrays;

public class MinimumWaitingLength
{
    public static void main(String[] args) {
        minimumWaitingTime(new int[]{3,2,1,2,6});
    }

    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.

        if(queries.length == 1)
            return 0;

        Arrays.sort(queries);
        int sum = 0;
        int fsum = 0;
        for(int i=0 ; i < queries.length; i++)
        {
            if(i==0)
                continue;
            System.out.println(sum + " + " + queries[i-1]);
            sum = sum + queries[i-1];
            fsum = fsum + sum;
            System.out.println(fsum);
        }



        return fsum;
    }
}
