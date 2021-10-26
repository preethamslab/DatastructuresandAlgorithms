package com.algoexpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SameBST
{
    public static void main(String[] args)
    {

        int[] arrpne = {10, 15, 8, 12, 94, 81, 5, 2, 11};
        int[] arrtwo = {10, 8, 5, 15, 2, 12, 11, 94, 81};



        List<Integer> listone = new ArrayList<>();
        for(int i: arrpne)
            listone.add(i);



        List<Integer> listtwo = new ArrayList<>();
        for(int i: arrtwo)
            listtwo.add(i);


        for(Integer i: listone)
            System.out.println(i);

        System.out.println("+++++++++++++++++====");
        for(Integer i: listtwo)
            System.out.println(i);


        System.out.println(sameBsts(listone,listtwo));
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.

        if(arrayOne.size()  != arrayTwo.size())
            return false;

        if(arrayOne.size() ==0 &&   arrayTwo.size() == 0)
            return true;

        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue())
            return false;

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOREqualOne = getEqualOrGreat(arrayOne);
        List<Integer> rightorEqualtwo = getEqualOrGreat(arrayTwo);
        return sameBsts(leftOne,leftTwo) && sameBsts(rightOREqualOne,rightorEqualtwo);
    }

    private static List<Integer> getEqualOrGreat(List<Integer> arrayTwo)
    {
        List<Integer> list = new ArrayList<>();

        for(int i=1;i<arrayTwo.size();i++)
        {
            if(arrayTwo.get(0) <= arrayTwo.get(i))
                list.add(arrayTwo.get(i));
        }
        return list;
    }

    private static List<Integer> getSmaller(List<Integer> arrayOne)
    {
        List<Integer> list = new ArrayList<>();

        for(int i=1;i<arrayOne.size();i++)
        {
            if(arrayOne.get(0) > arrayOne.get(i))
                list.add(arrayOne.get(i));
        }
        return list;
    }


}
