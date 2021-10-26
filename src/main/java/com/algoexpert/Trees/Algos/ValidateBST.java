/*
package com.algoexpert.Trees.Algos;

import com.algoexpert.Trees.Node;

public class ValidateBST
{
    public static boolean validateBst(BST currentNode)
    // Write your code here.
    {
        if(currentNode == null)
        return true;

		if(currentNode.value > currentNode.right.value)
        {
            return validateBst(currentNode.right);
        }
		else if(currentNode.value < currentNode.left.value)
        {
            return validateBst(currentNode.left);
        }
		else{
            return false;
            }
    }

    public static boolean validateBst1(BST currentNode)
    {  // Write your code here.

        return validateBST1(currentNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBST1(BST currentNode, int minValue, int maxValue) {
        if(currentNode.value  < minValue || currentNode.value > maxValue)
            return false;

        if(currentNode.right !=null && !validateBST1(currentNode.right, minValue, currentNode.value))
        {
            return false;
        }
        if(currentNode.left !=null && !validateBST1(currentNode.left, currentNode.value, maxValue))
        {
            return false;
        }
        return true;
    }


    static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

        Node root;
        private BST addRecursive(BST current, int value)
        {
            if(current == null)
            {
                return new BST(value);
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
}

    public static void main(String[] args) {

        int[] arr = new int[]{50,30,20,40,70,60,80,78,90};
        for(int i:arr)
        {
           add(i);
        }
    }

}
*/
