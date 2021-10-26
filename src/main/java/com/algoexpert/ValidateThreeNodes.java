package com.algoexpert;

import com.algoexpert.Trees.BinaryTree;
import com.algoexpert.Trees.Node;

import java.util.ArrayList;
import java.util.List;

public class ValidateThreeNodes
{
    BST root;
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }


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


    public void inORder(List<Integer> preorder)
    {
        inOrderRec(root,preorder);
    }

    public void inOrderRec(BST currentNode, List<Integer> preorder)
    {
        if(currentNode!=null)
        {
            System.out.print(currentNode.value + " ");
            preorder.add(currentNode.value);
            inOrderRec(currentNode.left,preorder);

            inOrderRec(currentNode.right,preorder);

        }
    }

    public static void main(String[] args) {
        ValidateThreeNodes bt = new ValidateThreeNodes();
        int[] arr = new int[]{5,2,7,1,4,6,8,0,3};
        for(int i:arr)
        {
            bt.add(i);
        }


    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree)
    {
        if(isDescendant(nodeTwo, nodeOne))
        {
            return isDescendant(nodeThree,nodeTwo);
        }

        if(isDescendant(nodeTwo, nodeThree))
        {
            return isDescendant(nodeOne, nodeTwo);
        }

        return false;
    }

    private boolean isDescendant(BST node, BST targetNode)
    {
        while(node !=null && node !=targetNode)
        {
           node =  (node.value < targetNode.value) ? node.left: node.right;
        }
        return node == targetNode;
    }


}
