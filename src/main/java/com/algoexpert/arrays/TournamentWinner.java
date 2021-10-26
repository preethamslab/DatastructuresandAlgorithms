package com.algoexpert.arrays;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class TournamentWinner
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<String>> comp = new ArrayList<>();
        List<String> list1 = new ArrayList<String>();
        list1.add("HTML");
        list1.add("C#");

        List<String> list2 = new ArrayList<String>();
        list2.add("C#");
        list2.add("Python");

        List<String> list3 = new ArrayList<String>();
        list3.add("Python");
        list3.add("HTML");

        comp.add((ArrayList<String>) list1);
        comp.add((ArrayList<String>) list2);
        comp.add((ArrayList<String>) list3);

        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(0);
        res.add(1);
       tournamentWinner(comp, (ArrayList<Integer>) res);

    }

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        if(competitions.size() != results.size())
        {
            return "";
        }

        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i< competitions.size(); i++)
        {
            //System.out.println(competitions.get(i));
            List<String> arr = competitions.get(i);

                //System.out.println(i +" == "+arr.get(1));
                if(0 == results.get(i))
                {
                    if(map.containsKey(arr.get(1)))
                    {
                        map.put(arr.get(1),map.get(arr.get(1))+3);
                    }else
                    {
                        map.put(arr.get(1),3);
                    }
                    System.out.println(arr + " == "+ "results" + results.get(i) +" map "+ map);
                }else if(1 == results.get(i))
                {
                    if(map.containsKey(arr.get(0)))
                    {
                        map.put(arr.get(0),map.get(arr.get(0))+3);
                    }else
                    {
                        map.put(arr.get(0),3);
                    }
                }

        }

        System.out.println(map);
        TreeMap<Integer,String> tmap = new TreeMap<>();
        for(String key: map.keySet())
        {
            tmap.put(map.get(key),key);
        }
        System.out.println(tmap.lastEntry().getValue());
        return tmap.lastEntry().getValue();
    }
}
