package com.algoexpert.Trees.Algos;

public class MaximumSumOfNonAdjacentNodes
{

    // Java program to find maximum sum in Binary Tree
// such that no two nodes are adjacent.

        public static Pair maxSumHelper(Node root)
        {
            if (root==null)
            {
                Pair sum=new Pair(0, 0);
                return sum;
            }
            Pair sum1 = maxSumHelper(root.left);
            Pair sum2 = maxSumHelper(root.right);
            Pair sum=new Pair(0,0);

            // This node is included (Left and right children
            // are not included)
            sum.first = sum1.second + sum2.second + root.data;

            // This node is excluded (Either left or right
            // child is included)
            sum.second = Math.max(sum1.first, sum1.second) +
                    Math.max(sum2.first, sum2.second);
            System.out.println("Sum for "+ sum.first + " & "+ sum.second + " for node "+root.data);
            return sum;
        }

        // Returns maximum sum from subset of nodes
        // of binary tree under given constraints
        public static int maxSum(Node root)
        {
            Pair res=maxSumHelper(root);
            return Math.max(res.first, res.second);
        }

        public static void main(String args[]) {
            Node root= new Node(10);
            root.left= new Node(1);
            root.left.left= new Node(2);
            root.left.left.left= new Node(1);
            root.left.right= new Node(3);
            root.left.right.left= new Node(4);
            root.left.right.right= new Node(5);
            System.out.print(maxSum(root));
        }
    }

    /* A binary tree node structure */
    class Node
    {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    };

    /* Pair class */
    class Pair
    {
        int first,second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
//This code is contributed by Gaurav Tiwari


/*    static int getMaxSum(Node current, int sum)
    {
        if(current == null)
            return 0;
        if(current.left != null || current.right != null)
        {
            if(current.left.value > current.value)
            {
                sum +=current.left.value;

            }else if(current.right .value > current.value)
            {
                sum +=current.right.value;
            }else
            {
                sum +=current.value;
            }
            getMaxSum(current.left,sum);
            getMaxSum(current.right, sum);
        }
        return sum;
    }*/


    /*
    get maximum sum of children
    get maximum sum of grandChildren with root
     */


