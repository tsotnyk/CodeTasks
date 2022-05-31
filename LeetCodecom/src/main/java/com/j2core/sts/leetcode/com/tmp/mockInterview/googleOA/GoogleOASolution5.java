package com.j2core.sts.leetcode.com.tmp.mockInterview.googleOA;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GoogleOASolution5 {

    public int countVowelPermutation(int n) {

        int m = 1000000007;
        HashMap<Character, List<Character>> map = createMap();
        List<Character> currentList = new LinkedList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        HashMap<Character, Long> currentMap = new HashMap<>();
        for (char symbol : currentList){
            currentMap.put(symbol, 1L);
        }

        for (int i = 1; i < n; i++){

            HashMap<Character, Long > nextMap = new HashMap<>();

            for (char symbol : currentMap.keySet()){

                for (char nextSymbol : map.get(symbol)){
                    long count = nextMap.getOrDefault(nextSymbol, 0L) + currentMap.get(symbol);
                    nextMap.put(nextSymbol, count%m);
                }
            }

            currentMap = nextMap;

        }

        long sum = 0;

        for (char symbol : currentMap.keySet()){
            sum += currentMap.get(symbol);
            sum = sum%m;
        }

        return (int) sum;
    }

    private HashMap<Character, List<Character>> createMap(){

        HashMap<Character, List<Character>> map = new HashMap<>();

        map.put('a', new LinkedList<>(Collections.singletonList('e')));
        map.put('e', new LinkedList<>(Arrays.asList('a', 'i')));
        map.put('i', new LinkedList<>(Arrays.asList('a', 'e', 'o', 'u')));
        map.put('o', new LinkedList<>(Arrays.asList('u', 'i')));
        map.put('u', new LinkedList<>(Collections.singletonList('a')));

        return map;
    }

    @Test
    public void test(){

//        Assert.assertEquals(10, countVowelPermutation(2));
//        Assert.assertEquals(68, countVowelPermutation(5));
//        Assert.assertEquals(5, countVowelPermutation(1));
//        Assert.assertEquals(18208803, countVowelPermutation(144));
        Assert.assertEquals(237753473, countVowelPermutation(158));
    }
}
