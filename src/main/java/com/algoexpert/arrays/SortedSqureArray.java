package com.algoexpert.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SortedSqureArray
{
    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        // time O(nlogn) T and space O(n)
        int[] arr = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            arr[i] = array[i]*array[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    public int[] sortedSquaredArray1(int[] array) {
        //int[] arr = new int[array.length];
        Set<Integer> retSet = new TreeSet<>();
        for(int i=0;i<array.length;i++)
        {
            retSet.add(array[i]*array[i]);
        }
        //Arrays.sort(arr);
        //return retSet;
        return new int[]{};
    }




}
