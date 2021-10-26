package com.algoexpert.search;

public class BubbleSort
{
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        return bubbleSort(array, 0, array.length);

    }

    public static int[] bubbleSort(int[] array,int left, int right)
    {
        if(left > right)
            return new int[]{};

        for(int i=0; i< array.length -1; i++)
        {
            int lval = array[i];
            int rval = array[i+1];

            if(lval > rval)
            {
                array[i+1] = lval;
                array[i] = rval;
            }
        }
        return bubbleSort(array,left, right-1);

    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{5,2,8,5,6,9,3};
        bubbleSort(arr);
        for(int i : arr)
          System.out.println(i);
    }
}
