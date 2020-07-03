package com.j2core.sts.leetcode.com.killProcess;

import java.util.*;

public class Solution {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> mapId = new HashMap<>();

        for (int i = 0; i < pid.size(); i++){

            int parent = ppid.get(i);
            if (mapId.containsKey(parent)){
                mapId.get(parent).add(pid.get(i));
            }else {
                List<Integer> list = new LinkedList<>();
                list.add(pid.get(i));
                mapId.put(parent, list);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(kill);
        List<Integer> children = mapId.getOrDefault(kill, new ArrayList<>());
        while (!children.isEmpty()){
            int id = children.remove(0);
            result.add(id);
            children.addAll(mapId.getOrDefault(id, new ArrayList<>()));
        }

        return result;
    }
}
