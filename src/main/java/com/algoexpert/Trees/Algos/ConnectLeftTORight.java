package com.algoexpert.Trees.Algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectLeftTORight {
    class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;

        }
    }

    Node root;

    public void connect(Node root)
    {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        Node temp = null;
        while(!queue.isEmpty())
        {
            int n = queue.size();
            for(int i=0; i< n ; i++)
            {
                Node prev = temp;
            }
        }
    }


}