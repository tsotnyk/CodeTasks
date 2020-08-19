package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter4;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution4_7 {

    private String getUnVisitedNode(Map<String, Boolean> visitedMap){

        for (Map.Entry<String, Boolean> node : visitedMap.entrySet()){
            if (node.getValue() == null) return node.getKey();
        }

        return null;
    }

    private Map<String, List<String>> createGraph(List<String> projects, List<String[]> dependencies, Map<String, Boolean> visitedMap){

        Map<String, List<String>> graph = new HashMap<>();

        for (String node : projects){
            graph.put(node, new LinkedList<>());
            visitedMap.put(node, null);
        }

        for (String[] dependency : dependencies){

            graph.get(dependency[1]).add(dependency[0]);
        }

        return graph;
    }

    public List<String> sortProjects(List<String> projects, List<String[]> dependencies){

        List<String> sortedProjects = new LinkedList<>();
        Map<String, Boolean> visitedMap = new HashMap<>();
        Map<String, List<String>> graph = createGraph(projects, dependencies, visitedMap);
        Stack<String> stack = new Stack<>();

        String node = getUnVisitedNode(visitedMap);
        while (node != null){

            stack.push(node);
            visitedMap.put(node, false);
            while (!stack.isEmpty()){
                node = stack.peek();
                List<String> nodeDependencies = graph.get(node);
                boolean endPath = true;
                for (String dependency : nodeDependencies){
                    Boolean visitedNode = visitedMap.get(dependency);
                    if (visitedNode == null){
                        visitedMap.put(dependency, false);
                        stack.push(dependency);
                        endPath = false;
                    }else if (!visitedNode) return null;
                }
                if (endPath){
                    sortedProjects.add(stack.pop());
                    visitedMap.put(node, true);
                }
            }
            node = getUnVisitedNode(visitedMap);
        }

        return sortedProjects;
    }

    @Test
    public void test(){

        List<String> projects = new LinkedList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        List<String[]> dependencies1 = new LinkedList<>(Arrays.asList(new String[]{"a","d"}, new String[]{"f","b"},
                new String[]{"b","d"}, new String[]{"f","a"}, new String[]{"d","c"}));
        List<String[]> dependencies2 = new LinkedList<>(Arrays.asList(new String[]{"a","d"}, new String[]{"f","b"},
                new String[]{"b","d"}, new String[]{"f","a"}, new String[]{"d","c"}, new String[]{"c","b"}));

        Assert.assertNotNull(sortProjects(projects, dependencies1));
        Assert.assertNull(sortProjects(projects, dependencies2));
    }
}
