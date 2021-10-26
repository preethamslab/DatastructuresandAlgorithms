package com.algoexpert.arrays.algos;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PrintAllCombinationsOFSizeK
{
    public static void main(String[] args) {
        kComb(new char[]{'1','2'},4);
    }

    public static void kComb(char[] set, int k)
    {
        int n = set.length;
        Set<char[]> newSEt = new TreeSet<>();
        for(int i = 0; i<=k;i++) {
            getKComb(n, i, set, "");
        }

        for(char[] K:newSEt)
        {
            System.out.println(K);
        }
    }

    private static void getKComb(int n, int k, char[] set, String s)
    {
        if( k == 0) {

            System.out.println(s);
            //newSEt.add(s.toCharArray());
        /*    List<Integer> arr = new ArrayList<>();
            for(int i=0;i < s.toCharArray().length;i++)
            {
                arr.
            }*/
            return;
        }
        for(int i = 0 ; i< n; i++)
        {
            String newPr = s+set[i];
            getKComb(n,k-1,set,newPr);
        }
    }

}
