package com.algoexpert.arrays;

import java.util.*;

public class Test
{
    public static void main(String[] args) {
/*        Set<Integer> retSet = new TreeSet<>();
        retSet.add(4);
        retSet.add(1);
        retSet.add(10); retSet.add(65); retSet.add(100); retSet.add(12); retSet.add(24);
        System.out.println(retSet);
        System.out.println(retSet.toArray());*/
/*        int i = (3 / 2) + 1;
        System.out.println(i);

        int[] arr = new int[]{1,1,2};
        List<Integer> list = new ArrayList<>();
        for(int k: arr)
            list.add(k);

        System.out.println(majorityElement(list));*/
        int[][] matrix = new int[10][10];
        int[][] copy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
        copy[4][5] = 10;
        boolean check1 = Arrays.deepEquals(matrix, copy);
        System.out.println(check1);
    }

    public static int majorityElement(final List<Integer> A)
    {
        int majority = (A.size()/2) +1 ;

        Map<Integer,Integer> ocMap = new HashMap<Integer,Integer>();
        int majorityEle = 0;

        if(A.size() == 1)
            return A.get(0);

        for(Integer i: A)
        {
            if(ocMap.containsKey(i))
            {
                ocMap.put(i,ocMap.get(i) +1);
                if(ocMap.get(i) >= majority)
                    majorityEle =  i;

            }else{
                ocMap.put(i,1);
            }
        }

        return majorityEle;
    }

/*    public int[] sortedSquaredArray(int[] array) {
        int[] arr = new int[array.length];
        Set<Integer> retSet = new TreeSet<>();
        for(int i=0;i<array.length;i++)
        {
            retSet.add(array[i]*array[i]);
        }
        //Arrays.sort(arr);
        return retSet;
    }
}*/

}
