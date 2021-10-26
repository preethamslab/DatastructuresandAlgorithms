/*
package com.algoexpert.linkedlist;

import java.util.LinkedList;

public class RemoveDuplicatesLinkedlis
{
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }


    public LinkedList removeDuplicatesFromLinkedList2(LinkedList linkedList) {
        // Write your code here.
        LinkedList curreNode = linkedList;

        while(curreNode != null){
            LinkedList nextsDistinctNode = curreNode.next;
            while(nextsDistinctNode !=null && nextsDistinctNode.value == curreNode.value)
            {
                nextsDistinctNode =  nextsDistinctNode.next;
            }
            curreNode.next = nextsDistinctNode;
            curreNode = nextsDistinctNode;
        }
*/
/*
    public LinkedList removeDuplicatesFromLinkedList1(LinkedList linkedList) {
        // Write your code here.
        while(linkedList.next != null)
        {
            if(linkedList.value == linkedList.next.value)
                linkedList == null;
        }

        return linkedList;
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Write your code here.
        for(int i=0; i < linkedList.size(); i++)
        {
            if(linkedList.get(i+1) == linkedList.get(i))
            {
                linkedList.remove(i+1);
            }
        }

        return linkedList;
    }*//*

    }
*/
