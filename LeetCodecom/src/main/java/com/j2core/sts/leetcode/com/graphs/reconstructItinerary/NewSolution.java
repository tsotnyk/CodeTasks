package com.j2core.sts.leetcode.com.graphs.reconstructItinerary;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class NewSolution {

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> map = createMap(tickets);
        List<String> result = new LinkedList<>();

        deepFirstSearch(map, "JFK", result);

        return result;
    }

    private void deepFirstSearch(Map<String, PriorityQueue<String>> map, String start, List<String> prevList){

        PriorityQueue<String> nextStep = map.get(start);

        while (nextStep != null && !nextStep.isEmpty()){
            deepFirstSearch(map, nextStep.poll(), prevList);
        }

        prevList.add(0, start);
    }

    private Map<String, PriorityQueue<String>> createMap(List<List<String>> list){

        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> pair :list){

            PriorityQueue<String> queue = map.getOrDefault(pair.get(0), new PriorityQueue<>());
            queue.add(pair.get(1));
            map.put(pair.get(0), queue);
        }
        return map;
    }

    @Test
    public void test(){

        List<List<String>> tickets = new LinkedList<>();
        tickets.add(new LinkedList<>(Arrays.asList("JFK", "AAA")));
        tickets.add(new LinkedList<>(Arrays.asList("JFK", "BBB")));
        tickets.add(new LinkedList<>(Arrays.asList("BBB", "CCC")));
        tickets.add(new LinkedList<>(Arrays.asList("CCC", "JFK")));

        List<String> result = findItinerary(tickets);

        Assert.assertEquals(result.size(), 4);

//        List<List<String>> tickets = new LinkedList<>();
//        tickets.add(new LinkedList<>(Arrays.asList("JFK", "SFO")));
//        tickets.add(new LinkedList<>(Arrays.asList("JFK", "ATL")));
//        tickets.add(new LinkedList<>(Arrays.asList("SFO", "ATL")));
//        tickets.add(new LinkedList<>(Arrays.asList("ATL", "JFK")));
//        tickets.add(new LinkedList<>(Arrays.asList("ATL", "SFO")));
//
//        List<String> result = findItinerary(tickets);
//
//        Assert.assertEquals(result.size(), 6);
    }
}
