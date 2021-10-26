package com.algoexpert.search;

public class SelectionSortTest
{
     // O(n^2) time, space O(1)

    public static int[] selectionSort(int[] array) {
        // Write your code here.

        if(array.length == 0)
            return new int[]{};
        int idx = 0;
        while(idx < array.length - 1)
        {
         int smallIdx = idx;
         for(int i=idx+1; i < array.length;i++)
         {
            if(array[smallIdx] > array[i])
            {
                smallIdx = i;
            }
         }
         swap(idx, smallIdx, array);
         idx++;
        }

        return array;
    }

    public static void swap(int idx, int id, int[] array)
    {
        int temp = array[idx];
        array[idx] = array[id];
        array[id] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,5,6,9,3};
        selectionSort(arr);
        for(int i : arr)
            System.out.println(i);
    }

}
