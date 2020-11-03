package com.j2core.sts.leetcode.com.shortestPathToGetAllKeys;

import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    public int shortestPathAllKeys(String[] grid) {

        List<WalkRoad> result = new LinkedList<>();
        List<WalkRoad> steps = new LinkedList<>(Collections.singletonList(findStartPoint(grid)));
        List<WalkRoad> nextSteps = new LinkedList<>();
        while (!steps.isEmpty()){
            WalkRoad step = steps.remove(0);
//            if ()
        }

        return 0;
    }

    private WalkRoad findStartPoint(String[] grid){

        int size = 0;
        int iIndex = -1;
        int jIndex = -1;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length(); j++){
                char symbol = grid[i].charAt(j);
                switch (symbol){
                    case '@':
                        iIndex = i;
                        jIndex = j;
                        break;
                    case '.':
                    case '#':
                        continue;
                    default:
                        if (Character.isLowerCase(symbol)){
                            size++;
                        }
                }
            }
        }

        return new WalkRoad(iIndex, jIndex, size);
    }

    class WalkRoad{

        int i;
        int j;
        Set<Character> keys;
        int lengthOfRoad;
        int amountKey;
        int findKey;

        public WalkRoad(int i, int j, int size){
            this.i = i;
            this.j = j;
            this.keys = new HashSet<>();
            this.lengthOfRoad = 0;
            this.amountKey = size;
            this.findKey = 0;
        }

        public WalkRoad(int i, int j, WalkRoad prevRoad){
            this.i = i;
            this.j = j;
            this.keys = new HashSet<>(prevRoad.keys);
            this.lengthOfRoad = prevRoad.lengthOfRoad+1;
            this.amountKey = prevRoad.amountKey;
            this.findKey = prevRoad.findKey;
        }

        public List<WalkRoad> nextSteps(WalkRoad point){

            List<WalkRoad> list = new LinkedList<>();

            list.add(new WalkRoad(point.i-1, point.j, point));
            list.add(new WalkRoad(point.i+1, point.j, point));
            list.add(new WalkRoad(point.i, point.j-1, point));
            list.add(new WalkRoad(point.i, point.j+1, point));

            return list;
        }
    }

    @Test
    public void test(){

        int a = (int) 'b';
        int A = (int) 'B';

        System.out.println(a+A);
    }
}
