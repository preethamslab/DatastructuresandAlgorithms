package com.algoexpert.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedGraph
{
    static class Edge{
        int s,d;

        Edge(int s, int d)
        {
            this.s = s;
            this.d = d;
        }
    }

    static class Graph
    {
        List<List<Integer>> adjList = new ArrayList<>();

        public Graph(List<Edge> edges)
        {
            int n=0;
            for(Edge e: edges)
            {
                n = Integer.max(n, Integer.max(e.s, e.d));
            }

            for(int i=0; i <=n; i++)
            {
                adjList.add(i, new ArrayList<>());
            }

            for (Edge current: edges)
            {
                adjList.get(current.s).add(current.d);
            }
        }
        public static void showGraph(Graph graph)
        {
            int s =0;

            int n = graph.adjList.size();
            while(s<n)
            {
                for(int d: graph.adjList.get(s))
                {
                    System.out.print("adjacency list for the graph is ");
                    System.out.print("("+ s + " --> " + d + ")\t");
                }
                System.out.println();
                s++;
            }
        }
    }



    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 4), new Edge(4, 1),new Edge(3, 2), new Edge(2, 5), new Edge(3, 4), new Edge(5, 4), new Edge(1, 1));
// construct a graph from the given list of edges
        Graph graph = new Graph(edges);
//prints the adjacency list that represents graph
        Graph.showGraph(graph);
    }
}
