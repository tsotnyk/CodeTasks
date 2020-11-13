package com.j2core.sts.leetcode.com.smallestCommonRegion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {

        HashMap<String, String> regionMap = new HashMap<>();

        for (List<String> list : regions){
            String parentRegion = list.remove(0);
            for (String childRegion : list){
                regionMap.put(childRegion, parentRegion);
            }
        }

        HashSet<String> parentsRegion1 = new HashSet<>();
        HashSet<String> parentsRegion2 = new HashSet<>();
        parentsRegion1.add(region1);
        parentsRegion2.add(region2);
        String parent1 = regionMap.get(region1);
        String parent2 = regionMap.get(region2);

        String parentForBoth = null;

        while (true){
            if (parentsRegion2.contains(parent1)){
                parentForBoth = parent1;
                break;
            }else {
                parentsRegion1.add(parent1);
            }
            if (parentsRegion1.contains(parent2)){
                parentForBoth = parent2;
                break;
            }else {
                parentsRegion2.add(parent2);
            }
            parent1 = regionMap.getOrDefault(parent1, parent1);
            parent2 = regionMap.getOrDefault(parent2, parent2);
        }

        return parentForBoth;
    }

    public static String findSmallestEnclosingRegion(List<List<String>> inputData, String region1, String region2){

        HashMap<String, String> regionMap = new HashMap<>();

        for(List<String> regionList : inputData){

            String parent = regionList.remove(0);
            for(String child : regionList){
                regionMap.put(child, parent);
            }
        }


        HashSet<String> parentRegion1 = new HashSet<>();
        parentRegion1.add(region1);
        boolean region1Top = !regionMap.containsKey(region1);
        boolean region2Top = !regionMap.containsKey(region2);


        while(!region1Top){
            String candidateParent = regionMap.getOrDefault(region1, "");
            if (candidateParent.length() < 1) break;
            parentRegion1.add(candidateParent);
            region1 = candidateParent;
        }
        if(parentRegion1.contains(region2)) return region2;

        while(!region2Top){
            String candidateParent = regionMap.getOrDefault(region2, "");
            if (candidateParent.length() < 1) break;
            if(parentRegion1.contains(candidateParent)){
                return candidateParent;
            }
            region2 = candidateParent;
        }

        return "";
    }
}
