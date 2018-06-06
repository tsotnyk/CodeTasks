package com.j2core.sts.codefights.com.dataStructures.heapsAndStacksAndQueues.minimumOnStack;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    int[] minimumOnStack(String[] operations) {

        List<Integer> actions = new LinkedList<>();
        List<Integer> valuePush = new LinkedList<>();
        int countElements = parsOperations(operations, actions, valuePush);
        int[] miniStack = new int[countElements];
        List<Integer> result = new LinkedList<>();
        int minElement = -1;
        int index = 0;
        int pushIndex = 0;

        for (Integer action : actions){

            switch (action){
                case 1:
                    result.add(minElement);
                    break;
                case 0:
                    int tmp = valuePush.get(pushIndex);
                    pushIndex++;
                    if (index == 0){
                        minElement = tmp;
                    }
                    miniStack[index] = tmp;
                    index++;
                    if (minElement > tmp){
                        minElement = tmp;
                    }

                    break;
                case -1:
                    index--;
                    if (miniStack[index] == minElement){
                        int tmp1 = miniStack[0];
                        for (int i = 1; i < index; i++){
                            if (tmp1 > miniStack[i]){
                                tmp1 = miniStack[i];
                            }
                        }
                        minElement = tmp1;
                    }
                    break;
            }
        }

        return convertListToArray(result);

    }

    private int[] convertListToArray(List<Integer> values){

        int[] result = new int[values.size()];
        int index = 0;
        for (Integer val : values){
            result[index] = val;
            index++;
        }
        return result;
    }

    private int parsOperations(String[] operations, List<Integer> actions, List<Integer> valuePush){

        int countElements = 0;

        for (String action : operations){

            switch (action){
                case "min":
                    actions.add(1);
                    break;
                case "pop":
                    actions.add(-1);
                    break;
                default:
                    actions.add(0);
                    valuePush.add(Integer.parseInt(action.substring(5)));
                    countElements++;
                    break;
            }
        }
        return countElements;
    }
}
