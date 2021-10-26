package com.algoexpert.Trees.Algos;

public class KthSmalleshElementBST
{
    public static void main(String[] args) {

    }

    public int KthSmallestElement(Node root, int k)
    {
        int count = 0;
        int kthElement = 0 ;
         inOrder(root, k , count, kthElement);
         return kthElement;
    }

    private void inOrder(Node root, int k, int count, int kthElement)
    {
        if(root == null)
            return;

        inOrder(root.left, k, count, kthElement);
        count++;
        if(count == k)
        {
            if(root!=null) {
                kthElement = root.data;
                return;
            }
        }
        inOrder(root.right, k, count, kthElement);
    }

}
