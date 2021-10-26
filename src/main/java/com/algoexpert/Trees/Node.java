package com.algoexpert.Trees;

public class Node
{
    public Node left;
    public Node right;
    public int value;
    public Node(int val)
    {
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
