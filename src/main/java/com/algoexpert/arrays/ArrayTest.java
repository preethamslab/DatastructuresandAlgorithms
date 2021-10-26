package com.algoexpert.arrays;

import org.w3c.dom.ls.LSOutput;

public class ArrayTest {
    //get -> O(1) ST
    //set/update  -> O(1) ST
    // init -> O(8*N) -> big o or asymptotic analysis -> O(N) ST
    // traverse -> O(N) T. O(1) S
    // copy -> O(N) ST
    // insertion -> O(N)T, O(1)S (exception) in case of static array
    // dynamic array, fast insertion at the end of an array
    // initialize with double the space requested
    //  dynamic arrays are created with double the initial request and doubled when it
    // exhausts the allocated space.
    // javascript and python by default dynamic array
    // dynamic array: insert time complexity is always constant, space is O(N) worst case
    // insert at the beginning will still take O(N) as rest of the elements have to
    // be shifted, in dynamic as well as static
    // POP at the end of an array O(1)ST, middle of array -> O(N) ST
    // cut out array, O(N) ST
    // get, set/update, insert at the end, quite fast in array. O(1) ST
    // traverse, insert in the middle, remove from the middle are O(N) ST
    // init O(N) ST

    public static void main(String[] args) {
        int[] arr = new int[5];

        int[] arr1 = {1,2,3,4,5};
        System.out.println(arr.length);
    }
}
