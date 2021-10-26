package com.algoexpert.linkedlist;

public class ThreeLargestNUmbers
{
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.

        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for(int i:array)
        {
            updateLargest(threeLargest, i);
        }
        return threeLargest;
    }
    public static void updateLargest(int[] arr, int i)
    {
        if(i > arr[2])
        {
            shiftAndUpdate(arr, i,2);
        }else if(i > arr[1])
        {
            shiftAndUpdate(arr,i,1);
        }else if(i > arr[0])
        {
            shiftAndUpdate(arr,i,0);
        }

    }

    public static void shiftAndUpdate(int[] array,int number, int indextoupdate)
    {
        for(int i=0; i<= indextoupdate;i++)
        {
            if(i == indextoupdate)
            {
                array[i] = number;
            }else
            {
                array[i] = array[i+1];
            }
        }
    }

}
