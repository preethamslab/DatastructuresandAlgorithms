package com.algoexpert.arrays.algos;

import java.util.ArrayList;
import java.util.List;

public class TestClass
{
    public static void main(String[] args) {
/*        char c = ' ';
        char d = 'c';

        System.out.println(c+d);*/

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);


        System.out.println(l1.equals(l2));
    }
}
