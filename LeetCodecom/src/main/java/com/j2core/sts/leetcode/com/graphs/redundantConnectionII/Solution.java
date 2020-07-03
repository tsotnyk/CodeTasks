package com.j2core.sts.leetcode.com.graphs.redundantConnectionII;

import org.testng.annotations.Test;

import java.util.*;

public class Solution {


//    public int[] findRedundantDirectedConnectionTimeLimit(int[][] edges) {
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        for (int[] array: edges){
//            if(map.containsKey(array[0])){
//                map.get(array[0]).add(array[1]);
//            }else {
//                map.put(array[0], new ArrayList<>(Arrays.asList(array[1])));
//            }
//            if (!map.containsKey(array[1])){
//                map.put(array[1], new ArrayList<>());
//            }
//        }
//
//        for (int i = edges.length-1; i > -1; i--) {
//            if (findEdges(map, edges[i])) return edges[i];
//        }
//        return null;
//    }
//
//    private boolean findEdges(Map<Integer, List<Integer>> map, int[] notUse){
//
//        List<Integer> list = map.get(notUse[0]);
//        list.remove(new Integer(notUse[1]));
//        int node = 1;
//        boolean result = visitAll(map, node++);
//        while (node <= map.size() && !result){
//            result = visitAll(map, node++);
//        }
//
//        if (result) return true;
//
//        map.get(notUse[0]).add(notUse[1]);
//        return false;
//    }
//
//    private boolean visitAll(Map<Integer, List<Integer>> map, int root){
//
//        boolean[] visited = new boolean[map.size()+1];
//        LinkedList<Integer> queue = new LinkedList<>();
//        queue.add(root);
//        visited[root] = true;
//
//        while (!queue.isEmpty()){
//            int node = queue.removeFirst();
//            List<Integer> list = map.get(node);
//            for (int nextNode : list){
//                if (visited[nextNode]){
//                    break;
//                }else {
//                    queue.add(nextNode);
//                    visited[nextNode] = true;
//                }
//            }
//        }
//
//        for (int i = 1; i < visited.length; i++){
//            if (!visited[i]) return false;
//        }
//        return true;
//    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        parent = new int[edges.length+1];
        List<Integer> parents [] = new List[edges.length+1];
        for(int i = 0;i<parents.length;i++) parents[i] = new ArrayList<>();

        for(int [] edge:edges) {
            parents[edge[1]].add(edge[0]);
            if(parents[edge[1]].size() == 2) {
                for(int j = 1;j>=0;j--) {
                    int [] redundant = {parents[edge[1]].get(j), edge[1]};
                    if(isValidWithoutEdge(redundant, edges)) {
                        return redundant;
                    }
                }
            }
        }

        return findAnyInvalidEdge(edges);
    }

    int parent [] ;

    int [] findAnyInvalidEdge(int [][] edges) {


        for(int i = 0;i<parent.length;i++) parent[i] = i;

        for(int [] edge:edges) {
            int p1 = getParent(parent, edge[0]);
            int p2 = getParent(parent, edge[1]);

            if(p1 == p2 ||p2 != edge[1]) return edge;

            parent[p2] = p1;
        }

        return edges[edges.length-1];
    }

    boolean isValidWithoutEdge(int [] redundant, int [][] edges) {
        //int parent [] = new int[edges.length+1];
        for(int i = 0;i<parent.length;i++) parent[i] = i;

        for(int edge[]:edges) {
            if(edge[0] == redundant[0] && edge[1] == redundant[1]) continue;
            int p1 = getParent(parent, edge[0]);
            int p2 = getParent(parent, edge[1]);

            parent[p2] = p1;
        }

        for(int i = 2;i<parent.length;i++) {
            if(getParent(parent, i) != getParent(parent, i-1)) return false;
        }
        return true;
    }

    int getParent(int [] parent, int v) {
        int p = parent[v];
        while(p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Test
    public void test(){

        int[] result1 = findRedundantDirectedConnection(new int[][]{{1,2},{1,3},{2,3}});
        int[] result2 = findRedundantDirectedConnection(new int[][]{{1,2},{2,3},{3,4},{4,1},{1,5}});
        int[] result3 = findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}});
        System.out.println("Yes");

    }
}
