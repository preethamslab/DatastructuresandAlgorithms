package com.algoexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueueWithStacks
{
    public static void main(String[] args)
    {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        System.out.println(queue(new int[]{1,2,4,56,6}, stack1, stack2));
    }

    public static List<Integer> queue(int[] a, Stack<Integer> stack1, Stack<Integer> stack2)
    {

        for(int i:a)
        {
            stack1.add(i);
        }

        while(!stack1.empty())
        {
            int i = stack1.pop();
            stack2.add(i);
        }

        List<Integer> arr = new ArrayList<>();

        while(!stack2.empty())
        {
            int i = stack2.pop();
            arr.add(i);
        }
        return arr;


    }

}
