package com.algoexpert.questions;

import java.util.*;

public class ThreeNumerSum
{
    public static void main(String[] args) {
        List<Integer[]> arrlist = threeNumberSum(new int[]{12,3,1,2,-6,5,-8,6}, 0);
         for(Integer[]  arr : arrlist)
         {
             System.out.println(arr[0] + " " +arr[1] + " "+arr[2]);
         }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List<Integer[]> listArr = new ArrayList<>();


            for(int i=0; i < array.length - 1; i++)
            {
                int left = i+1;
                int right = array.length - 1;
                while(left < right)
                {
                    int cuSum = array[i] + array[left] + array[right];
                    if(cuSum == targetSum)
                    {
                        Integer[] newtrip = {array[i],array[left], array[right]};
                        listArr.add(newtrip);
                        left++;
                        right--;
                    }
                    else if(cuSum < targetSum)
                    {
                        left++;
                    }else if(cuSum > targetSum)
                    {
                        right--;
                    }

                }
            }


    return listArr;
    }
}
