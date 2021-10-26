package com.algoexpert.graphs.Algos;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch
{
   static class Graph
    {
        int length;
        LinkedList<Integer> adj[];
        Graph(int v){
            this.length =v;
            adj= new LinkedList[length];
            for(int i=0; i< length;i++)
            {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int u, int v)
        {
            adj[u].add(v);
        }


        void bfs(int v)
        {
            boolean visited[] = new boolean[length];
            for(int i=0; i < length; i++) {
                visited[i] = false;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);

            while(queue.size() !=0)
            {
                v = queue.poll();
                System.out.println(v+ " ");
                Iterator<Integer> it = adj[v].iterator();
                while(it.hasNext())
                {
                    int  n = it.next();
                    if(!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }


    }

    // Driver method to
    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
    }
}
