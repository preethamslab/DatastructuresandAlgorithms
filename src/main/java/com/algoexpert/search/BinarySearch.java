package com.algoexpert.search;

import java.util.Arrays;

public class BinarySearch
{
    public static int binarySearch(int[] array, int target) {
        // Write your code here
        return binarySearch(array,target, 0, array.length-1);
    }

    public static int binarySearch(int[] array, int target, int left, int right)
    {
        int split = left+right/2;
        if(target == array[split])
        {
            return split;
        }
        if(target > array[split]){
            return binarySearch(array, target, split, array.length);
        }else {
            return binarySearch(array, target, 0,split - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,4,5,7,8,77,99,103},99));

    }

}
