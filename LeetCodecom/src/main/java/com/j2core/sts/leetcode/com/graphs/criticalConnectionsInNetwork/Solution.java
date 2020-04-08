package com.j2core.sts.leetcode.com.graphs.criticalConnectionsInNetwork;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> result = new LinkedList<>();
        Graph graph = createGraph(n, connections);
        
        for (List<Integer> connection : connections){
            int fists = connection.get(0);
            int second = connection.get(1);
            graph.removeEdge(fists, second);
            graph.removeEdge(second, fists);
            if (graph.isBrokenRoute(n)){
                result.add(connection);
            }
            graph.addEdge(fists, second);
            graph.addEdge(second, fists);
        }

        return result;
    }
    
    private Graph createGraph(int n, List<List<Integer>> connections){
        
        Graph graph = new Graph(n);
        for (List<Integer> list : connections){
            int first = list.get(0);
            int second = list.get(1);
            graph.addEdge(first, second);
            graph.addEdge(second, first);
        }
        
        return graph;
    }

    @Test
    public void test(){

//        List<List<Integer>> root = new LinkedList<>();
//        List<Integer> one = new LinkedList<>(Arrays.asList(0,1));
//        List<Integer> two = new LinkedList<>(Arrays.asList(1,2));
//        List<Integer> three = new LinkedList<>(Arrays.asList(2,0));
//        List<Integer> four = new LinkedList<>(Arrays.asList(1,3));
//        List<Integer> five = new LinkedList<>(Arrays.asList(3,4));
//        List<Integer> six = new LinkedList<>(Arrays.asList(4,5));
//        List<Integer> seven = new LinkedList<>(Arrays.asList(5,3));
//
//        root.add(one);
//        root.add(three);
//        root.add(two);
//        root.add(four);
//        root.add(five);
//        root.add(seven);
//        root.add(six);
//
//        List<List<Integer>> result = criticalConnections(6, root);
//
//        Assert.assertEquals(result.size(), 1);

        List<List<Integer>> root = new LinkedList<>();
        List<Integer> one = new LinkedList<>(Arrays.asList(0,1));
        List<Integer> two = new LinkedList<>(Arrays.asList(1,2));
        List<Integer> three = new LinkedList<>(Arrays.asList(2,0));
        List<Integer> four = new LinkedList<>(Arrays.asList(1,3));
        root.add(one);
        root.add(three);
        root.add(two);
        root.add(four);

        List<List<Integer>> result = criticalConnections(4, root);

        Assert.assertEquals(result.size(), 1);
    }
}

class Graph{

    private int size;
    private ArrayList<ArrayList<Integer>> adj;

    public Graph(int size) {
        this.size = size;
        adj = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            adj.add(new ArrayList<>(size));
        }
    }

    public void addEdge(int index, int value){
        adj.get(index).add(value);
    }

    public void removeEdge(int index, Integer value){
        adj.get(index).remove(value);
    }

    public boolean isBrokenRoute(int size){

        boolean[] visited = new boolean[size];
        int counter = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while (!stack.isEmpty()){
            int current = stack.pop();
            ArrayList<Integer> routs = adj.get(current);
            for (int i = 0; i < routs.size(); i++){
                if (!visited[routs.get(i)]){
                    stack.add(routs.get(i));
                    visited[routs.get(i)] = true;
                    counter++;
                }
            }
        }

        return counter != size;
    }
}


