package com.algoexpert;

public class MergeSort
{
    public static void main(String[] args) {
        int[] arr = new int[]{19,34,12,3,4,5};
        System.out.println("given array");
        for(int i:arr)
            System.out.println(i);

        MergeSort ms = new MergeSort();
        ms.sort(arr, arr.length, 0);

        System.out.println("new array");
        for(int i:arr)
            System.out.println(i);
    }

    private void sort(int[] arr, int right, int left)
    {
        if(left < right) {
            int mid = left + (right - left) / 2;

            sort(arr,left, mid);
            sort(arr,mid+1,right);

            merge(arr, right, left,mid);
        }
    }

    private void merge(int[] arr, int right, int left, int mid)
    {
        int[] l = new int[mid-left+1];
        int[] r = new int[right-mid];

        for(int i = 0 ; i < mid-left + 1; ++i)
            l[i] = arr[left+i];

        for(int i = 0; i < right - mid - 1;++i)
            r[i] = arr[mid+1+i];


        int i =0 ,j =0 ;
        int k = left;

        while(i < (mid-left) && j < (right-mid+1))
        {

                if(l[i] < r[j])
                {
                    arr[k] = l[i];
                    i++;
                }else
                {
                    arr[k] = l[j];
                    j++;
                }
            k++;
        }

        while(i < mid-left+ 1)
        {
            arr[k] = l[i];
            i++;
            k++;
        }

        while(j < right-mid)
        {
            arr[k] = r[j];
            j++;
            k++;
        }
    }
}
