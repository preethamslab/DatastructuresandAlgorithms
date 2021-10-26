package com.algoexpert.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        List<Integer> l = new ArrayList<Integer>();
        for(Integer i:arr)
            l.add(i);
        List<List<Integer>> list = powerset(l);
        for(List<Integer> k : list)
            System.out.println(k);
    }


    public static List<List<Integer>> powerset(List<Integer> array)
    {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(Integer ele: array)
        {
            int length = subsets.size();
            for(int i=0;i<length;i++) {
                System.out.println(subsets.size());
                List<Integer> curSubset = new ArrayList<>(subsets.get(i));
                curSubset.add(ele);
                subsets.add(curSubset);
            }
        }
        return subsets;
    }

/*    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> powerSet = new ArrayList<>();

        for(int i = 0 ; i < array.size(); i++)
        {
            if(i == 0)
            {
                powerSet.add(new ArrayList<>());
                continue;
            }

            if(i == array.size()-1)
            {
                powerSet.add(array);
                continue;
            }
            getPowerSet(i,array, array.size(),powerSet, new ArrayList<Integer>());
        }
        return powerSet;
    }

    public static void getPowerSet(int currentSize, List<Integer> array, int size,
                                   List<List<Integer>> powerSet, List<Integer> temp)
    {
        if(currentSize == 0 )
        {
            powerSet.add(temp);
            return;
        }

        for(int j = 0 ; j < array.size(); j++)
        {
            temp.add(array.get(j));
        }
        getPowerSet(currentSize-1, array, size, powerSet, temp);
    }*/
}
