package com.algoexpert.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
// this is for bidirectional graphs
public class GraphsTest
{
    static class Graph<Object>
    {
        private Map<Object, List<Object>> map = new HashMap<>();

        public void addVertex(Object s)
        {
            map.put(s, new LinkedList<>());
        }

        // the method adds an edge between source and destination
        public void addNewEdge(Object source, Object destination, boolean isBidirectional)
        {
            if(!map.containsKey(source))
                addVertex(source);
            if(!map.containsKey(destination)) {
                addVertex(destination);
                map.get(source).add(destination);
            }

            if(isBidirectional)
            {
                map.get(destination).add(source);
            }
        }

        //the method counts number of vertices
        public void countVertices()
        {
            System.out.println("total number of vertices = "+ map.keySet().size());
        }

        // count the number of edges
        public void countEdge(boolean bidirection)
        {
            int count = 0;
            for(Object v:map.keySet())
            {
                count = count + map.get(v).size();
            }

            if(bidirection)
                count = count/2;

            System.out.println("total number of edges "+count);
        }

        public void containsVertex(Object s)
        {
            if(map.containsKey(s))
                System.out.println("graph contains" + s + " as a vertex");
            else{
                System.out.println("the graph doesnot contain "+s+" as a vertex");
            }
        }

        public void containsEdge(Object s, Object d)
        {
            if(map.get(s).contains(d))
                System.out.println("the graph has an edge between "+s+"="+ d);

            System.out.println("there is no edge between "+ s +" = "+d);
        }

        public String toString()
        {
            StringBuilder builder = new StringBuilder();
            //foreach loop that iterates over the keys
            for (Object v : map.keySet())
            {
                builder.append(v.toString() + ": ");
                //foreach loop for getting the vertices
                for (Object w : map.get(v))
                {
                    builder.append(w.toString() + " ");
                }
                builder.append("\n");
            }
            return (builder.toString());
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph<>();
        graph.addNewEdge(0, 1, true);
        graph.addNewEdge(0, 4, true);
        graph.addNewEdge(1, 2, true);
        graph.addNewEdge(1, 3, false);
        graph.addNewEdge(1, 4, true);
        graph.addNewEdge(2, 3, true);
        graph.addNewEdge(2, 4, true);
        graph.addNewEdge(3, 0, true);
        graph.addNewEdge(2, 0, true);

        System.out.println("adjacency list of graph "+graph.toString());
        graph.countVertices();
        graph.countEdge(true);

        graph.containsEdge(3,4);

        graph.containsEdge(2,4);

        graph.containsVertex(3);
        graph.containsVertex(5);
    }
}
