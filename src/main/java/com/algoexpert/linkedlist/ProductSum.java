package com.algoexpert.linkedlist;

import java.util.Arrays;
import java.util.List;

public class ProductSum
{
    public static int productSum(List<Object> array) {
        // Write your code here
        int sum=0;
        for(int i=0;i<array.size();i++) {
                findSum(array.get(i),sum,2);
        }
        return -1;
    }

    public static int findSum(Object obj, int sum,int weight)
    {

        if(obj.getClass().isArray())
        {
            for(int  i = 0;i < ((List<Object>) obj).size() ; i++)
            {
                if(((List<?>) obj).get(i).getClass().isArray() ) {
                    findSum(((List<?>) obj).get(i), sum, weight);
                }
                else
                {

                }
            }
        }else
        {
            sum += (Integer) obj;
        }
        return sum;
    }



}
