package com.j2core.sts.leetcode.com.tmp.tmp;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class WalmartSolutionOld {

    int  payBill(int money, List<Integer> listBills){

        int maxSumBill = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> set = new TreeMap<>();
        for (int bill : listBills){
            if (bill < money){
                int delta = money - bill;
                Integer pairKey = set.get(delta);
                if (pairKey == null) {
                    pairKey = set.floorKey(delta);
                }
                if (pairKey != null){
//                    int [] result = new int[2];
                    int sum = bill + set.get(pairKey);
                    maxSumBill = Math.max(maxSumBill, sum);
                }
                set.put(delta, bill);
            }
        }

        return maxSumBill;

//        HashMap<Integer, Integer> set = new HashMap<>();
//        for (int bill : listBills){
//            if (bill < money){
//                int delta = money - bill;
//                Integer pairKey = set.getOrDefault(delta, 0);
//                if (pairKey > 0){
//                    int [] result = new int[2];
//                    result[0] = bill;
//                    result[1] = delta;
//                    return result;
//                }
//                set.put(bill, delta);
//            }
//        }
//
//        return null;
    }

    public void print(int[] result){

        for (int num : result){
            System.out.println(num);
        }
        System.out.println("*********************");
    }

    @Test
    public void test(){

        int result1 = payBill(11, new LinkedList<>(Arrays.asList(1, 2, 5, 5, 10, 20, 50, 100, 5)));
        Assert.assertNotNull(result1);
        System.out.println(result1);
//        print(result1);

//        int[] result2 = payBill(10, new LinkedList<>(Arrays.asList(1, 2, 5, 5, 10, 20, 50, 100, 5)));
//        Assert.assertNotNull(result2);
//        print(result2);
//
//        int[] result3 = payBill(101, new LinkedList<>(Arrays.asList(1, 2, 5, 5, 10, 20, 50, 100, 5)));
//        Assert.assertNotNull(result3);
//        print(result3);
//
//        int[] result4 = payBill(5, new LinkedList<>(Arrays.asList(1, 2, 5, 5, 10, 20, 50, 100, 5)));

    }
}
