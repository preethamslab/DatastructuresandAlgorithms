package com.algoexpert.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NonConstructibleChange
{
    public static void main(String[] args) {
        System.out.println(nonConstructibleChange(new int[]{5,7,1,1,2,3,22}));
    }
    public static int nonConstructibleChange(int[] coins) {
        // Write your code here.
        Arrays.sort(coins);
        int cchange = 0;

        for(int coin: coins)
        {
            if(coin > cchange + 1)
            {
                return cchange +1;
            }

            cchange +=coin;
        }
        return cchange+1;
    }
}
