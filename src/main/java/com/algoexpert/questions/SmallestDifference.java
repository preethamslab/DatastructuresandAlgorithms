package com.algoexpert.questions;

import java.util.Arrays;

public class SmallestDifference
{
    public static void main(String[] args) {
        int[] arr = smallestDifference(new int[]{-1,5,10,20,28,3},new int[]{26,134,135,15,17});
        System.out.println(arr[0] + " " +arr[1]);
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int idxone=0;
        int idxtwo=0;

        int smallest = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;

        int[] smallPair= new int[2];
        while(idxone < arrayOne.length && idxtwo < arrayTwo.length)
        {
            int fnum = arrayOne[idxone];
            int snum = arrayTwo[idxtwo];

            if(fnum < snum)
            {
                current = snum -fnum;
                idxone++;
            }else if(fnum > snum)
            {
                current = fnum - snum;
                idxtwo++;
            }else{
                return new int[] {fnum,snum};
            }

            if(smallest > current)
            {
                smallest = current;
                smallPair = new int[]{fnum,snum};
            }
        }
        return smallPair;
    }
}
