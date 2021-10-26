package com.algoexpert.Trees.Algos;

import com.algoexpert.Trees.Node;

public class MirrorTree
{
    public static void main(String[] args) {

    }

    static void mirrorTree(Node current)
    {
        if(current == null)
            return;

        if(current.left !=null && current.right != null)
        {
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
            mirrorTree(current.left);
            mirrorTree(current.right);
        }
    }
}
