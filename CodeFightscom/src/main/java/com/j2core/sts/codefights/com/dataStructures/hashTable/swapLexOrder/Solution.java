package com.j2core.sts.codefights.com.dataStructures.hashTable.swapLexOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    String swapLexOrder(String str, int[][] pairs) {

        Map<Integer, List<Integer>> relationMap = createRelationMap(str.length(), pairs);
        boolean[] usedSymbol = new boolean[str.length()];

        char[] swapString = new char[str.length()];

        for (int index = 0; index < str.length(); index++){

            int useIndex = findMaxSymbol(str, relationMap, usedSymbol, index);
            swapString[index] = str.charAt(useIndex);
            usedSymbol[useIndex] = true;
        }

        return String.valueOf(swapString);
    }

    private int findMaxSymbol(String str, Map<Integer, List<Integer>> relationMap, boolean[] usedSymbol, int pointIndex) {

        char symbol = str.charAt(pointIndex);
        int index = pointIndex;
        boolean[] visited = new boolean[str.length()];

        Stack<Integer> stack = new Stack<>();
        stack.addAll(relationMap.get(index));


        while (!stack.isEmpty()){
            int tmpIndex = stack.peek();
            if (!visited[tmpIndex]){
                stack.addAll(relationMap.get(tmpIndex));
                visited[tmpIndex] = true;
                continue;
            }
            stack.pop();
            if (tmpIndex != index){
                if (usedSymbol[index]){
                    index = tmpIndex;
                    symbol = str.charAt(tmpIndex);
                }
                if (!usedSymbol[tmpIndex] && str.charAt(tmpIndex) > symbol){
                    symbol = str.charAt(tmpIndex);
                    index = tmpIndex;
                }
            }
        }
        return index;
    }

    private Map<Integer, List<Integer>> createRelationMap(int length, int[][] pairs) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int index = 0; index < length; index++){
            map.put(index, new LinkedList<>());
        }

        for (int[] pair : pairs){
            map.get(pair[0]-1).add(pair[1]-1);
            map.get(pair[1]-1).add(pair[0]-1);
        }

        return map;
    }

    @Test
    public void test(){

        Assert.assertEquals(swapLexOrder("abcd", new int[][]{{1,4},{3,4}}), "dbca");
        Assert.assertEquals(swapLexOrder("abdc", new int[][]{{1,4},{3,4}}), "dbca");
                Assert.assertEquals(swapLexOrder("abcdefgh", new int[][]{{1,4},{7,8}}), "dbcaefhg");


    }
}
