package com.algoexpert;

public class StringPalindrome
{
    public static void main(String[] args) {
        String s1 = "aba";
        StringBuilder sb = new StringBuilder();

        sb.append(s1);

        sb.reverse();
        System.out.println(sb);
        System.out.println(s1.equals(sb.toString()));
    }
}
