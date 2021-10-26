package com.algoexpert.Medimdiff;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue
{
    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[]{2,1,5,2,3,3,4}));
    }

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.
        if(array.length == 0)
            return 0;
        Set<Integer> numSet = new HashSet<>();
        for(int i: array) {
            if (numSet.contains(i))
                return i;
            numSet.add(i);
        }
        return -1;
    }
}
