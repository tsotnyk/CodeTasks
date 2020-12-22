package com.j2core.sts.leetcode.com.gridIllumination;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int[] gridIlluminationTLE(int N, int[][] lamps, int[][] queries) {

        HashMap<Coordinate, HashSet<Coordinate>> illuminateMap = createIlluminationMap(N, lamps);
        int index = 0;
        int[] result = new int[queries.length];

        for (int[] query : queries){
            int illuminate = 0;
            Coordinate coordinate = new Coordinate(query[0],query[1]);
            if (illuminateMap.containsKey(coordinate)){
                illuminate = 1;
            }else {
                Set<Coordinate> set = illuminateMap.keySet();
                for (Coordinate lamp : set){
                    if (illuminateMap.get(lamp).contains(coordinate)){
                        illuminate = 1;
                        break;
                    }
                }
            }
            result[index] = illuminate;
            index++;

            ternOffLamp(illuminateMap, coordinate);
        }

        return result;
    }

    private void ternOffLamp(Map<Coordinate, HashSet<Coordinate>> illuminateMap, Coordinate coordinate) {

        illuminateMap.remove(coordinate);
        int x = coordinate.x;
        int y = coordinate.y;
        illuminateMap.remove(new Coordinate(x-1, y-1));
        illuminateMap.remove(new Coordinate(x-1,y));
        illuminateMap.remove(new Coordinate(x-1,y+1));
        illuminateMap.remove(new Coordinate(x,y-1));
        illuminateMap.remove(new Coordinate(x,y+1));
        illuminateMap.remove(new Coordinate(x+1,y-1));
        illuminateMap.remove(new Coordinate(x+1,y));
        illuminateMap.remove(new Coordinate(x+1,y+1));
    }

    private HashMap<Coordinate, HashSet<Coordinate>> createIlluminationMap(int n, int[][] lamps) {

        HashMap<Coordinate, HashSet<Coordinate>> illuminationMap = new HashMap<>();
        for (int[] lamp : lamps){
            HashSet<Coordinate> illumination = new HashSet<>();
            int x = lamp[0];
            int y = lamp[1];
            for (int i = 0; i < n; i++){
                illumination.add(new Coordinate(i, y));
                illumination.add(new Coordinate(x, i));
            }
            int j = Math.max(y-x, 0);
            for (int i = Math.max(x - y, 0); i < n && j < n; i++, j++){
                illumination.add(new Coordinate(i, j));
            }
            j = 0;
            for (int i = x+y; i > -1 && j < n; i--, j++){
                illumination.add(new Coordinate(i, j));
            }

            illuminationMap.put(new Coordinate(x,y), illumination);
        }
        return illuminationMap;
    }

    class Coordinate{

        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

        return null;
    }

    @Test
    public void test(){

        Assert.assertEquals(gridIllumination(5, new int[][]{{0,0},{0,4}}, new int[][]{{0,4},{0,1},{1,4}}), new int[]{1,1,0});
    }
}
