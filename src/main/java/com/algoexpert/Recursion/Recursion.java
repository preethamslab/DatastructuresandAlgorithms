package com.algoexpert.Recursion;

public class Recursion
{

    // direct
    // indirect
    // tail
    // non tail





    /*
    direct recursion: function calls itself again and again
    function fun()
    {
        system.out.print("YAY!! having fun");
        fun();
    }

    in-direct recursion: function calls another function and calls it back
    // 1,2,3,4,5,6,7,8,9,10
    // add 1s to odd numbers
    // subtract 1 from even numbers

    function fun()
    {
        fun2();
    }

    function fun2()
    {
        fun();
    }

    tail recursion:
    function is called at the end of the function, when there is no state needs to be maintained
    function fun(int n)
    {
        if(n==0)
            return;
        sout(n);
        fun(n-1);
    }


    non-tail functions: when functions are called and before returning the state needs to be maintained
    function fun(int n)
    {
        if(n==0)
            return 0;

        sout(n);
        return 1+fun(n-1);
    }
     */

    // pring 1 to 10, when its odd +1 and when it's even -1


/*    public void rec()
    {
        if(){
            ...
        }else{
            ...
        }

         - identify a pattern to solve a problem
         - to identify corner or escape or exit sequences

    }*/


    public static void main(String[] args) {
        printOdd(new int[]{1,2,3,4,5,6,7,8,9,10}, 10, 0);
    }

    public static void printOdd(int[] arr, int size,int id)
    {
        if(id >= arr.length)
            return;
        if(arr[id]%2 == 0)
            printEven(arr, size, id);

        System.out.println(arr[id]+1);
        printOdd(arr, size, id+1);
    }

    private static void printEven(int[] arr, int size, int id)
    {
        if(id >= arr.length)
            return;
        System.out.println(arr[id]-1);
        printOdd(arr, size, id+1);
    }
}
