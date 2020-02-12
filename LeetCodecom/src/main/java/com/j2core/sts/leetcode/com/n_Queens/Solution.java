package com.j2core.sts.leetcode.com.n_Queens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

        public List<List<String>> solveNQueens(int n) {

            char[][] board = new char[n][n];
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++){
                    board[i][j] = '.';
                }
            }
            List<List<String>> result = new ArrayList<>();
            findSolution(board, 0, result);
            return result;
        }

        private void findSolution(char[][] board, int colIndex, List<List<String>> result) {
            if(colIndex == board.length) {
                result.add(createValueList(board));
                return;
            }

            for(int i = 0; i < board.length; i++) {
                if(validate(board, i, colIndex)) {
                    board[i][colIndex] = 'Q';
                    findSolution(board, colIndex + 1, result);
                    board[i][colIndex] = '.';
                }
            }
        }

        private boolean validate(char[][] board, int x, int y) {
            for(int i = 0; i < y; i++) {
                if(board[x][i]=='Q')
                    return false;
            }
            for(int i = x,j=y; i >=0 && j>=0; i--,j--) {
                if(board[i][j]=='Q')
                    return false;
            }
            for(int i = x,j=y; j>=0 && i <board.length; i++,j--) {
                if(board[i][j]=='Q')
                    return false;
            }

            return true;
        }

        private List<String> createValueList(char[][] board) {
            List<String> res = new LinkedList<>();
            for (char[] chars : board) {
                String s = new String(chars);
                res.add(s);
            }
            return res;
        }
}
