package com.algoexpert.arrays.algos;

import java.util.*;

public class TaskAssignment
{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] data = new Integer[]{1,1,1,1,1,1,1,1,1,1};
        System.out.println(data.length);
        for(Integer i:data)
            list.add(i);

        ArrayList<ArrayList<Integer>> finallist = taskAssignment(5, list);
        for(ArrayList<Integer> i: finallist)
        {
            System.out.println(i);
        }
    }
// My Solution
    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Map<Integer,List<Integer>> posMap = new HashMap<>();
        getMap(tasks, posMap);
        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);
        for(int i = 0; i < k; i++)
        {
            int task1Duration =sortedTasks.get(i);
            List<Integer> indicesWithTaskDuration = posMap.get(task1Duration);
            int task1Index = indicesWithTaskDuration.remove(indicesWithTaskDuration.size()-1);

            int tasks2SortedIndex = tasks.size()-1-i;
            int task2Duration = sortedTasks.get(tasks2SortedIndex);

            List<Integer> indicesWithTask2Duration = posMap.get(task2Duration);
            int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1);

            ArrayList<Integer> subList = new ArrayList<>();
            subList.add(task1Index);
            subList.add(task2Index);
            list.add(subList);
        }
        //getPositionListFromMap(list,posMap);
        return list;
    }

    private static void getPositionListFromMap(ArrayList<ArrayList<Integer>> masterList, Map<Integer, List<Integer>> posMap)
    {
        ArrayList<ArrayList<Integer>> newmasterList = new ArrayList<>();
        for(ArrayList<Integer> list : masterList)
        {
            ArrayList<Integer> newList = new ArrayList<>();
            if(posMap.containsKey(list.get(0)))
            {

            }
        }
    }


    private static void getMap(ArrayList<Integer> tasks, Map<Integer, List<Integer>> posMap)
    {
        for(int i=0;i<tasks.size();i++)
        {
            if(posMap.containsKey(tasks.get(i)))
            {
                posMap.get(tasks.get(i)).add(i);
            }else
            {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                posMap.put(tasks.get(i),list);
            }
        }
    }

}
