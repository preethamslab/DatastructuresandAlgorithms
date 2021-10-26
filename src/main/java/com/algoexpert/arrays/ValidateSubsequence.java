package com.algoexpert.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateSubsequence
{

    // 2 pointer solution
    //
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        // O(n) Time and O(1) space complexity
        int mainptr = 0;
        int subarrptr = 0;

        while(mainptr < array.size() && subarrptr < sequence.size())
        {
            if(array.get(mainptr).equals(sequence.get(subarrptr)))
            {
                subarrptr++;
            }
            mainptr++;
        }
        return subarrptr == sequence.size();
    }
    // single pointer solution
    // O(n) time and O(1) space
    public static boolean isValidSubsequence1(List<Integer> array, List<Integer> sequence) {
        int seqid = 0;
        for(int num: array)
        {
            if(seqid == sequence.size())
            {
                break;
            }
            if(sequence.get(seqid).equals(num))
            {
                seqid++;
            }
        }
        return seqid == sequence.size();
    }
}
