package com.algoexpert.Medimdiff;

public class ArrayOfProducts {
    public static void main(String[] args) {
        int[] prodArr = arrayOfProds(new int[]{5,1,4,2});
        for(int i:prodArr)
            System.out.println(i);
    }

    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        if(array.length == 0)
            return new int[]{};
        int idx = 0;
        int[] newArr = new int[array.length];
        while(idx < array.length)
        {
            int product = 1;
            for(int i=0; i<array.length;i++)
            {
                if(i == idx)
                    continue;
                product*=array[i];
            }
            newArr[idx] = product;
            idx++;
        }
        return newArr;
    }


    public static int[] arrayOfProds(int[] array)
    {
        int[] products = new int[array.length];

        int leftRunnProduct = 1;
        for(int i=0;i < array.length; i++)
        {
            products[i] = leftRunnProduct;
            leftRunnProduct *= array[i];
        }

        int rightRunnProduct = 1;
        for(int i=array.length-1; i >=0 ; i--)
        {
            products[i] *= rightRunnProduct;
            rightRunnProduct *= array[i];
        }
        return products;
    }

}
