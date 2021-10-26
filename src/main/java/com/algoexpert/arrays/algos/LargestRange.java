package com.algoexpert.arrays.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestRange
{
    public static int[] largestRange(int[] array) {
        // Write your code here.
        Map<Integer, Boolean> dataMap = new HashMap<>();

        int[] bestRange = new int[2];
        int longestLength= 0;
        for(int i:array)
            dataMap.put(i, true);

        for(int i:array)
        {
            if(!dataMap.containsKey(i))
            {
                continue;
            }

            dataMap.put(i, false);

            int currentLength = 1;
            int left = i -1 ;
            int right = i + 1;

            while(dataMap.containsKey(left))
            {
                dataMap.put(left, false);
                currentLength++;
                left--;
            }
            while(dataMap.containsKey(right))
            {
                dataMap.put(right, false);
                currentLength++;
                right++;
            }
            if(currentLength > longestLength )
            {
                longestLength = currentLength;
                bestRange = new int[]{left+1,right-1};
            }

        }

        return bestRange;
    }

    public static int[] largestRange1(int[] array) {
        // Write your code here.
        List<Integer> dataMap = new ArrayList<>();

        int[] bestRange = new int[2];
        int longestLength= 0;
        for(int i:array)
            dataMap.add(i);

        for(int i:array)
        {
            if(!dataMap.contains(i))
            {
                continue;
            }

            int currentLength = 1;
            int left = i -1 ;
            int right = i + 1;

            while(dataMap.contains(left))
            {
                currentLength++;
                left--;
            }
            while(dataMap.contains(right))
            {
                currentLength++;
                right++;
            }
            if(currentLength > longestLength )
            {
                longestLength = currentLength;
                bestRange = new int[]{left+1,right-1};
            }

        }

        return bestRange;
    }

    public static void main(String[] args) {
        int[] arr = largestRange1(new int[]{1,11,3,0,15,5,2,4,10,7,12,6});
        System.out.println(arr[0] + " "+ arr[1] );
    }
}
