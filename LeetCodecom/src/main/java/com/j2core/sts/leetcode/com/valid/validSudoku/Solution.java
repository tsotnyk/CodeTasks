package com.j2core.sts.leetcode.com.valid.validSudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class Solution {

    public boolean isValidSudoku(char[][] board) {

        if (!validLines(board)){
            return false;
        }

        if (!validColumns(board)){
            return false;
        }

        return validSubBoxes(board);

    }

    private boolean validLines(char[][] board){

        for (int i = 0; i < 9; i++){
            HashSet<Character> set = new HashSet<>();
            int counter = 0;
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    counter++;
                    set.add(board[i][j]);
                }
            }
            if (set.size() != counter){
                return false;
            }
        }

        return true;
    }

    private boolean validColumns(char[][] board){

        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            int counter = 0;
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    counter++;
                    set.add(board[j][i]);
                }
            }
            if (set.size() != counter) {
                return false;
            }
        }
        return true;
    }

    private boolean validSubBoxes(char[][] board){

        int i = 0;
        int j = 0;

        while (j < 9){

            while (i < 9){
                HashSet<Character> set = new HashSet<>();
                int counter = 0;
                for (int k = i; k < i+3; k++){
                    for (int l = j; l < j+3; l++){
                        if (board[k][l] != '.') {
                            counter++;
                            set.add(board[k][l]);
                        }
                    }
                }
                if (set.size() != counter) {
                    return false;
                }
                i += 3;
            }
            j += 3;
            i = 0;
        }

        return true;
    }

    @Test
    public void test(){


        boolean result = isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}});

        Assert.assertFalse(result);
    }
}
