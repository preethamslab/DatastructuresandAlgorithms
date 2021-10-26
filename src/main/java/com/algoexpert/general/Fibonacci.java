package com.algoexpert.general;

public class Fibonacci
{
    public static void main(String[] args) {
        System.out.println(getNthFib1(5));
    }



    public static int getNthFib1(int n) {
        // Write your code here.
    int[] lasttwo = {0,1};
    int counter = 3;
    while(counter <=n)
    {
        int nextFib = lasttwo[0]+lasttwo[1];
        lasttwo[0] = lasttwo[1];
        lasttwo[1] = nextFib;
        counter++;
    }
    return n>1 ? lasttwo[1] : lasttwo[0];

    }

    public static int getNthFib(int n) {
        // Write your code here.
        int[] arr = new int[n];
        arr[0]=0;
        if(n!=1)
            arr[1]=1;
        for(int i=2; i< n;i++)
        {
            arr[i] = arr[i-1]+ arr[i-2];
        }

        return arr[n-1];
    }

}
