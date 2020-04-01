package com.j2core.sts.leetcode.com.string.wordSearch;


public class Solution {

    public boolean exist(char[][] board, String word){

        for (int i = 0; i < board.length; i++){

            for (int j = 0; j < board[i].length; j++){

                if (board[i][j] == word.charAt(0)){

                    if (findWord(board, i, j, word)){

                        return true;
                    }
                }
            }
        }

        return false;
    }


    private boolean findWord(char[][] board, int i, int j, String word){


        return false;

    }
}
