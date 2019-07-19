package com.j2core.sts.leetcode.com.cheapestFlightsWithinKStops;

import java.util.*;

public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        Map<Integer, List<int[]>> flightMap = createMap(flights);

        int result = -1;
        List<int[]> stopPoints = new LinkedList<>();

        if (flightMap.containsKey(src)){

            List<int[]> tmpList = flightMap.get(src);
            for (int[] tmp : tmpList){
                int[] newPoint = new int[]{tmp[0], tmp[1], K-1};
                stopPoints.add(newPoint);
            }

            while (!stopPoints.isEmpty()){

                int[] stop = stopPoints.remove(0);

                if (stop[0] == dst){
                    if (result == -1 || result > stop[1]){
                        result = stop[1];
                    }
                } else if (stop[2] > -1) {

                    tmpList = flightMap.get(stop[0]);

                    if (tmpList != null) {
                        for (int[] tmp : tmpList) {

                            int prise = stop[1]+tmp[1];

                            if (result == -1 || prise < result) {
                                int[] newPoint = new int[]{tmp[0], stop[1] + tmp[1], stop[2] - 1};
                                stopPoints.add(newPoint);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    private Map<Integer, List<int[]>> createMap(int[][] flights){

        Map<Integer, List<int[]>> result = new HashMap<>();

        for (int[] city : flights){
            int[] tmpNextCity = new int[]{city[1], city[2]};
            if (result.containsKey(city[0])){
                result.get(city[0]).add(tmpNextCity);
            }else {
                List<int[]> tmpList = new LinkedList<>();
                tmpList.add(tmpNextCity);
                result.put(city[0], tmpList);
            }
        }

        return result;
    }
}
