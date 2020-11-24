package com.j2core.sts.leetcode.com.findPositiveIntegerSolutionForGivenEquation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> findSolutionSlow(CustomFunction customfunction, int z) {

        List<List<Integer>> pairList = new LinkedList<>();
        int x = 1;
        int y = 1;

        while (x <= 1000){
            while (y <= 1000) {
                int functionResult = customfunction.f(x, y);
                if (functionResult > z) break;
                if (functionResult == z){
                    pairList.add(new LinkedList<>(Arrays.asList(x,y)));
                    break;
                }
                y++;
            }
            y = 1;
            x++;
        }

        return pairList;
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {

        List<List<Integer>> pairList = new LinkedList<>();
        int x = 1;
        int y = 1;

        while (true){
            int functionResult = customfunction.f(x,y);
            if (functionResult > z) break;
            while (y <= 1000){
                if (functionResult > z) break;
                if (functionResult == z){
                    pairList.add(new LinkedList<>(Arrays.asList(x,y)));
                    break;
                }
                y++;
                functionResult = customfunction.f(x,y);
            }
            x++;
            y = 1;
        }

        return pairList;
    }
}

class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
            // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
            public int f(int x, int y){
                return 0;
            }
 }
