package com.algoexpert.Trees.Heaps;

public class HeapTest
{
    public static void main(String[] args) {
        int[] arr  = {8,5,2,9,5,6,3};
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        int length = arr.length;
        for (int i = length/2 - 1; i >=0; i--)
        {
            heapify(i , length ,arr);
        }

        for(int i:arr) {
            System.out.println(i);
        }

        for(int i = length - 1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(0, i,arr);
        }


        System.out.println("=================");

        for(int i:arr) {
            System.out.print(i);
        }


    }

    private static void heapify(int i, int length, int[] arr)
    {
        int largest = i;
        int left = 2 * i +1;
        int right = 2*i + 2;

        if(left < length && arr[left] > arr[largest])
        {
            largest = left;
        }
        if(right < length && arr[right] > arr[largest])
        {
            largest = right;
        }

        if(i!=largest)
        {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(largest, length, arr);
        }
    }
}
