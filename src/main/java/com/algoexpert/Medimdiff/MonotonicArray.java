package com.algoexpert.Medimdiff;

import java.util.Arrays;

public class MonotonicArray
{
    public static void main(String[] args) {
        int a[] = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic1(a));
    }

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        boolean isIncreasing = false;
        boolean isMonotonous= false;
        int k = 0;
        if(array.length == 0 || array.length == 1)
            return true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isIncreasing = false;
                break;
            }else if (array[i] < array[i + 1]) {
                isIncreasing = true;
                break;
            }
        }

        while(k < array.length -1) {
            if(isIncreasing) {
                if (array[k] < array[k + 1]) {
                    k++;
                    isMonotonous = true;
                }else if(array[k] == array[k+1])
                {
                    k++;
                    isMonotonous = true;
                }
                else{
                    isMonotonous = false;
                   break;
                }
            }else
            {
                if(array[k] > array[k+1])
                {
                    k++;
                    isMonotonous = true;
                }else if(array[k] == array[k+1])
                {
                    k++;
                    isMonotonous = true;
                }
                else
                {
                    isMonotonous = false;
                    break;
                }
            }
        }
        return isMonotonous;
    }



    public static boolean isMonotonic1(int[] array) {
        boolean isNonDec = true;
        boolean isNonInc = true;

        for(int i=1; i < array.length;i++)
        {
            if(array[i] < array[i-1])
            {
                isNonDec = false;
            }
            if(array[i] > array[i-1])
            {
                isNonInc = false;
            }
        }
        return isNonDec || isNonInc;
    }

}
