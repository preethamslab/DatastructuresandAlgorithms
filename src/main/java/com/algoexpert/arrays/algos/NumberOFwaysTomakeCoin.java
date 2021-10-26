package com.algoexpert.arrays.algos;

public class NumberOFwaysTomakeCoin
{
    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeCoint(7, new int[]{2,4}));
    }

    public static int numberOfWaysToMakeCoint(int n, int[] denoms)
    {
        int[] ways = new int[n+1];
        ways[0] = 1;
        for(int denom: denoms)
        {
            for(int amount = 1; amount < n+1; amount++)
            {
                if(denom <= amount)
                    ways[amount] += ways[amount-denom];
            }
        }
        return ways[n];
    }

}
