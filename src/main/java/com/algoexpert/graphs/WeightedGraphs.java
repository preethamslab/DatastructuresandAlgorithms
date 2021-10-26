package com.algoexpert.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeightedGraphs
{
    static class Edge{
        int s,d,w;

        Edge(int src, int dest, int weight)
        {
            this.s = src;
            this.d = dest;
            this.w = weight;
        }
    }

    static class Node{
        int value, weight;

        Node(int value, int weight)
        {
            this.value = value;
            this.weight = weight;
        }

        public String toString()
        {
            return this.value+ "= weight = "+this.weight;
        }
    }

    static class Graph
    {
        List<List<Node>> adjList = new ArrayList<>();
        public Graph(List<Edge> edges)
        {
            int n=0;
            for(Edge e: edges)
            {
                n = Integer.max(n, Integer.max(e.s, e.d));
            }

            for(int i=0; i<=n ; i++)
            {
                adjList.add(i, new ArrayList<>());
            }

            for(Edge e: edges)
            {
                adjList.get(e.s).add(new Node(e.d,e.w));
            }
        }

        public static void printGraph(Graph graph)
        {
            int src = 0;
            int n = graph.adjList.size();
            System.out.printf("Adjacency List for the Graph is: ");
            while (src < n)
            {
//for-each loop prints the neighboring vertices with current vertex
                for (Node edge: graph.adjList.get(src))
                {
                    System.out.printf("%d -- > %s\t", src, edge);
                }
                System.out.println();
//increments the source by 1
                src++;
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(1, 4, 3), new Edge(4, 2, 5), new Edge(2, 5, 10), new Edge(5, 1, 6), new Edge(3, 2, 9), new Edge(1, 5, 1), new Edge(3, 5, 2));
//creates a graph with the edges declared above
        Graph graph = new Graph(edges);
//prints the corresponding adjacency list for the graph
        Graph.printGraph(graph);
    }
}


