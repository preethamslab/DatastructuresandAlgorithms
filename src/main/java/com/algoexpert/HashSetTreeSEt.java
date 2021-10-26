package com.algoexpert;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class HashSetTreeSEt
{
    public static void main(String[] args) {
        HashSet<String> hset = new HashSet<>();
        hset.add("how");
        hset.add("are");
        hset.add("hi");
        hset.add("aaa");
        hset.add("bbb");
        for(String i: hset)
            System.out.println(i);

        System.out.println("printing tree");
        TreeSet<String> ts = new TreeSet();
        ts.add("how");
        ts.add("are");
        ts.add("hi");
        ts.add("aaa");
        ts.add("bbb");

        for(String i: ts)
            System.out.println(i);

/*        Iterator i = hset.iterator();
        while(i.hasNext()) {
            System.out.println(i);
        }*/
    }
}
