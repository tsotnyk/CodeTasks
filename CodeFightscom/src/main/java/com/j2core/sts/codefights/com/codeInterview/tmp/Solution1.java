package com.j2core.sts.codefights.com;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    ///**
    //	*abc, bca => true
    //	*abb, bab => true
    //	*acc, ac => false
    //	*acc, aac => false
    //*/
    boolean similar(String here, String there) {


        Map<Character, Integer> map = createMap(here);

        Set<Map.Entry<Character, Integer>> set = map.entrySet();

        for (Map.Entry<Character, Integer> entity : set) {

            if (there.indexOf(entity.getKey()) != -1) {

                if (!entity.getValue().equals(countCharacter(there, entity.getKey()))) {
                    return false;
                }
            } else return false;
        }
        //your implementation her

        return true;
    }


    private int countCharacter(String sti, char symbol) {

        int count = 0;

        int index = sti.indexOf(symbol);

        while (index != -1) {

            count++;
            index = sti.indexOf(symbol, index + 1);

        }

        return count;

    }

    private Map<Character, Integer> createMap(String here) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < here.length(); i++) {

            char tmp = here.charAt(i);
            if (map.containsKey(tmp)) {

                map.put(tmp, 1 + map.get(tmp));
            } else {

                map.put(tmp, 1);
            }
        }

        return map;


    }



    @Test

    public void test(){


    }
}