package com.algoexpert.Trees;

import java.io.PrintStream;

public class BinaryTree
{
    Node root;
    private Node addRecursive(Node current, int value)
    {
        if(current == null)
        {
            return new Node(value);
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

    private boolean containsNodeRecursive(Node current, int value)
    {
        if(current == null)
        {
            return false;
        }
        if(current.value > value)
        {
            return containsNodeRecursive(current.left,value);
        }else if(current.value < value)
        {
            return containsNodeRecursive(current.right,value);
        }else if(current.value == value)
        {
            return true;
        }
        return false;
    }

    public boolean containsNode(int value)
    {
        return containsNodeRecursive(root, value);
    }


    private int treeSum(Node current)
    {
        if(current ==null)
        {
            return 0;
        }
        else
        {
            return current.value + treeSum(current.left)+ treeSum(current.right);
        }
    }
    public int totalSum()
    {
        return treeSum(root);
    }

    public int findMax()
    {
        return treeMax(root);
    }

    private int treeMax(Node current)
    {
        if(current == null)
        {
            return 0;
        }
        else{
            return max(current.value, treeMax(current.left), treeMax(current.right));
        }
    }

    private int max(int value1,int value2, int value3 )
    {
     if(value1 > value2 && value1 > value3 )
         return value1;
     if(value2 > value1 && value2 > value3)
         return value2;
     if(value3 > value1 && value3 > value2)
         return value3;

     return 0;
    }

    public int findHt()
    {
        return treeHeight(root);
    }

    private int treeHeight(Node current)
    {
        if(current == null)
            return 0;
        return 1+max(treeHeight(current.left), treeHeight(current.right));
    }

    private int max(int val1,int val2)
    {
        if(val1 > val2)
            return val1;
        return val2;
    }

    public void remove(int value)
    {
        removeRecursively(root,value);
    }

    public Node removeRecursively(Node currentNode,int value)
    {
        if(currentNode == null)
        {
            return currentNode;
        }

        if(value < currentNode.value)
        {
            currentNode.left = removeRecursively(currentNode.left, value);
        }else if (value > currentNode.value){
            currentNode.right = removeRecursively(currentNode.right, value);
        }
        else{
            if(currentNode.left == null)
                return currentNode.right;
            else if(currentNode.right == null)
                return currentNode.left;

            currentNode.value = minValue(root.right);
            currentNode.right = removeRecursively(currentNode.right, currentNode.value);
        }
        return currentNode;
    }

    public Node delete(int value)
    {
       return deleteNode(root, value);
    }

    public Node deleteNode(Node currentNode, int value)
    {
        if(currentNode == null)
            return currentNode;

        if(currentNode.value > value)
        {
            currentNode.left = deleteNode(currentNode.left, value);
            return currentNode;
        }else if(currentNode.value < value)
        {
            currentNode.right = deleteNode(currentNode.right, value);
            return currentNode;
        }

        if(currentNode.left == null)
        {
            Node temp = currentNode.right;
            return temp;
        }else if(currentNode.right == null)
        {
            Node temp = currentNode.right;
            return temp;
        }
        else{
            Node succParent = currentNode;
            Node succ = currentNode.right;
            while(succ.left !=null)
            {
                succParent = succ;
                succ = succ.left;
            }

            if(succParent != currentNode)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            currentNode.value = succ.value;
            return currentNode;
        }
    }

    //Function to count number of nodes in BST that lie in the given range.

    int getCount(int l,int h)
    {
        return getCount(root, l , h);
    }

    static int getCount(Node current, int l, int h)
    {
        //Your code here


        return getCountRec(current, l,h);

    }

    static int getCountRec(Node node, int low, int high) {
        if (node == null)
            return 0;


        // If current node is in range, then
        // include it in count and recur for
        // left and right children of it
        if(node.value >= low && node.value <= high)
            return 1 + getCountRec(node.left, low, high)+
                    getCountRec(node.right, low, high);

            // If current node is smaller than low,
            // then recur for right child
        else if(node.value < low)
            return getCountRec(node.right, low, high);

            // Else recur for left child
        else
            return getCountRec(node.left, low, high);
    }

    int minValue(Node root)
    {
        int minv = root.value;
        while (root.left != null)
        {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    public void revTree()
    {
        treeReverse(root);
    }

    private void treeReverse(Node current)
    {
        if(current == null)
            return;
        treeReverse(current.left);
        treeReverse(current.right);

        current.left =current.right;
        current.right = current.left;
    }

    public void inORder()
    {
        inOrderRec(root);
    }

    public void inOrderRec(Node currentNode)
    {
        if(currentNode!=null)
        {
            inOrderRec(currentNode.left);
            System.out.print(currentNode.value + " ");
            inOrderRec(currentNode.right);
        }
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] arr = new int[]{50,30,20,40,70,60,80,78,90};
        for(int i:arr)
        {
            bt.add(i);
        }

      System.out.println(bt.containsNode(6));
        System.out.println(bt.totalSum());
        System.out.println(bt.findMax());
        System.out.println(bt.findHt());
       // bt.revTree();

        bt.inORder();

       // bt.remove(50);

        System.out.println();
        bt.delete(70);
        bt.inORder();

        System.out.println(bt.getCount(10,50));
    }

}
