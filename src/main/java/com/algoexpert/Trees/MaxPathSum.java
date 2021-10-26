package com.algoexpert.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPathSum
{
    public static int maxPathSum(BinaryTree tree) {
        List<Integer> maxSumArray = findMaxSUm(tree);
        return maxSumArray.get(1);

    }

    private static List<Integer> findMaxSUm(BinaryTree tree)
    {
        if(tree == null)
            return new ArrayList<>(Arrays.asList(0, Integer.MIN_VALUE));

        List<Integer> leftMaxArray = findMaxSUm(tree.left);
        int leftMaxSumAsBranch = leftMaxArray.get(0);
        int leftMaxSumasPath = leftMaxArray.get(1);

        List<Integer> rightMaxArray = findMaxSUm(tree.right);
        int rightMaxSumAsBranch = rightMaxArray.get(0);
        int rightMaxSumAsPath= rightMaxArray.get(1);

        int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch,rightMaxSumAsBranch);
        int maxSumBranch = Math.max(maxChildSumAsBranch+tree.value, tree.value);
        int maxSumAsRootNode = Math.max(tree.value+leftMaxSumAsBranch+rightMaxSumAsBranch, maxSumBranch);
        int maxSumAsPath = Math.max(leftMaxSumasPath, Math.max(maxSumAsRootNode, rightMaxSumAsPath));

        return new ArrayList<>(Arrays.asList(maxSumBranch, maxSumAsPath));
    }

    static BinaryTree root;
    private BinaryTree addRecursive(BinaryTree current, int value)
    {
        if(current == null)
        {
            return new BinaryTree(value);
        }
        if(value < current.value)
        {
            current.left = addRecursive(current.left, value);
        }else if(value > current.value)
        {
            current.right = addRecursive(current.right, value);
        }else
        {
            return current;
        }
        return current;
    }

    public void add(int value)
    {
        root = addRecursive(root,value);
    }

    public static Integer findMax()
    {
        return maxPathSum(root);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MaxPathSum bt = new MaxPathSum();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        for(int i:arr)
            bt.add(i);

        System.out.println(findMax());
    }
}
