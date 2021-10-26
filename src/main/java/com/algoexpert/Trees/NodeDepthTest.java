package com.algoexpert.Trees;

class NodeDepthTest {

    public static int nodeDepths(BinaryTree root)
    {
        int sum = 0;
        return recursiveDepths(root,sum);
    }

    private static int recursiveDepths(BinaryTree current, int sum)
    {
        if(current == null)
            return 0;

        return sum + recursiveDepths(current.left, sum + 1) + recursiveDepths(current.right, sum+1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
