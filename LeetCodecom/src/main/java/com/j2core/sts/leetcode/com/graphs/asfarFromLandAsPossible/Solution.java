package com.j2core.sts.leetcode.com.graphs.asfarFromLandAsPossible;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int maxDistance1(int[][] grid) {

        int result = -1;
        int[][] path = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    result = Math.max(result, maxLength(grid, i, j, path));
                }
            }
        }

        return result;
    }

    private int maxLength(int[][] grid, int i, int j, int[][] path){

        int maxLength = -1;

        pathUp(grid, i, j, path);
        pathDown(grid, i, j, path);

        for (int k = 0; k < path.length; k++){
            for (int l = 0; l < path[0].length; l++){
                if (path[k][l] > 0){
                    maxLength = Math.max(maxLength, path[k][l]);
                }
            }
        }
        return maxLength;
    }

    private void pathUp(int[][] grid, int i, int j, int[][] path){

    }
    private void pathDown(int[][] grid, int i, int j, int[][] path){

        for (int k = i; k < grid.length; k++){
            for (int l = j; l < grid[0].length; l++){
                if (k != i && l != j){
                    if (grid[k][l] != grid[i][j]){

                    }
                }
            }
        }
    }

    public int maxDistance(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int[][] minDistancesFromLand = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row ++ ) {
            for (int column = 0; column < grid[0].length; column ++) {
                minDistancesFromLand[row][column] = Integer.MAX_VALUE;
            }
        }

        List<String> bfsSources = new ArrayList<>();
        for (int row = 0; row < grid.length; row ++ ) {
            for (int column = 0; column < grid[0].length; column ++) {
                if (grid[row][column] == 1) {  // if it's piece of land
                    bfsSources.add(row + ";" + column);
                }
            }
        }

        exploreDistancesFromLand(bfsSources, grid, minDistancesFromLand);

        // find max min distance
        int result = -1;
        for (int row = 0; row < grid.length; row ++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 0) { // if it's water
                    result = Math.max(minDistancesFromLand[row][column], result);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1: result;
    }

    private void exploreDistancesFromLand(List<String> currentLayer, int[][] grid, int[][] minDistancesFromLand) {
        int distance = 0;
        Set<String> visitedPositions = new HashSet<>();

        while (!currentLayer.isEmpty()) {
            List<String> nextLayer = new ArrayList<>();

            for (String key: currentLayer) {
                int row = Integer.parseInt(key.split(";") [0]);
                int column = Integer.parseInt(key.split(";") [1]);

                if (!visitedPositions.contains(key)) {
                    if (row >= 0 && row < minDistancesFromLand.length && column >=0 && column < minDistancesFromLand[0].length) {
                        minDistancesFromLand[row][column] = Math.min(distance, minDistancesFromLand[row][column]);
                        visitedPositions.add(key);

                        // add to next layer
                        nextLayer.add((row + 1) + ";" + column);
                        nextLayer.add((row - 1) + ";" + column);
                        nextLayer.add(row + ";" + (column + 1));
                        nextLayer.add(row + ";" + (column - 1));
                    }
                }
            }
            currentLayer = nextLayer;
            distance++;
        }
    }
}
