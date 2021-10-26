package com.algoexpert.arrays;

public class QuickSort
{
    public static void main(String[] args) {
        int[] arr = quickSort(new int[]{8,5,2,9,5,6,3});
        for(int i: arr)
            System.out.println(i);
    }

    public static int[] quickSort(int[] arr)
    {
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    private static void quickSort(int[] arr, int startidx, int endidx)
    {
        if(startidx >=endidx)
            return;

        int pivotidx = startidx;
        int leftidx = startidx + 1;
        int rightidx = endidx;
        while(rightidx >=leftidx)
        {
            if ((arr[leftidx] > arr[pivotidx]) &&
                    (arr[rightidx] < arr[pivotidx]))
            {
                swap(arr, leftidx, rightidx);
            }
            if(arr[leftidx] <= arr[pivotidx])
            {
                leftidx++;
            }
            if(arr[rightidx] >=arr[pivotidx])
            {
                rightidx--;
            }
        }
        swap(arr, pivotidx,rightidx);
        boolean leftSubArraySmaller = rightidx-1-startidx < endidx-(rightidx+1);
        if(leftSubArraySmaller)
        {
            quickSort(arr, startidx, rightidx-1);
            quickSort(arr, rightidx + 1, endidx);
        }else
        {
            quickSort(arr, rightidx + 1, endidx);
            quickSort(arr, startidx, rightidx-1);
        }
    }

    private static void swap(int[] arr, int leftidx, int rightidx)
    {
        int temp = arr[leftidx];
        arr[leftidx] = arr[rightidx];
        arr[rightidx] = temp;
    }


}
