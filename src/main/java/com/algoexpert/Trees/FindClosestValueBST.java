package com.algoexpert.Trees;

public class FindClosestValueBST
{
    public static void main(String[] args) {

    }

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.

        return findClosestNode(tree, target, tree.value);
    }

    private static int findClosestNode(BST tree, int target, int closest)
    {
        while(tree != null)
        {
            if(Math.abs(target-closest) > Math.abs(target-tree.value))
                closest = tree.value;

            if(target > tree.value)
            {
                tree = tree.right;
            }else if(target < tree.value)
            {
                tree = tree.left;
            }
            else{
                break;
            }

        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
