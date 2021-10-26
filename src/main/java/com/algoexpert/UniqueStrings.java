package com.algoexpert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UniqueStrings
{
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();

        a.add("a");
        a.add("b");
        a.add("c");
        a.add("a");

        ArrayList<String> answer = new ArrayList<>(new HashSet<>(a));
        System.out.println(answer);

    }
}
