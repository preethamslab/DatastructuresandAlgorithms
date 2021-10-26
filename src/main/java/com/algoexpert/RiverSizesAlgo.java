package com.algoexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RiverSizesAlgo
{
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.

        List<Integer> sizes = new ArrayList<Integer>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0 ; j < matrix[0].length; j++)
            {
                if(visited[i][j])
                    continue;

                traverseNodes(i,j,matrix, visited,sizes);
            }
        }

        return sizes;

    }

    private static void traverseNodes(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;
        Stack<Integer[]> nodesToExplore = new Stack<>();
        nodesToExplore.push(new Integer[]{i, j});

        while (!nodesToExplore.empty()) {
            Integer[] currentNode = nodesToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];

            if (visited[i][j])
                continue;

            visited[i][j] = true;

            if (matrix[i][j] == 0)
                continue;

            currentRiverSize++;

            List<Integer[]> listOfUnvisitedNeighbours = getUnvisitedNeighbours(i, j, matrix, visited);
            for (Integer[] k : listOfUnvisitedNeighbours) {
                nodesToExplore.add(k);
            }
        }
        if (currentRiverSize > 0)
        {
            sizes.add(currentRiverSize);
        }
    }

    private static List<Integer[]> getUnvisitedNeighbours(int i, int j, int[][] matrix, boolean[][] visited)
    {
        List<Integer[]> unvisitedNei = new ArrayList<>();
        if(i > 0 && !visited[i-1][j])
        {
            unvisitedNei.add(new Integer[]{i-1,j});
        }
        if(i < matrix.length - 1 && !visited[i+1][j])
        {
            unvisitedNei.add(new Integer[]{i+1,j});
        }
        if(j > 0 && !visited[i][j-1])
        {
            unvisitedNei.add(new Integer[]{i,j-1});
        }
        if(j < matrix[0].length - 1 && !visited[i][j+1])
        {
            unvisitedNei.add(new Integer[]{i, j+1});
        }
        return unvisitedNei;

    }

    public static void main(String[] args) {

    }

}
