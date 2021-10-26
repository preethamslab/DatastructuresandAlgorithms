package com.algoexpert.arrays.algos;

import java.util.ArrayList;
import java.util.List;

public class GetPermutationNUmbers
{
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permuatations = new ArrayList<>();
        permute(0,array,permuatations);
        return permuatations;

    }
    public static void permute(int i,List<Integer> array,List<List<Integer>> list)
    {
        if(i == array.size()-1)
        {
            list.add(new ArrayList<Integer>(array));
        }else{
            for(int j = i; j < array.size();j++)
            {
                swap(array, i,j);
                permute(i+1,array, list);
                swap(array,i,j);
            }
        }

    }
    public static void swap(List<Integer> arr, int i , int j)
    {
        Integer temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    public static void main(String[] args)
    {
        Integer[] arr = {1,2,3};
        List<Integer> list = new ArrayList<>();
        for(Integer i: arr)
            list.add(i);
        List<List<Integer>> newList = getPermutations(list);
        for(List<Integer> k: newList)
            System.out.println(k);
    }
}
