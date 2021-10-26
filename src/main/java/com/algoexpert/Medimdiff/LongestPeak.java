package com.algoexpert.Medimdiff;

public class LongestPeak
{
    public static int longestPeak(int[] array) {
        // Write your code here.
        int peak = 0;

        int left = 0;
        int right = 1;

        if(array.length < 2)
            return 0;

        while(right < array.length -1 )
        {
            int localPeak = 0;
            if(array[right] > array[left] && array[right] > array[right+1])
            {
                int peakVal = array[right];
                System.out.println(peakVal);
                for(int i = right; i< array.length -1; i++)
                {
                    if(peakVal< array[i+1])
                        break;
                    else if(peakVal > array[i+1])
                        localPeak++;
                }
                if(localPeak > peak)
                    peak = localPeak;
            }
            left++;
            right++;
        }

        return peak;
    }

    public static void main(String[] args) {
       // System.out.println(longestPeak(new int[]{1,2,3,3,4,0,10,6,5,-1,-3,2,3}));
        System.out.println(longestPeak(new int[]{1,3,2}));
    }
}
