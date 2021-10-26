package com.algoexpert.arrays.algos;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewards
{
    public static void main(String[] args) {
        System.out.println(minRewards(new int[]{8,4,2,1,3,6,7,9,5}));
    }
    public static int minRewards(int[] scores) {
        // Write your code here.
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards,1);
        for(int i: rewards)
            System.out.print(i);

        System.out.println("========");
        for(int i=1; i< scores.length;i++)
        {
            if(scores[i] > scores[i-1])
            {
                rewards[i] = rewards[i-1] + 1;
            }
        }

        for(int i: rewards)
            System.out.print(i);

        System.out.println("========");

        for(int i = scores.length-2; i>=0;i--)
        {
            if(scores[i] > scores[i+1])
                rewards[i] = Math.max(rewards[i], rewards[i+1]+1);
        }
        for(int i: rewards)
            System.out.print(i);

        System.out.println("========");
        return IntStream.of(rewards).sum();
    }
}
