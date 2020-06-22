package com.j2core.sts.leetcode.com.hackerrank;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class SolutionAmazon {

    public List<String> reorderLines(int logFileSize, List<String> logLines) {

        Collections.sort(logLines, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] split1 = s1.split(" ", 2);
                String[] split2 = s2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) return cmp;
                    return split1[0].compareTo(split2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        });

        return logLines;
    }

    public List<String> reorderLines1(int logFileSize, List<String> logLines)
    {
        // WRITE YOUR CODE HERE
        ArrayList<String> lettersLines = new ArrayList<>();
        ArrayList<String> numbersLines = new ArrayList<>();

        for (String line : logLines){
            int index = line.indexOf(' ');
            if (Character.isDigit(line.charAt(index+1))){
                numbersLines.add(line);
            }else {
                lettersLines.add(line);
            }
        }

        sortLettersLines(lettersLines);

        lettersLines.addAll(numbersLines);

        return lettersLines;
    }


    public void sortLettersLines(ArrayList<String> lettersLines){

        Collections.sort(lettersLines, new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {

                int indexT1 = t1.indexOf(' ');
                int indexT2 = t2.indexOf(' ');

                int compere = t1.substring(indexT1+1).compareTo(t2.substring(indexT2+1));

                return compere != 0 ? compere : t1.compareTo(t2);
            }
        });
    }

    @Test
    public void test1(){

        ArrayList<String> list = new ArrayList<>(Arrays.asList("a1 9 2 3 1", "z1 Act car", "zo4 47", "ab1 off KEY dog", "a8 act zoo", "g1 Act car"));

        List<String> result = reorderLines(10, list);

        Assert.assertEquals(result.size(), list.size());
    }

    public ArrayList<String> popularNFeaturesNot(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        ArrayList<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(possibleFeatures);
        Map<String, Integer> map = new HashMap<>();
        for(String request : featureRequests) {
            String[] split = request.split("\\W");
            HashSet<String> added = new HashSet<>();
            for(String s : split) {
                s = s.toLowerCase();
                if(set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while(!maxHeap.isEmpty() && topFeatures-- > 0) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }


    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        // WRITE YOUR CODE HERE
        HashMap<String, Integer> map = new HashMap<>();
        for (String feature : possibleFeatures){
            map.put(feature.toLowerCase(), 0);
        }

        for (String request : featureRequests){
            findFeature(request.toLowerCase(), map);
        }

        return findTopFeatures(new ArrayList<>(map.entrySet()), topFeatures);
    }

    private ArrayList<String> findTopFeatures(ArrayList<Map.Entry<String, Integer>> featuresList, int topFeatures){

        Collections.sort(featuresList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                int compare =  t2.getValue()-t1.getValue();

                return compare != 0 ? compare : t2.getKey().compareTo(t1.getKey());
            }
        });

        ArrayList<String> result = new ArrayList<>();

        int index = 0;
        while (index < featuresList.size() && index < topFeatures){
            result.add(featuresList.get(index++).getKey());
        }

        return result;
    }

    private void findFeature(String request, HashMap<String, Integer> map){

        HashSet<String> featuresSet = new HashSet<>();
        int indexStart = 0;
        int indexNext = indexStart+1;
        while (indexStart < request.length()){
            if (Character.isAlphabetic(request.charAt(indexStart))){
                while (indexNext < request.length() && Character.isAlphabetic(request.charAt(indexNext))){
                    indexNext++;
                }
                String tmp = request.substring(indexStart, indexNext);
                if (map.containsKey(tmp) && !featuresSet.contains(tmp)){
                    map.put(tmp, map.get(tmp)+1);
                    featuresSet.add(tmp);
                }
                indexStart = indexNext;
            }else {
                indexStart++;
                indexNext = indexStart+1;
            }
        }
    }

    @Test
    public void test(){

        ArrayList<String> features = new ArrayList<>(Arrays.asList("Waterproof", "battery", "alexa"));
        ArrayList<String> requests = new ArrayList<>(Arrays.asList("Waterproof he return value for a compare function should be -1, 0 or +1, not just 1 or 0. battery",
                "A Java 8 sort using Waterproof a lambda would be",
                "in place alexa of the if statement should do the job alexa",
                "in place of the if statement should do the job battery",
                "in place of the if statement should do the job Waterproof"));
        ArrayList<String> result = popularNFeatures(6, 2, features, 7, requests);

        Assert.assertEquals(result.size(), 2);
    }




}
