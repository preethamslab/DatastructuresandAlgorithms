package com.algoexpert.graphs.Algos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS
{
    public static void main(String[] args) {
        /*        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }*/

        Stack<Integer>  stack = new Stack<>();

        stack.add(10);
        stack.add(40);stack.add(30);stack.add(20);

        while(!stack.empty())
        {
            System.out.println(stack.pop());
        }

    }


}
