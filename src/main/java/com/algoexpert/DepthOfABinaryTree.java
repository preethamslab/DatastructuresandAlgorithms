package com.algoexpert;

public class DepthOfABinaryTree
{
    // maximum depth of a binary tree
    Node root;
    class Node
    {
        int value;
        Node left;
        Node right;
       public Node(int value)
        {
            this.value = value;
        }
    }

    public int findHeight(Node current)
    {
        if(current == null)
            return 0;

        return 1+Math.max(findHeight(current.left),findHeight(current.right));
    }

    public void add(int value)
    {
         root = addRecursively(root, value);
    }

    public Node addRecursively(Node current,int value)
    {
        if(current == null)
            return new Node(value);

        if(current.value > value)
        {
            return addRecursively(current.left,value);
        }else if(current.value < value)
        {
            return addRecursively(current.right, value);
        }
        return current;
    }

}
