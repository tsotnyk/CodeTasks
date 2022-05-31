package com.j2core.sts.leetcode.com;

import java.util.*;

public class Solution{

public static void main(String[] args) {

        HashMap<Integer, Integer> qouteMap = new HashMap<>();
        qouteMap.put(4, 10);
        qouteMap.put(5, 20);
        qouteMap.put(6, 30);
        qouteMap.put(7, 100);
        qouteMap.put(8, 75);
        qouteMap.put(9, 50);
        qouteMap.put(10, 100);
        qouteMap.put(11, 110);
        qouteMap.put(12, 120);
        qouteMap.put(13, 130);
        qouteMap.put(14, 140);

        List<String> prefList = new LinkedList<>(Arrays.asList("2 bath","House cleaning", "2 bed", "Standard","Have pets"));


        NTree oneBed = new NTree(4, "1 bed", new LinkedList<>(Arrays.asList(new NTree(10, "1 bath", new LinkedList<>()), new NTree(11, "2 bath", new LinkedList<>()))));

        NTree twoBed = new NTree(5, "2 bed", new LinkedList<>(Arrays.asList(new NTree(12, "1 bath", new LinkedList<>()), new NTree(13, "2 bath", new LinkedList<>()), new NTree(14, "3 bath", new LinkedList<>()))));

        NTree threeBed = new NTree(6, "3 bed", new LinkedList<>());
        NTree laudry = new NTree(7, "lundry", new LinkedList<>());
        NTree ovenCleaning = new NTree(8, "oven cleaning", new LinkedList<>());
        NTree havePets = new NTree(9, "Have pets", new LinkedList<>());

        NTree standart = new NTree(2, "Standard", new LinkedList<>(Arrays.asList(oneBed, twoBed, threeBed, laudry, havePets, ovenCleaning)));

        NTree deepClean = new NTree(3, "Deep clean", new LinkedList<>());
        NTree root = new NTree(1, "House cleaning", new LinkedList<>(Arrays.asList(standart, deepClean)));


        int cost = calculateCost(root, prefList, qouteMap);

        System.out.print(cost);
        }

public static int calculateCost(NTree root, List<String> prefList, Map<Integer, Integer> quoteMap){

        if(prefList.size() < 1) return 0;

        HashSet<String> prefSet = new HashSet<>(prefList);

        return calculateLevel(root, prefSet, quoteMap);

        }

private static int calculateLevel(NTree root, HashSet<String> prefSet, Map<Integer, Integer> quoteMap){

        if(!prefSet.contains(root.name)){
        return 0;
        }

        int currCost = 0;
        if(quoteMap.containsKey(root.quote)){
        currCost += quoteMap.get(root.quote);
        }
        for(NTree node : root.children){

        currCost += calculateLevel(node, prefSet, quoteMap);

        }

        return currCost;
        }
        }

class NTree{

    int quote;
    String name;

    List<NTree> children;

    public NTree(int quote, String name, List<NTree> children){

        this.quote = quote;
        this.name = name;
        this.children = children;
    }
}

