package com.algoexpert.strings;

public class TestKMP
{
    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new TestKMP().KMPSearch(pat, txt);
    }

    void KMPSearch(String pat, String txt)
    {
        int m = pat.length();
        int n = txt.length();

        int[] lps = new int[m];

        getLPS(m,lps,pat);
        int i = 0;
        int j =0;
        while(i < n)
        {
            if(pat.charAt(j) == txt.charAt(i))
            {
                i++;
                j++;
            }
            if(j == m)
            {
                System.out.println("subsequence is found at "+ (i - j));
                j = lps[j-1];
            }else if(i < n && pat.charAt(j) != txt.charAt(i))
            {
                if(j!=0)
                    j = lps[j-1];
                else
                    i = i+1;
            }

        }

    }

    private void getLPS(int m, int[] lps, String pat)
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while(i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0 )
                {
                    len = lps[len-1];
                }else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
