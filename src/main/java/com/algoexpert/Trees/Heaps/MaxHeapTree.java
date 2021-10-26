package com.algoexpert.Trees.Heaps;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MaxHeapTree
{

    /*
        Max Heap tree generally represented in array.
        [9,8,6,5,2,1]

        Arr[0] represents the root

        arr[(i-1) /2 ] represent the parent node
        arr[2i + 1] represents the left node
        arr[2i + 2] represents the right node
     */
    public static void main(String[] args)
    {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());

        pqueue.add(9);
        pqueue.add(8);
        pqueue.add(6);
        pqueue.add(5);
        pqueue.add(2);
        pqueue.add(1);


        Iterator iterator = pqueue.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        //int i = pqueue.remove();

        System.out.println("=================");

        while(!pqueue.isEmpty())
        {
            System.out.println(pqueue.remove());
        }

        /*
        Iterator iterator1 = pqueue.iterator();
        while(iterator1.hasNext())
        {
            System.out.print(iterator1.next()+" , ");
        }

        System.out.println("contains 8 "+ pqueue.contains(8));
        */
        Object[] arr = pqueue.toArray();

        for(Object k: arr)
        {
            System.out.print(k + " , " );
        }

    }
}
