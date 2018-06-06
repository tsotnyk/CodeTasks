package com.j2core.sts.codefights.com.dataStructures.arrays.sudoku2;

public class Solution {

    boolean sudoku2(char[][] grid) {


        StringBuilder builder = new StringBuilder();

        for (char[] line : grid){
            for (char character : line) {
                if (character != '.') {
                    if (builder.indexOf(String.valueOf(character)) < 0) {
                        builder.append(character);
                    } else return false;
                }
            }
            builder.delete(0, builder.length());
        }

        for (int k = 0; k < grid.length; k++){
            for (int l = 0; l < grid.length; l++){
                if (grid[l][k] != '.'){
                    if (builder.indexOf(String.valueOf(grid[l][k])) < 0){
                        builder.append(grid[l][k]);
                    }else return false;
                }

            }
            builder.delete(0, builder.length());
        }

        for (int i = 0; i < 9; ){
            for (int j = 0; j < 9;){
                for (int k = 0; k < 3; k++ ) {
                    for (int l = 0; l < 3; l++) {
                        if (grid[j+k][i+l] != '.') {
                            if (builder.indexOf(String.valueOf(grid[j+k][i+l])) < 0) {
                                builder.append(grid[j+k][i+l]);
                            } else return false;
                        }
                    }
                }
                builder.delete(0, builder.length());
                j = j + 3;
            }
            i = i+3;
        }

        return true;

    }

}
