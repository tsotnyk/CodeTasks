package com.j2core.sts.codefights.com.dataStructures.graphs.feedingTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    int feedingTime(String[][] classes) {

        HashMap<Integer, List<Integer>> classConnections = createGraph(createClassAnimalList(classes), classes.length);
        int[] paintedClass = new int[classes.length];
        paintedClass[0] = 1;
        int nextColor = 2;
        for (int i = 1; i < classes.length; i++){
            nextColor = painteClass(i, classConnections, paintedClass, nextColor);
            if (nextColor > 6) return -1;
        }

        return nextColor-1;
    }

    private int painteClass(int node, HashMap<Integer, List<Integer>> classConnections, int[] paintedClass, int nextColor){

        HashSet<Integer> colored = new HashSet<>();

        for (int connectClass : classConnections.get(node)){
            if (paintedClass[connectClass] > 0){
                colored.add(paintedClass[connectClass]);
            }
        }
        for (int i = 1; i < nextColor; i++){
            if (!colored.contains(i)){
                paintedClass[node] = i;
                return nextColor;
            }
        }

        paintedClass[node] = nextColor;
        return nextColor+1;
    }

    private HashMap<Integer, List<Integer>> createGraph(HashMap<Integer, HashSet<String>> classMap, int countClasses){

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < countClasses; i++){
            map.put(i, new LinkedList<>());
        }
        for (int i = 0; i < countClasses-1; i++){
            HashSet<String> animalSet1 = classMap.get(i);
            for (int j = i+1; j < countClasses; j++){
                HashSet<String> animalSet2 = classMap.get(j);
                for (String animal : animalSet2){
                    if (animalSet1.contains(animal)){
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
                }
            }
        }

        return map;
    }

    private HashMap<Integer, HashSet<String>> createClassAnimalList(String[][] classes){

        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < classes.length; i++){
            HashSet<String> animalList = new HashSet<>(Arrays.asList(classes[i]));
            map.put(i, animalList);
        }

        return map;
    }


    int feedingTimeUncorrect(String[][] classes) {

        List<TreeSet<String>> animalsDayVisit = new LinkedList<>();

        for (String[] childrenClass : classes){
            TreeSet<String> day = null;
            for (TreeSet<String> visitDay : animalsDayVisit){
                boolean animalFree = true;
                for (String animal : childrenClass){
                    if (visitDay.contains(animal)){
                        animalFree = false;
                        break;
                    }
                }
                if (animalFree){
                    day = visitDay;
                    break;
                }
            }
            if (day == null){
                day = new TreeSet<>();
                Collections.addAll(day, childrenClass);
                animalsDayVisit.add(day);
            }else {
                Collections.addAll(day, childrenClass);
            }
//            if (animalsDayVisit.size() > 5) return -1;
        }

        return animalsDayVisit.size();
    }

    int feedingTimeOld(String[][] classes) {

        if (classes.length == 1) return 1;

        HashMap<String, Integer> animalMap = new HashMap<>();
        int maxDays = 0;
        for (String[] oneClass : classes){
            for (String animal : oneClass){
                int countDays = animalMap.getOrDefault(animal, 0)+1;
                if (countDays > 5) return -1;
                animalMap.put(animal, countDays);
                maxDays = Math.max(maxDays, countDays);
            }
        }
        return maxDays;
    }

    int feedingTime1(String[][] classes) {

        int length = classes.length;
        ArrayList<HashSet<String>> zooDay = new ArrayList<>();
        List<String[]> notVisitedClass = new LinkedList<>();

        for (String[] oneClass : classes){
            int days = 0;
            for (HashSet<String> day : zooDay){
                for (String animal : oneClass){
                    if (day.contains(animal)){
                        days++;
                        break;
                    }
                }
            }

            if (days == zooDay.size()){
                HashSet<String> newDay = new HashSet<>();
                Collections.addAll(newDay, oneClass);
                zooDay.add(newDay);
            }else {
                notVisitedClass.add(oneClass);
            }
        }

        int size = notVisitedClass.size();
        ArrayList<String[]> nextList = new ArrayList<>();

        while (size > 0){
            for (String[] visitedClass : notVisitedClass) {
                int days = 0;
                boolean[] notMatch = new boolean[zooDay.size()];
                for (int j = 0; j < zooDay.size(); j++) {
                    for (String animal : visitedClass) {
                        if (zooDay.get(j).contains(animal)) {
                            days++;
                            notMatch[j] = true;
                            break;
                        }
                    }
                }

                if (days == zooDay.size()) {
                    HashSet<String> newDay = new HashSet<>();
                    Collections.addAll(newDay, visitedClass);
                    zooDay.add(newDay);
                } else if (days == zooDay.size()-1) {
                    int index = -1;
                    for (int i = 0; i < notMatch.length; i++){
                        if (!notMatch[i]){
                            index = i;
                            break;
                        }
                    }
                    Collections.addAll(zooDay.get(index), visitedClass);
                } else {
                    nextList.add(visitedClass);
                }
            }
            size = nextList.size();
            notVisitedClass = nextList;
            nextList = new ArrayList<>();
        }

        return 0;
    }

    int feedingTimeExample(String[][] classes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < classes.length; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < classes.length; i++) {
            for (int j = i+1; j < classes.length; j++) {
                if (areClassesConnected(classes[i], classes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int[] colors = new int[graph.size()];
        colors[0] = 1;
        findChrome(1, colors, graph, 1);
        return colorsUsed == 6 ? -1 : colorsUsed;
    }

    int colorsUsed = 6;
    private void findChrome(int node, int[] colors, List<List<Integer>> graph, int maxUsed) {
        if (maxUsed >= colorsUsed) return;
        if (node >= graph.size()) colorsUsed = maxUsed;
        else {
            boolean[] used = new boolean[colorsUsed+1];
            graph.get(node).forEach(adj -> used[colors[adj]] = true);
            for (int c = 1; c < colorsUsed; c++) {
                if (used[c]) continue;
                colors[node] = c;
                findChrome(node+1, colors, graph, Math.max(maxUsed, c));
            }
        }
    }

    private boolean areClassesConnected(String[] arr, String[] brr) {
        for (String s : arr) {
            for (String j : brr) {
                if (s.equals(j)) return true;
            }
        }
        return false;
    }

    @Test
    public void test(){

        Assert.assertEquals(feedingTime(new String[][]{{"aa","ab","ac","ad","ae","af","ag","ah"},
                {"aa","ai","aj","ba","bb","bc","bd","be"},
                {"bf","bg","bh","bi","bj","ca","cb","cc"},
                {"ab","bf","cd","ce","cf","cg","ch","ci","cj"},
                {"ac","ai","bg","da","db","dc","dd","de","df","dg"},
                {"aj","cd","da","dh","di","dj","ea","eb","ec","ed"},
                {"ad","bh","ee","ef","eg","eh","ei","ej","fa"},
                {"ba","bi","ce","db","dh","ee","fb","fc","fd"},
                {"ae","bj","cf","ef","fb","fe","ff","fg","fh","fi"},
                {"bb","ca","cg","dc","di","fe","fj","ga","gb"},
                {"af","dd","dj","eg","fc","ff","gc","gd","ge"},
                {"bc", "cb", "ch", "de", "ea", "eh", "fd", "fg"},
                {"bd", "cc", "ci", "eb", "ei", "fh", "fj", "gc"},
                {"ag", "be", "cj", "df", "ec", "ej", "fi", "ga", "gd"},
                {"ah", "dg", "ed", "fa", "gb", "ge"}}), 5);

        Assert.assertEquals(feedingTime(new String[][]{{"Tiger", "Lima", "Frog"},{"Tiger", "Zebra","Lion"},{"Tiger", "Rabbit"},{"Emu", "Zebra", "Rabbit"}}), 3);
        Assert.assertEquals(feedingTime(new String[][]{{"Tiger", "Lima", "Frog"},{"Tiger", "Zebra", "Lion"},{"Tiger", "Rabbit"},{"Lima", "Zebra", "Rabbit"}}), 4);
        Assert.assertEquals(feedingTime(new String[][]{{"Lion", "Emu"},{"Giraffe", "Peacock"},{"Lima"},{"Tiger", "Cheetah", "Slugs"},{"Snakes", "Sealion"}}), 1);

    }
}
