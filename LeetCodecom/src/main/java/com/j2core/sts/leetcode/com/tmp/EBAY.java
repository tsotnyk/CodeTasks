package com.j2core.sts.leetcode.com.tmp;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class EBAY {

    public int findSmallerPath(String[][] information, int stops, String start, String end){

        HashMap<String, Boolean> visit = new HashMap<>();
        HashMap<String, List<Graph>> map = new HashMap<>();
        HashMap<String, Integer> weight  = new HashMap<>();

        createMap(information, visit, map, weight, start);

        while (stops-- > -1){
            String minLength = findSmallerNode(weight, visit);
            visit.put(minLength, true);
            int cost = weight.get(minLength);
            for (Graph list : map.get(minLength)){
                if (!visit.get(list.end)){
                    int tmp = cost + list.cost;
                    weight.put(list.end, Math.min(tmp, weight.get(list.end)));
                }
            }
        }

        int cost = weight.get(end);
        return cost < Integer.MAX_VALUE ? cost : -1;
    }

    private String findSmallerNode(HashMap<String, Integer> weight, HashMap<String, Boolean> visit) {

        String node = null;
        int cost = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : weight.entrySet()){
            if (!visit.get(entry.getKey())) {
                if (node == null) {
                    node = entry.getKey();
                    cost = entry.getValue();
                } else {
                    if (cost > entry.getValue()) {
                        cost = entry.getValue();
                        node = entry.getKey();
                    }
                }
            }
        }
        return node;
    }

    private void createMap(String[][] information, HashMap<String, Boolean> visit, HashMap<String, List<Graph>> map, HashMap<String, Integer> weight, String start) {

        for (String[] info : information){
            if (!visit.containsKey(info[0])){
                visit.put(info[0], false);
                if (info[0].equals(start)){
                    weight.put(info[0], 0);
                }else {
                    weight.put(info[0], Integer.MAX_VALUE);
                }
            }
            if (!visit.containsKey(info[1])){
                visit.put(info[1], false);
                weight.put(info[1], Integer.MAX_VALUE);
            }
            Graph node = new Graph(Integer.parseInt(info[2]), info[0], info[1]);
            if (map.containsKey(info[0])){
                map.get(info[0]).add(node);
            }else {
                ArrayList<Graph> list = new ArrayList<>();
                list.add(node);
                map.put(info[0], list);
            }
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        if(days == 0) return createList(states);
        // WRITE YOUR CODE HERE
        int[] nextStates = new int[states.length];
        int[] tmp = null;

        while(days-- > 0){
            for(int i = 0; i < states.length; i++){
                if (i == 0){
                    if(states[i+1] == 0){
                        nextStates[i] = 0;
                    }else{
                        nextStates[i] = 1;
                    }
                } else if(i < states.length-1){
                    if((nextStates[i-1] == 0 && nextStates[i+1] == 0) || (nextStates[i-1] == 1 && nextStates[i+1] == 1)){
                        nextStates[i] = 0;
                    }else{
                        nextStates[i] = 1;
                    }
                }else{
                    if(states[i-1] == 0){
                        nextStates[i] = 0;
                    }else{
                        nextStates[i] = 1;
                    }
                }

            }
            tmp = states;
            states = nextStates;
            nextStates = tmp;
        }

        return createList(states);
    }

    private List<Integer> createList(int[] array){

        List<Integer> statesList = new ArrayList<>();

        for(int num : array){
            statesList.add(num);
        }
        return statesList;
    }

    @Test
    public void test(){

        List<Integer> result = cellCompete(new int[]{1,0,0,0,0,1,0,0}, 1);

        Assert.assertEquals(findSmallerPath(new String[][]{{"A", "B", "100"}, {"B", "C", "100"},{"A", "C", "300"}}, 1, "A", "C"), 200);
    }
}

class Graph{

    int cost;
    String start;
    String end;

    public Graph(int cost, String start, String end) {
        this.cost = cost;
        this.start = start;
        this.end = end;
    }
}
