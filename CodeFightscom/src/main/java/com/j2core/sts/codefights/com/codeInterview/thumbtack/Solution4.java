package com.j2core.sts.codefights.com.codeInterview.thumbtack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {

    String[] requestMatching(String[] pros, int[] distances, int[] travelPreferences) {

        HashMap<Integer, List<String>> map = new HashMap<>();

        for (int i = 0; i < pros.length; i++){
            int delta = travelPreferences[i] >= distances[i] ? distances[i] : travelPreferences[i]-distances[i];
            if (map.containsKey(delta)){
                map.get(delta).add(pros[i]);
            }else {
                map.put(delta, new LinkedList<>(Collections.singleton(pros[i])));
            }
        }

        List<Integer> deltaList = new LinkedList<>(map.keySet());
        Collections.sort(deltaList, (t1, t2) ->{

            if (t1 < 0 && t2 < 0){
                return Math.abs(t1) - Math.abs(t2);
            }
            if (t1 > -1 && t2 > -1){
                return t1 - t2;
            }
            if (t1 < 0) return 1;
            return t1 == t2 ? 0 : -1;
        });

        int length = Math.min(pros.length, 5);

        String[] result = new String[length];
        int index = 0;
        for (int delta : deltaList){
            List<String> list = map.get(delta);
            Collections.sort(list);
            for (String name : list){
                result[index++] = name;
                if (index == length) break;
            }
            if (index == length) break;
        }
        return result;
    }

    @Test
    public void test(){

        Assert.assertArrayEquals(new String[]{"Michael", "Ann", "Dan", "Mary", "Nick"},
                requestMatching(new String[]{"Michael", "Mary", "Ann", "Nick", "Dan", "Mark"}, new int[]{12, 10, 19, 15, 5, 20}, new int[]{12, 8, 25, 10, 3, 10}));
    }
}
