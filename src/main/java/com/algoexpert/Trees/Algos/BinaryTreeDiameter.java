package com.algoexpert.Trees.Algos;

import com.algoexpert.Trees.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDiameter
{
    BinaryTree root;

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

    public TreeInfo getTreeInfo(BinaryTree tree)
    {
        if(tree == null)
            return new TreeInfo(0,0);

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int longestPaththRoot= leftTreeInfo.height + rightTreeInfo.height;
        int maxDiameter = Math.max(leftTreeInfo.diameter , rightTreeInfo.diameter);
        int currentDiater = Math.max(longestPaththRoot, maxDiameter);
        int currentHeight = 1+ Math.max(leftTreeInfo.height, rightTreeInfo.height);

        return new TreeInfo(currentHeight,currentDiater);

    }
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        return getTreeInfo1(tree).isTrue;
    }

    public TreeInfo1 getTreeInfo1(BinaryTree tree)
    {
        if(tree == null)
            return new TreeInfo1(-1, true);

        TreeInfo1 leftTree = getTreeInfo1(tree.left);
        TreeInfo1 rightTree = getTreeInfo1(tree.right);

        boolean isTrue = leftTree.isTrue &&
                rightTree.isTrue &&
                Math.abs(leftTree.height - rightTree.height) <= 1;
        int height = Math.max(leftTree.height, rightTree.height) + 1;

        return new TreeInfo1(height,isTrue);
    }

    public class TreeInfo1
    {
        public int height;
        public boolean isTrue;

        public TreeInfo1(int height,boolean isTrue)
        {
            this.isTrue = isTrue;
            this.height = height;
        }
    }


    public BinaryTree findSuccess(BinaryTree tree)
    {
       return findSuccessor(root, tree);
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        List<Integer> arr = new ArrayList<Integer>();
        arr =  inOrderTraversal(tree, node,arr);
        BinaryTree rettree = null;
        for(int i=0;i<arr.size(); i++)
        {
            System.out.println(arr.get(i));
            if(i == node.value && i != arr.size() -1)
                rettree = new BinaryTree(arr.get(i++));
        }

        return rettree;

    }

    public List<Integer> inOrderTraversal(BinaryTree tree, BinaryTree node, List<Integer> arr)
    {
        if(tree == null)
            return null;

        inOrderTraversal(tree.left, node, arr);
        arr.add(tree.value);
        inOrderTraversal(tree.right, node, arr);

        return arr;
    }

    static class TreeInfo{
        public int diameter;
        public int height;

        public TreeInfo(int height, int diameter)
        {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public int binaryTreeDiameter() {
        // Write your code here.
        return getTreeInfo(root).diameter;
    }

    public static void main(String[] args) {
        BinaryTreeDiameter bt = new BinaryTreeDiameter();
        int[] arr = new int[]{1,2};
        for(int i:arr)
        {
            bt.add(i);
        }

       // System.out.println(bt.binaryTreeDiameter());
        BinaryTree val = bt.findSuccess(new BinaryTree(2));
        System.out.println(val == null ? null: val.value);

    }

}
