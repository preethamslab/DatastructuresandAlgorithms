package com.algoexpert.arrays.algos;

import java.util.ArrayList;
import java.util.List;

public class CircularGasStationProblem
{
    public static void main(String[] args)
    {
        System.out.println(4%4);

        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for(int i: new int[]{2,3,4})
        {
            A.add(i);

        }
        for(int i: new int[]{3,4,3})
        {
            B.add(i);
        }

        System.out.println(canCompleteCircuit(A,B));
    }

    public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B)
    {
        int startingPoint = 0;

        if(A.size() == 1 && B.size() == 1)
            return 0;

        for(int i =0 ; i< A.size(); i++)
        {

            int nextStop = i + 1 >= B.size() ? (i % (B.size() - 1))
                    : i +1 ;

            if(A.get(i) > B.get(nextStop)) {
                startingPoint = i;
                break;
            }
        }

        int fuelLeft = A.get(startingPoint);

        int currentPoint = startingPoint;

        while(currentPoint < A.size())
        {
            int nextStop = currentPoint + 1 >= B.size() ? (currentPoint % (B.size() - 1))
        : currentPoint +1 ;


            if(B.get(nextStop) <= fuelLeft)
            {
                fuelLeft -= B.get(nextStop);
                if(currentPoint >= A.size()-1) {
                    currentPoint = currentPoint % (A.size() - 1);
                }else {
                    currentPoint++;
                }

                fuelLeft += A.get(nextStop);

                if(currentPoint == startingPoint )
                    return 1;
            }else
            {
                return -1;
            }
        }
        return -1;
    }


}
