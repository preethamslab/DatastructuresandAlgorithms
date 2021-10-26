package com.algoexpert.Trees;

import java.util.ArrayList;
import java.util.List;

public class BranchSums
{

    public static void main(String[] args) {
        /*
        int[] arr = new int[]{1,2,3,6,7,56,23,14,43};
        for(int i:arr)
        {
            bt.add(i);
        }*/
    }
    // O(N) time and O(n) spaces
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> arrSum = new ArrayList<>();

        calculateBranchSum(arrSum, 0, root);

        return arrSum;
    }

    public static void calculateBranchSum(List<Integer> arr, int initSum, BinaryTree current)
    {
        if(current == null)
            return;
        int runningSum = initSum + current.value;

        if(current.left == null && current.right ==null)
        {
            arr.add(runningSum);
        }

        calculateBranchSum(arr, runningSum, current.left);
        calculateBranchSum(arr, runningSum, current.right);

    }
}
