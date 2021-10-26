package com.algoexpert.Trees.Algos;

import java.util.List;

public class MinHeightBST
{


    class Program {
        public  BST minHeightBst(List<Integer> array) {
            // Write your code here.
            return constructMinHeightBST(array, null, 0, array.size() - 1);
        }

        public  BST constructMinHeightBST(List<Integer> array, BST bst, int startid, int endid)
        {

            if(startid < endid)
                return null;


            int mididx = (startid + endid) / 2;
            int midvalue = array.get(mididx);
            if(bst == null)
            {
                bst = new  BST(midvalue);
            }
            else
            {
                bst.insert(midvalue);
            }
            constructMinHeightBST(array, bst, startid, midvalue-1);
            constructMinHeightBST(array, bst, midvalue+1, endid);
            return bst;

        }

         class BST {
            public int value;
            public BST left;
            public BST right;

            public BST(int value) {
                this.value = value;
                left = null;
                right = null;
            }

            public void insert(int value) {
                if (value < this.value) {
                    if (left == null) {
                        left = new BST(value);
                    } else {
                        left.insert(value);
                    }
                } else {
                    if (right == null) {
                        right = new BST(value);
                    } else {
                        right.insert(value);
                    }
                }
            }
        }
    }

}
