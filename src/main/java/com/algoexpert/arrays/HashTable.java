package com.algoexpert.arrays;

public class HashTable
{
    /*access a value give the key
    * insertion and deletion, searching all operations O(1)
    * init will take O(N), space complexity O(N)
    * hashtable under the hood, built on arrays
    * hash table in worst case has O(N) case, since they all cal end up on same hash key
    * arr of linkedlists, position would be defined by,
    * Ascii mod size of an arr = position in arr
    * each position is a linked list, so its possible to have all numbers in one linkedlist
    * it;s called collission
    * linkedlist also stores reference to the object for retrieval
    *
    * powerful hashing functions: to reduce collisions
    *  let's say array is full and it has to resize, one way to do is, copy the entire
    * array just the way dynamic arrays does and rehash all the contents with new arr
    * size. */
}
