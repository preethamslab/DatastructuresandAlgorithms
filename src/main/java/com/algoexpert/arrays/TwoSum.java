package com.algoexpert.arrays;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
    public static void main(String[] args) {
        System.out.println(twoNumberSum(new int[]{-21, 301, 12, 4, 65, 56, 210, 356, 9, -47},164));
    }
    // O(n2) time and space O(1)
   /* public static int[] twoNumberSum(int[] array, int targetSum)
    {
        int arr[] = new int[0];
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length; j++)
            {
                if (i == j)
                    continue;
                if (array[i] + array[j] == targetSum)
                {
                    arr = new int[2];
                    arr[0] = array[i];
                    arr[1] = array[j];
                }

            }
        }
      return arr;
    }*/
        // hashset solution, O(n) Time and O(n) space
/*    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num: array)
        {
            int potmatch = targetSum-num;
            if(set.contains(potmatch))
            {
                return new int[]{num, potmatch};
            }
            {
                set.add(num);
            }
        }
        return new int[0];
    }*/

    // two pointer solution , O(nLOgn time and O(1) space)
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int right = array.length-1;
        int left = 0;
        while(left < right)
        {
            int sum = array[left] + array[right];
            if(targetSum == sum)
            {
                return new int[] {array[left], array[right]};
            }
            else if(sum < targetSum)
            {
                left++;
            }else if(sum > targetSum){
                right--;
            }
        }
        return new int[0];
    }
}
