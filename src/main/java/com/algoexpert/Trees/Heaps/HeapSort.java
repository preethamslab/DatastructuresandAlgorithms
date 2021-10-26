package com.algoexpert.Trees.Heaps;

public class HeapSort {

    public static void heapSort(int[] arr)
    {
        int length = arr.length;
        // build heap from array
        for(int i=length/2 -1 ; i >=0; i--)
        {
            heapify(arr, length, i);
        }

        for(int i = length-1; i > 0; i--)
        {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,i,0);
        }

    }

    private static void heapify(int[] arr, int length, int i)
    {
        int largest = i;
        int left = (2*i) + 1;
        int right = (2*i) + 2;

        if(left < length && arr[left]> arr[largest])
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

            heapify(arr, length, largest);
        }
    }

    public static void main(String[] args) {
        int arr[] = {8,5,2,9,5,6,3};
        heapSort(arr);
        for(int i: arr)
            System.out.println(i);
    }
}
