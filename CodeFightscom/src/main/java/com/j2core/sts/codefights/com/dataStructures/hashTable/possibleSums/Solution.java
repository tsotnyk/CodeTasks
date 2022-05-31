package com.j2core.sts.codefights.com.dataStructures.hashTable.possibleSums;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    int possibleSums(int[] coins, int[] quantity) {

        HashSet<Integer> uniqSum = new HashSet<>();

        takeUniqSum(uniqSum, coins, quantity, 0);

        return uniqSum.size();
    }

    private void takeUniqSum(HashSet<Integer> uniqSum, int[] coins, int[] quantity, int sum){

        for (int index = 0; index < quantity.length; index++){
            if (quantity[index] > 0){
                int nextSum = sum + coins[index];
                uniqSum.add(nextSum);
                int[] nextQuantity = quantity.clone();
                nextQuantity[index] -= 1;
                takeUniqSum(uniqSum, coins, nextQuantity, nextSum);
            }
        }
    }

    @Test
    public void test(){

        Assert.assertEquals(possibleSums(new int[]{10, 50, 100}, new int[]{1,2,1}), 9);
        Assert.assertEquals(possibleSums(new int[]{10, 50, 100, 500}, new int[]{5,3,2,2}), 122);
        Assert.assertEquals(possibleSums(new int[]{1}, new int[]{5}), 5);
        Assert.assertEquals(possibleSums(new int[]{1,1}, new int[]{2,3}), 5);
        Assert.assertEquals(possibleSums(new int[]{1,2}, new int[]{50000,2}), 50004);
    }

//    int possibleSums(int[] coins, int[] quantity) {
//
//        Set<Integer> result = new HashSet<>();
//        int length = coins.length;
//
//        Map<Integer, List<Integer>> tmpResults = createSumOneCoin(coins, quantity, result);
//
//        int delta = 1;
//        for (int i = 0; i < length-delta; i++){
//
//            List<Integer> [] collection = new List[delta+1];
//
//            for (int k = 0; k < collection.length; k++){
//
//
//            }
//
//
//
//
//            for (int j = i+1; j < length; j++){}
//
//        }
//
//
//        return result.size();
//    }
//
//
//    private void calculate(Set<Integer> result, List<Integer>[] collection){
//
//
//
//    }
//
//
//
//    private Map<Integer, List<Integer>> createSumOneCoin(int[] coinValue, int[] coinQuantity, Set<Integer> listResults) {
//
//        Map<Integer, List<Integer>> results = new HashMap<>();
//
//        int length = coinValue.length;
//        int[] uniqueCoin = new int[length];
//        int[] uniqueQuantity = new int[length];
//        int index = uniqueValue(coinValue, coinQuantity, uniqueCoin, uniqueQuantity);
//
//        for (int i = 0; i < index; i++) {
//
//            int value = uniqueCoin[i];
//            List<Integer> result = new LinkedList<>();
//            int tmpSum = 0;
//
//            for (int j = 0; j < uniqueQuantity[i]; j++) {
//
//                tmpSum = tmpSum + value;
//                result.add(tmpSum);
//                listResults.add(tmpSum);
//
//            }
//
//            results.put(value, result);
//        }
//
//        return results;
//    }
//
//
//    private boolean containArray(int[] uniqueCoin, int index, int coin){
//
//        for (int i = 0; i < index; i++){
//            if (coin == uniqueCoin[i]){
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    private int uniqueValue(int[] coinValue, int[] coinQuantity, int[] uniqueCoin, int[] uniqueQuantity){
//
//        int length = coinValue.length;
//        int index = 0;
//
//        for (int i = 0; i < length; i++){
//
//            int value = coinValue[i];
//            if (!containArray(uniqueCoin, index, value)){
//
//                int quantity = coinQuantity[i];
//
//                for (int j = 0; j < length; j++){
//
//                    if (j != i){
//                        if (coinValue[i] == coinValue[j] && coinQuantity[j] > coinQuantity[i]){
//                            quantity = coinQuantity[j];
//                        }
//                    }
//                }
//                uniqueQuantity[index] = quantity;
//                uniqueCoin[index] = value;
//            }
//        }
//
//        return index;
//
//    }

}
