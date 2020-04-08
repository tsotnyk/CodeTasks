package com.j2core.sts.leetcode.com.graphs.reconstructItinerary;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    private Map<String, PriorityQueue<String>> map;
    private List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        for(List<String> list: tickets) {
            if(!map.containsKey(list.get(0))) map.put(list.get(0), new PriorityQueue<>());
            map.get(list.get(0)).offer(list.get(1));
        }
        res = new ArrayList<>();
        if(!map.containsKey("JFK")) return res;

        dfs("JFK");

        return res;
    }

    private void dfs(String start) {
        PriorityQueue<String> arrivals = map.get(start);
        while(arrivals != null && arrivals.size() > 0)
            dfs(arrivals.poll());

        res.add(0, start);
    }

    @Test
    public void test(){

        List<List<String>> tickets = new LinkedList<>();
        tickets.add(new LinkedList<>(Arrays.asList("JFK", "SFO")));
        tickets.add(new LinkedList<>(Arrays.asList("JFK", "ATL")));
        tickets.add(new LinkedList<>(Arrays.asList("SFO", "ATL")));
        tickets.add(new LinkedList<>(Arrays.asList("ATL", "JFK")));
        tickets.add(new LinkedList<>(Arrays.asList("ATL", "SFO")));

        List<String> result = findItinerary(tickets);

        Assert.assertEquals(result.size(), 6);
    }
}
