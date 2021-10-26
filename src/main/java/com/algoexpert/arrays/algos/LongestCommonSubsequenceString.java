package com.algoexpert.arrays.algos;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequenceString
{
/*LOt of duplications in comparison

                        lcs("AXYT", "AYZX")
                       /
         lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
         /                              /
lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
    */
    /* Returns length of LCS for X[0..m-1], Y[0..n-1] *//*

    int lcs(char[] X, char[] Y, int m, int n)
    {
        int L[][] = new int[m + 1][n + 1];

        */
/* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] *//*

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
*/

    /*

    optimal solution here would be

     */

/*    int lcs( char[] X, char[] Y, int m, int n , List<Character> charlist)
    {
        int L[][] = new int[m+1][n+1];

    *//* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] *//*
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1]) {

                    L[i][j] = L[i - 1][j - 1] + 1;
                }
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }*/

    String lcs( char[] X, char[] Y, int m, int n)
    {
        String L[][] = new String[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = "".toString();
                else if (X[i-1] == Y[j-1]) {

                    L[i][j] = L[i - 1][j - 1] + String.valueOf(X[i-1]);
                }
                else
                    L[i][j] = max(String.valueOf(L[i-1][j]), String.valueOf(L[i][j-1]));
            }
        }
        return L[m][n];
    }

    /* Utility function to get max of 2 integers */
    String max(String a, String b)
    {
        return (a.length() > b.length()) ? a : b;
    }

    public static void main(String[] args)
    {
        LongestCommonSubsequenceString lcs = new LongestCommonSubsequenceString();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is"
                + " " + lcs.lcs(X, Y, m, n));

    }

}
