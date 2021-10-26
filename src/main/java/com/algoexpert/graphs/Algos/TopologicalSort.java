package com.algoexpert.graphs.Algos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort
{
    /*

     */

    static class Graph{
        private int V;

        private ArrayList<ArrayList<Integer>> adj;

        Graph(int v)
        {
            V= v;
            adj = new ArrayList<ArrayList<Integer>>();
            for(int i =0 ; i < v; ++i)
            {
                adj.add(new ArrayList<Integer>());
            }
        }

        void addEdge(int v, int w)
        {
            adj.get(v).add(w);
        }

        void topologicalUtil(int v, boolean visited[], Stack<Integer> stack)
        {
            visited[v] = true;
            Integer i;

            Iterator<Integer> it = adj.get(v).iterator();
            while(it.hasNext())
            {
                i = it.next();
                if(!visited[i])
                    topologicalUtil(i,visited, stack);
            }

            stack.push(v);
        }

        void topologicalSort()
        {
            Stack<Integer> stack = new Stack<>();
            boolean visited[] = new boolean[V];
            for(int i = 0; i < visited.length;i++)
            {
                visited[i] = false;
            }

            for(int i=0; i<V;i++)
            {
                if(visited[i] == false)
                    topologicalUtil(i, visited, stack);
            }
            while(stack.empty() == false)
                System.out.println(stack.pop()+ " " );
        }

    }

    // Driver code
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }

}
