package com.algoexpert.Medimdiff;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse
{
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        if(array.length ==0)
            return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length-1;
        int startCol = 0;
        int endColumn = array[0].length-1;

        while(startRow < endRow && startCol<=endColumn)
        {
            for(int col=startCol; col<=endColumn;col++)
            {
                result.add(array[startRow][col]);
            }

            for(int row = startRow+1; row<=endRow;row++)
            {
                result.add(array[row][endColumn]);
            }

            for(int col = endColumn-1;col >= startCol; col--)
            {
                if(startRow == endRow) break;
                result.add(array[endRow][col]);
            }

            for(int row = endRow -1; row > startRow; row--)
            {
                if(startCol == endColumn) break;
                result.add(array[row][startCol]);
            }

            startRow++;
            startCol++;
            endRow--;
            endColumn--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        System.out.println( spiralTraverse(arr));
    }
}
