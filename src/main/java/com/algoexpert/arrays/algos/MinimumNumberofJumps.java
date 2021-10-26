package com.algoexpert.arrays.algos;

import java.util.Arrays;

public class MinimumNumberofJumps
{
    public static void main(String[] args) {
        System.out.println(minNumberOfJumps(new int[]{3,1}));
    }

    public static int minNumberOfJumps(int[] array)
    {
     if(array.length == 1)
         return 0;

     int jumps =0;
     int maxReach = array[0];
     int steps = array[0];

     for(int i=1; i<array.length; i++)
     {
         maxReach = Math.max(maxReach, i+ array[i]);
         steps--;
         if(steps == 0) {
             jumps++;
             steps = maxReach - i;
         }
     }
     return jumps +1;
    }
/* my solution
    public static int minNumberOfJumps(int[] array) {
        // Write your code here.
        //int[] arrayCopy = array;
        Arrays.sort(array);

        int maxJump = array[array.length - 1];


        return array.length-maxJump;
    }*/

}
