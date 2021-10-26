package com.algoexpert.Matrix;

import java.util.List;

public class TotalShapes
{
    public static void main(String[] args) {

    }

    public int totalShapes(char[][] grid)
    {
        int totalShapes = 0;
        for(int i = 0 ; i < grid.length; i ++ )
        {
            for(int j =0; j < grid[i].length; j ++)
            {
                List<int[]> charlist = getNeighbors(grid, i, j);
                if(charlist.size() > 0)
                {
                    for(int[] k: charlist)
                    {
                        if(grid[k[0]][k[1]] == 'X')
                        {
                            totalShapes ++;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private List<int[]> getNeighbors(char[][] grid, int i, int j)
    {
        return null;
    }
}
