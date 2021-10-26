package com.algoexpert.arrays.algos;

public class LavenshteinDistance
{
    public static void main(String[] args) {
        System.out.println(levenshteinDistance("biting","mitten"));
    }

    public static int levenshteinDistance(String str1, String str2)
    {
        int dist = 0;
        int idstr2 = 0;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        if(arr1.length == 0)
            return arr2.length;

        while(idstr2 < arr2.length)
        {
            boolean charFound =false;
            for(int i=0;i < arr1.length;i++)
            {
                if(arr2[idstr2] == arr1[i])
                {
                    charFound = true;
                }
            }
            if(charFound)
                dist++;
            idstr2++;
        }
        return str2.toCharArray().length-dist;
    }

}
