package com.algoexpert.arrays.algos;

import java.util.ArrayList;
import java.util.List;

public class SubArraySort
{
    public static void subarraySort(int[] array) {
        // Write your code here.

        int startIdx = 0;
        int mvindex = 1;
        List<Integer> retArray = new ArrayList<Integer>();
        while(startIdx < array.length && mvindex < array.length)
        {

                if(array[mvindex] < array[startIdx]) {
                    retArray.add(startIdx);
                    retArray.add(mvindex);
                }

            startIdx++;
            mvindex++;
        }
        System.out.println(startIdx+ " "+mvindex);
        System.out.println(retArray);
    }

    public static void main(String[] args) {
        subarraySort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19});
    }
}
