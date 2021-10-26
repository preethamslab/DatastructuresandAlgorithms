package com.algoexpert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSumRepeat
{
    public static List<List<Integer>> threeNUmberSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();


        Arrays.sort(arr);
        int i =0 ;
        while(i < arr.length)
        {
            int left = i+1;
            int right = arr.length-1;
            while(left < right)
            {
                if(target - (arr[i] + arr[left] + arr[right]) == 0)
                {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    list.add(triplet);
                }
                left++;
                right--;
            }
            i++;
        }
        return list;
    }


    public static void main(String[] args) {
        List<List<Integer>> list =  threeNUmberSum(new int[]{-1,0,1,2,-1,-4}, 0);
        for(List<Integer> i: list)
            System.out.println(i);
    }
}
