package com.j2core.sts.codefights.com.dataStructures.hashTable.possibleSums;

import java.util.*;

public class Solution {

    int possibleSums(int[] coins, int[] quantity) {

        Set<Integer> result = new HashSet<>();
        int length = coins.length;

        Map<Integer, List<Integer>> tmpResults = createSumOneCoin(coins, quantity, result);

        int delta = 1;
        for (int i = 0; i < length-delta; i++){

            List<Integer> [] collection = new List[delta+1];

            for (int k = 0; k < collection.length; k++){


            }




            for (int j = i+1; j < length; j++){}

        }


        return result.size();
    }


    private void calculate(Set<Integer> result, List<Integer>[] collection){



    }



    private Map<Integer, List<Integer>> createSumOneCoin(int[] coinValue, int[] coinQuantity, Set<Integer> listResults) {

        Map<Integer, List<Integer>> results = new HashMap<>();

        int length = coinValue.length;
        int[] uniqueCoin = new int[length];
        int[] uniqueQuantity = new int[length];
        int index = uniqueValue(coinValue, coinQuantity, uniqueCoin, uniqueQuantity);

        for (int i = 0; i < index; i++) {

            int value = uniqueCoin[i];
            List<Integer> result = new LinkedList<>();
            int tmpSum = 0;

            for (int j = 0; j < uniqueQuantity[i]; j++) {

                tmpSum = tmpSum + value;
                result.add(tmpSum);
                listResults.add(tmpSum);

            }

            results.put(value, result);
        }

        return results;
    }


    private boolean containArray(int[] uniqueCoin, int index, int coin){

        for (int i = 0; i < index; i++){
            if (coin == uniqueCoin[i]){
                return true;
            }
        }
        return false;
    }


    private int uniqueValue(int[] coinValue, int[] coinQuantity, int[] uniqueCoin, int[] uniqueQuantity){

        int length = coinValue.length;
        int index = 0;

        for (int i = 0; i < length; i++){

            int value = coinValue[i];
            if (!containArray(uniqueCoin, index, value)){

                int quantity = coinQuantity[i];

                for (int j = 0; j < length; j++){

                    if (j != i){
                        if (coinValue[i] == coinValue[j] && coinQuantity[j] > coinQuantity[i]){
                            quantity = coinQuantity[j];
                        }
                    }
                }
                uniqueQuantity[index] = quantity;
                uniqueCoin[index] = value;
            }
        }

        return index;

    }

}
