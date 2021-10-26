package com.algoexpert.arrays.algos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberoFPasses
{
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,-2,-1},{-5,2,0},{-6,-2,0}};
        System.out.println(minimumPassesOfMatrix(arr));
    }
    public static int minimumPassesOfMatrix(int[][] matrix)
    {
        int passes = convertNegatives(matrix);
        return (!containsNegative(matrix)) ? passes -1 : -1;
    }

    private static int convertNegatives(int[][] matrix)
    {
        ArrayList<int[]> queue = getAllPositivePositions(matrix);
        int passes = 0;

        while(queue.size() > 0)
        {
            int currentSize = queue.size();
            while(currentSize > 0)
            {
                int[] vals = queue.remove(0);
                int currentRow = vals[0];
                int currentCol = vals[1];

                List<int[]> adjacentPositions = getNeighbors(matrix, currentRow, currentCol);
                for(int[] position: adjacentPositions)
                {
                    int row = position[0];
                    int col = position[1];

                    int value = matrix[row][col];
                    if(value < 0)
                    {
                        matrix[row][col] *=-1;
                        queue.add(new int[]{row,col});
                    }
                }
            currentSize-=1;
            }
            passes+=1;
        }
    return passes;
    }

    private static ArrayList<int[]> getAllPositivePositions(int[][] matrix)
    {
        ArrayList<int[]> positivePositions = new ArrayList<>();
        for(int i = 0; i < matrix.length;i++)
        {
            for(int j = 0; j < matrix[i].length ; j++)
            {
                if(matrix[i][j] > 0)
                    positivePositions.add(new int[]{i,j});
            }
        }
        return positivePositions;
    }


    private static boolean containsNegative(int[][] matrix)
    {
        for(int[] row: matrix)
        {
            for(int val: row){
                if(val < 0)
                    return true;
            }
        }
        return false;
    }

    public static List<int[]> getNeighbors(int[][] matrix, int i, int j)
    {
        List<int[]> neighbors = new ArrayList<int[]>();

        if(i > 0)
            neighbors.add(new int[]{i-1,j});


        if(i < matrix.length - 1)
            neighbors.add(new int[]{i+1,j});

        if(j < matrix[i].length-1)
            neighbors.add(new int[]{i, j+1});

        if(j > 0)
            neighbors.add(new int[]{i,j-1});


        return neighbors;
    }



/*
    public int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        // auxillary matrix

        int[][] auxMatrix = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);

        //int[][] auxMatrix = new int[matrix.length][matrix[0].length];
        int count = 0;
        for(int i =0;i < matrix.length;i++)
        {
            for(int j = 0 ; i < matrix[i].length; j++)
            {
                if(matrix[i][j] == 0 )
                    continue;
                if(matrix[i][j] < 0)
                {
                    List<int[]> neighbors = getNeighbors(matrix, i,j);

                    for(int[] arr: neighbors)
                    {
                        int row=arr[0];
                        int col=arr[1];

                        if(matrix[row][col] > 0)
                        {
                            auxMatrix[i][j] = matrix[i][j] * -1;
                        }
                    }
                }
            }
        }
        return 1;
    }


    public List<int[]> getNeighbors(int[][] matrix, int i, int j)
    {
        List<int[]> neighbors = new ArrayList<int[]>();

        if(i-1 > 0)
            neighbors.add(new int[]{matrix[i-1][j]});


        if(i+1 < matrix.length)
            neighbors.add(new int[]{matrix[i+1][j]});

        if(j+1 < matrix[i].length)
            neighbors.add(new int[]{matrix[i][j+1]});

        if(j-1 > 0)
            neighbors.add(new int[]{matrix[i][j-11]});


        return neighbors;
    }
*/

}
