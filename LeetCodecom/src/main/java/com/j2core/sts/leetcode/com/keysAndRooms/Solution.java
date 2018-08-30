package com.j2core.sts.leetcode.com.keysAndRooms;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        List<Integer> keys = createKeyList(rooms);

        return findKey(keys, rooms.size());
    }

    private int[] createRoomArray(int length){

        int[] result = new int[length];

        for (int i = 1; i < length; i++){
            result[i] = i;
        }
        return result;
    }


    private List<Integer> createKeyList(List<List<Integer>> rooms){

        Set<Integer> keySet = addAllAvailableKey(rooms);

        List<Integer> result = new LinkedList<>();
        result.addAll(keySet);
        Collections.sort(result);

        return result;
    }


    private Set<Integer> addAllAvailableKey(List<List<Integer>> rooms){

        Set<Integer> result = new HashSet<>();
        int[] visitedRoom = createRoomArray(rooms.size());
        List<List<Integer>> keyCollection = new LinkedList<>();
        keyCollection.add(rooms.get(0));

        while (!keyCollection.isEmpty()){

            List<Integer> tmpList = ((LinkedList<List<Integer>>) keyCollection).removeFirst();

            for (int num : tmpList){

                if (visitedRoom[num] > 0){

                    keyCollection.add(rooms.get(num));
                    visitedRoom[num] = num * -1;
                    result.add(num);

                }
            }
        }
        return result;

    }



    private boolean findKey(List<Integer> keys, int countRoom){

        for (int i = 1; i < countRoom; i++) {

            boolean flag = false;
            for (int key : keys) {

                if (key == i){
                    flag = true;
                    break;
                }

            }
            if (!flag) return false;
        }

        return true;
    }


    @Test
    public void test(){

        List<List<Integer>> data = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        tmp.add(1);
        tmp.add(3);
        data.add(tmp);
        List<Integer> tmp1 = new LinkedList<>();
        tmp1.add(3);
        tmp1.add(0);
        tmp1.add(1);
        data.add(tmp1);
        List<Integer> tmp2 = new LinkedList<>();
        tmp2.add(2);
        data.add(tmp2);
        List<Integer> tmp3 = new LinkedList<>();
        tmp3.add(0);
        data.add(tmp3);

        boolean result = canVisitAllRooms(data);

        Assert.assertFalse(result);

    }

}
