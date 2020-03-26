package com.j2core.sts.leetcode.com.arrays.productOfLastKNumbers;

import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductOfNumbers {

    ArrayList<Integer> arrayList;

    public ProductOfNumbers() {
        arrayList = new ArrayList<>();
    }

    public void add(int num) {

        arrayList.add(num);

    }

    public int getProduct(int k) {

        int sum = 1;

        for (int i = arrayList.size()-k; i < arrayList.size(); i++){
            sum *= arrayList.get(i);
            if (sum == 0){
                break;
            }
        }

        return sum;
    }

    @Test
    public static void test(){

        ProductOfNumbers numbers = new ProductOfNumbers();
        numbers.add(3);
        numbers.add(0);
        numbers.add(2);
        numbers.add(5);
        numbers.add(4);
        System.out.println(numbers.getProduct(2));
        System.out.println(numbers.getProduct(3));
        System.out.println(numbers.getProduct(4));
        numbers.add(8);
        System.out.println(numbers.getProduct(2));

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */


