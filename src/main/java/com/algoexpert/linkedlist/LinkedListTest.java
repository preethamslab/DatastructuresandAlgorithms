package com.algoexpert.linkedlist;

import java.util.LinkedList;

public class LinkedListTest
{
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add("E");
        ll.add("F");
        ll.addFirst("z");
        ll.addLast("K");
        ll.add(4,"M");
        System.out.println(ll);
        ll.remove("z");
        System.out.println(ll);
        ll.remove(4);
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);


    }
}
