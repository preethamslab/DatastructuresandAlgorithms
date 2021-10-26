package com.algoexpert.arrays.algos;

import java.util.*;

public class TopologicalSort
{
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        // Write your code here.

        Map<Integer,List<Integer>> mapper = new HashMap<>();
        LinkedList<Integer> newList = new LinkedList<>();
        for(Integer[] dep: deps)
        {
            if(mapper.containsKey(dep[1])) {
                mapper.get(dep[1]).add(dep[0]);
            }else
            {
                mapper.put(dep[1],new ArrayList<>());
                mapper.get(dep[1]).add(dep[0]);
            }

        }
        for(Integer job : jobs) {
            if(!mapper.containsKey(job)) {
                newList.addFirst(job);
            }
        }

        for(Integer job : jobs) {
            if (mapper.containsKey(job))
            {
                List<Integer> arr = mapper.get(job);
                for (Integer i : arr) {
                    if (!newList.contains(i)) {
                        newList.addLast(i);
                    }
                }
                if(!newList.contains(job))
                    newList.addLast(job);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        List<Integer[]> arr = new ArrayList<>();
        arr.add(new Integer[]{1,2});
        arr.add(new Integer[]{1,3});
        arr.add(new Integer[]{3,2});
        arr.add(new Integer[]{4,2});
        arr.add(new Integer[]{4,3});

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);list.add(4);
        System.out.println(topologicalSort(list, arr));
    }
}
