package com.algoexpert.arrays;

public class QuickSortTest
{
    public static void main(String[] args)
    {
        int[] arr = {12,11,13,5,6,7};
        quickSort(arr);
        for(int i:arr)
            System.out.println(i);
    }

    private static void quickSort(int[] arr)
    {
        int pivot = arr[0];

        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int left, int right)
    {

        if(left > right)
            return;

        int pivot =left;
        int stidx = pivot+1;
        int endidx = right;

        while(endidx >= stidx)
        {
            if(arr[stidx] > arr[pivot] && arr[endidx] < arr[pivot])
            {
                swap(arr, stidx, endidx);
            }
            if(arr[stidx] < arr[pivot])
            {
                stidx++;
            }
            if(arr[endidx] > arr[pivot])
            {
                endidx--;
            }
        }
        swap(arr, pivot, endidx);

        boolean isLeftSubArrSmaller = endidx - 1 - left < right - (endidx+1);
        if(isLeftSubArrSmaller) {
            quickSort(arr, left, endidx - 1);
            quickSort(arr, endidx + 1, right);
        }else
        {
            quickSort(arr, endidx+1, right);
            quickSort(arr, left, endidx-1);
        }
    }

    public static void swap(int[] arr, int left, int right)
    {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right]=temp;
    }


}
