package com.j2core.sts.codefights.com.codeInterview.thumbtack;

import java.util.*;

public class Solution2 {

    String[][][] proCategorization(String[] pros, String[][] preferences) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < pros.length; i++){
            for(String category : preferences[i]){
                if (map.containsKey(category)){
                    map.get(category).add(pros[i]);
                }else {
                    map.put(category, new LinkedList<>(Collections.singletonList(pros[i])));
                }
            }
        }

        String[][][] result = new String[map.size()][][];
        int index = 0;
        List<String> categ = new LinkedList<>(map.keySet());
        Collections.sort(categ);
        for (String tmp : categ){
            result[index] = new String[2][];
            result[index][0] = new String[]{tmp};
            int i = 0;
            String[] array = new String[map.get(tmp).size()];
            for (String pro : map.get(tmp)){
                array[i++] = pro;
            }
            result[index][1] = array;
            index++;
        }
        return result;
    }
}
