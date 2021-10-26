package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraverse
{
    public static void main(String[] args)
    {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);arr1.add(3);arr1.add(4);arr1.add(10);

        List<Integer> arr2 = new ArrayList<>();
        arr2.add(2);arr2.add(5);arr2.add(9);arr2.add(11);

        List<Integer> arr3 = new ArrayList<>();
        arr3.add(6);arr3.add(8);arr3.add(12);arr3.add(15);

        List<Integer> arr4 = new ArrayList<>();
        arr4.add(7);arr4.add(13);arr4.add(14);arr4.add(16);


        arr.add(arr1);arr.add(arr2);arr.add(arr3);arr.add(arr4);

        zigzagTraverse(arr);
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array)
    {
        int row=0;
        int col=0;
        boolean flip =false;
        List<Integer> arr = new ArrayList<>();
        System.out.println(array.get(row).get(col));
        arr.add(array.get(row).get(col));
        row++;
        whenRowIncreases(row,col,arr,array,flip);

        System.out.println("<><>>>>>>>>>>><<<<<<<<<<<<,");

        for(int i: arr)
        {
            System.out.print(i);
        }
        return arr;
    }

    private static void whenRowIncreases(int row, int col,List<Integer> arr,List<List<Integer>> arrobj
            ,boolean flip)
    {
        System.out.println(arrobj.get(row).get(col));
        arr.add(arrobj.get(row).get(col));
        while(row!=0)
        {
            row--;
            col++;
            System.out.println(arrobj.get(row).get(col));
            arr.add(arrobj.get(row).get(col));
        }

        if(col == arrobj.get(row).size()-1) {
            flip = true;
        }


        if(!flip) {
            col++;
            whenColIncreases(row, col, arr, arrobj,flip);
        }else
        {
            row++;
            whenRowFlipIncreases(row, col,arr, arrobj,flip);
        }

    }



    private static void whenRowFlipIncreases(int row, int col, List<Integer> arr, List<List<Integer>> arrobj
    , boolean flip)
    {
        System.out.println(arrobj.get(row).get(col));
        arr.add(arrobj.get(row).get(col));
        while(row!= arrobj.size()-1)
        {
            row++;
            col--;
            System.out.println(arrobj.get(row).get(col));
            arr.add(arrobj.get(row).get(col));
        }

        if(col < arrobj.get(row).size() -1) {
            col++;
            whenColFLipIncreases(row, col, arr, arrobj, flip);
        }
    }

    private static void whenColFLipIncreases(int row, int col, List<Integer> arr,
                                             List<List<Integer>> arrobj,boolean flip)
    {
        System.out.println(arrobj.get(row).get(col));
        arr.add(arrobj.get(row).get(col));
        while(col!=arrobj.get(row).size()-1)
        {
            row--;
            col++;
            System.out.println(arrobj.get(row).get(col));
            arr.add(arrobj.get(row).get(col));
        }
        row++;
        whenRowFlipIncreases(row,col,arr,arrobj,flip);
    }


    private static void whenColIncreases(int row, int col,
                                         List<Integer> arr,List<List<Integer>> arrobj, boolean flip)
    {
        System.out.println(arrobj.get(row).get(col));
        arr.add(arrobj.get(row).get(col));
        while(col!=0)
        {
            row++;
            col--;
            System.out.println(arrobj.get(row).get(col));
            arr.add(arrobj.get(row).get(col));
        }
        row++;
        whenRowIncreases(row,col,arr, arrobj,flip);
    }


}
