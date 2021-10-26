package com.algoexpert.search;

public class InsertionSort
{
    public static int[] insertionSort(int[] array)
    {
        if(array.length == 0)
            return new int[]{};

        for(int i=1;i<array.length ;i++)
        {
            int j=i;
            while(j > 0 && array[j] < array[j-1])
            {
                swap(array, j,j-1);
                j-=1;
            }
        }
        return array;
    }

    public static void swap(int[] array, int left, int right)
    {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,5,6,9,3};
        insertionSort(arr);
        for(int i : arr)
            System.out.println(i);
    }
}
