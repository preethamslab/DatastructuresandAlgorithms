package com.algoexpert.testability;

public class Trees
{
    Node root;
    class Node{
        int value;
        Node left;
        Node right;

       public Node(int value)
        {
            this.value = value;
        }
    }

    public Node addRecursively(Node current, int value)
    {
        if(current == null)
            return new Node(value);

        if(value > current.value) {
            current.right = addRecursively(current.right, value);
        }
        else if(value < current.value) {
            current.left = addRecursively(current.left, value);
        }else{
            return current;
        }
        return current;
    }

    public void add(int value)
    {
        root = addRecursively(root,value);
    }

    public boolean containsNodeRecursive(Node current, int value)
    {
        if(current == null)
            return false;

        if(current.value > value) {
            return containsNodeRecursive(current.left, value);
        }
        else if(current.value < value) {
            return containsNodeRecursive(current.right, value);
        }
        else if(current.value == value) {
            return true;
        }
        return false;
    }

    public boolean containsNode(int value)
    {
        return containsNodeRecursive(root, value);
    }

    public int findSumRecursively(Node current)
    {
        if(current == null)
            return 0;


        return -1;
    }

    public int treeSum()
    {
        return findSumRecursively(root);
    }

    public void traverse()
    {
        traverseRecursively(root);
    }

    private void traverseRecursively(Node current) {
        if(current == null)
            return;

        //System.out.println(current.value);
        traverseRecursively(current.left);
        //System.out.println(current.value);
        traverseRecursively(current.right);System.out.println(current.value);
    }


    public static void main(String[] args) {
        Trees tree = new Trees();
        int[] arr = new int[]{10,11,13,12,8,6,3,2,4,16};
        for(int i:arr)
            tree.add(i);

        System.out.println(tree.containsNode(11));
        tree.traverse();
    }
    /*
    - BFS
    - DFS
    traversals
    - in-order
    - pre-order
    - post-order

     */
}
