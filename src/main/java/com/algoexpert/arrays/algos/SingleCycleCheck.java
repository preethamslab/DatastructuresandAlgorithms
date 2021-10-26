package com.algoexpert.arrays.algos;

import java.util.LinkedList;

public class SingleCycleCheck
{
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.

        int numElementsVisited=0;
        int currentIdx = 0;

        while(numElementsVisited < array.length)
        {
            if(numElementsVisited > 0 && currentIdx == 0)
                return false;

            numElementsVisited++;

            currentIdx = getNextINdex(currentIdx,array);
        }
        return currentIdx == 0;

    }
    public  static int getNextINdex(int currentIdx, int[] array)
    {
        int nextidx = 0;
        int jump = array[currentIdx];
        nextidx = (currentIdx + jump) % array.length;

        return nextidx >= 0 ? nextidx: (nextidx + array.length);
    }

    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[]{2,3,1,-4,-4,2}));
    }
}
