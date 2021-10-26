package com.algoexpert.Trees;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle
{

    public static void main(String[] args) {
        System.out.println(tandemBicycle(new int[]{5,5,3,9,2}, new int[]{3,6,7,2,1}, true));
    }
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if(fastest)
            reverseArray(blueShirtSpeeds);

        int sum =0;
        for(int i = 0 ; i < redShirtSpeeds.length; i++)
        {
            if(redShirtSpeeds[i] >=blueShirtSpeeds[i])
            {
                sum+=redShirtSpeeds[i];
            }else{
                sum+=blueShirtSpeeds[i];
            }
        }
        return sum;
    }


    public static void reverseArray(int[] array)
    {
        int start =0;
        int end = array.length - 1;

        while(start <  end)
        {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
