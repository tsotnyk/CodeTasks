package com.j2core.sts.leetcode.com.graphs.connectingCitiesWithMinimumCost;

import java.util.*;

public class Solution {
    Map<Integer, List<DestinationWeights>> graph;
    Set<Integer> seen;
    Queue<DestinationWeights> bfsQueue;
    public int minimumCost(int N, int[][] connections) {
        graph = new HashMap<Integer, List<DestinationWeights>>();
        seen = new HashSet<Integer>();
        buildGraph(N, connections);
        bfsQueue = new PriorityQueue<DestinationWeights>((d1, d2) -> d1.w - d2.w);
        int minDistanceReq = 0;
        DestinationWeights bootStrap = new DestinationWeights(1, 0);
        bfsQueue.offer(bootStrap);
        while(!bfsQueue.isEmpty()){
            if(seen.size() == N){
                return minDistanceReq;
            } else {
                DestinationWeights currDest = bfsQueue.poll();
                if(!seen.contains(currDest.to)){
                    minDistanceReq += currDest.w;
                    List<DestinationWeights> neighbors = graph.get(currDest.to);
                    bfsQueue.addAll(neighbors);
                    seen.add(currDest.to);
                }
            }
        }

        return seen.size() == N ? minDistanceReq : -1;
    }

    public void buildGraph(int N, int[][] connections){
        for(int i=1; i<= N; i++){
            graph.put(i, new ArrayList<DestinationWeights>());
        }

        for(int r=0; r<connections.length;r++){
            int from = connections[r][0];
            int to = connections[r][1];
            int w = connections[r][2];

            DestinationWeights fromtoTo = new DestinationWeights(to, w);
            DestinationWeights toToFrom = new DestinationWeights(from, w);

            graph.get(from).add(fromtoTo);
            graph.get(to).add(toToFrom);
        }
    }
}

class DestinationWeights{
    int to;
    int w;
    public DestinationWeights(int to, int w){
        this.to = to;
        this.w = w;
    }
}

