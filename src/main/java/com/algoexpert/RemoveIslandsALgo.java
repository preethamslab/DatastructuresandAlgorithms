package com.algoexpert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class RemoveIslandsALgo
{
    public int[][] removeIslands(int[][] matrix) 
    {
        // Write your code here.
        
        for(int row = 0; row< matrix.length; row++)
        {
            for(int col = 0; col < matrix[row].length; col++)
            {
                boolean rowIsBorder = row==0 || row == matrix.length -1;
                boolean colIsBorder = col==0 || col == matrix[row].length -1;

                boolean isBorder = rowIsBorder || colIsBorder;

                if(!isBorder)
                    continue;

                if(matrix[row][col]!=1)
                    continue;

                findOnesConnectedToBorder(matrix, row,col);

            }
        }


        for(int row = 0; row< matrix.length; row++)
        {
            for(int col = 0; col < matrix[row].length; col++)
            {
                int color = matrix[row][col];
                if(color == 1) {
                    matrix[row][col] = 0;
                }else if(color == 2){
                    matrix[row][col] = 1;
                }
            }
        }
        return matrix;
    }

    private void findOnesConnectedToBorder(int[][] matrix, int row, int col)
    {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});

        while(stack.size() > 0)
        {
            int[] currentPosition = stack.pop();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            matrix[currentRow][currentCol] = 2;

            int[][] neighbors = getNeighbors(matrix,currentRow,currentCol);

            for(int[] arr: neighbors)
            {
                int nrow = arr[0];
                int ncol = arr[1];

                if(matrix[nrow][ncol] !=1)
                    continue;
                stack.push(arr);
            }

        }

    }

    private int[][] getNeighbors(int[][] matrix, int row, int col)
    {
        int numRows = matrix.length;
        int numCol = matrix[row].length;
        ArrayList<int[]> list = new ArrayList<>();
        if(row - 1 >= 0)
        {
            list.add(new int[]{row-1,col});
        }

        if(row + 1 < numRows)
        {
            list.add(new int[]{row+1,col});
        }

        if(col - 1 >= 0)
        {
            list.add(new int[]{row,col-1});
        }

        if(col + 1 < numCol)
        {
            list.add(new int[]{row,col+1});
        }
        int[][] neighbors = new int[list.size()][2];
        for(int i =0;i < list.size(); i++)
        {
            neighbors[i] = list.get(i);
        }
        return neighbors;

    }


}
