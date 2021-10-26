package com.algoexpert.Medimdiff;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd
{
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.

        int i=0;
        int j = array.size()-1;

        while(i<j)
        {
            while(i<j && array.get(j) == toMove)
                j--;

            if(array.get(i) == toMove)
                swap(i,j,array);
            i++;
        }
        return array;
    }

    public static void swap(int i, int j,List<Integer> array)
    {
            int temp = array.get(j);
            array.set(j,array.get(i));
            array.set(i,temp);
    }

    public static void main(String[] args)
    {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(2);arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(2);
        System.out.println(arr);
        moveElementToEnd(arr,2);
        System.out.println(arr);
    }
}
