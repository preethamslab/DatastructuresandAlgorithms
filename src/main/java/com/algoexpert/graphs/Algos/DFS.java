package com.algoexpert.graphs.Algos;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS
{
    static class Graph{
        int V;
        LinkedList<Integer> adj[];

        Graph(int v){
            this.V=v;
            adj = new LinkedList[V];
            for(int i=0; i < V; ++i)
            {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int u, int v)
        {
            adj[u].add(v);
        }

        void DFS(int v)
        {
            boolean[] visited = new boolean[V];

            DFSUtil(v, visited);
        }

        void DFSUtil(int v, boolean[] visited)
        {
            visited[v] = true;
            System.out.print(v + " ");

            Iterator<Integer> it = adj[v].iterator();
            while(it.hasNext())
            {
                int n = it.next();

                while(!visited[n])
                {
                    DFSUtil(n,visited);
                }
            }

        }
    }

    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(2);
    }
}
