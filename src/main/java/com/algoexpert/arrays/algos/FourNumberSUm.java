package com.algoexpert.arrays.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSUm
{
    public static void main(String[] args) {
        System.out.println(fourNumberSum(new int[]{7,6,4,-1,1,2}, 16));
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum)
    {

        Map<Integer, List<Integer[]>> sumArrMap = new HashMap<>();
        List<Integer[]> quadrupletList = new ArrayList<>();
        for(int i=0; i < array.length -1 ; i++)
        {
            for(int j = i + 1; j < array.length; j++)
            {
                int currentSum = array[i] + array[j];
                int diff = targetSum-currentSum;

                if(sumArrMap.containsKey(diff))
                {
                    for(Integer[] pair: sumArrMap.get(diff))
                    {
                        Integer[] newQuadraplet = {pair[0],pair[1], array[i], array[j] };
                        quadrupletList.add(newQuadraplet);
                    }
                }
            }

            for(int k =0; k < i; k++)
            {
                int currentSum = array[i] + array[k];
                Integer[] pair = {array[i],array[k]};
                if(!sumArrMap.containsKey(currentSum))
                {
                    List<Integer[]> pairGroup = new ArrayList<>();
                    pairGroup.add(pair);
                    sumArrMap.put(currentSum, pairGroup);
                }else
                {
                    sumArrMap.get(currentSum).add(pair);
                }
            }

        }
        return quadrupletList;
    }

}
