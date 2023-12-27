package com.j2core.sts.leetcode.com.valid.validSudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1 {

    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer, HashSet<Character>> xMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> yMap = new HashMap<>();

        for (int i = 0; i < 9; i++){
            xMap.put(i, new HashSet<>());
            yMap.put(i, new HashSet<>());
        }

        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                char sym = board[x][y];
                if (y%3 == 1 && x%3 == 1){
                    if (!validateBlock(board, x, y)) return false;
                }
                if (sym == '.') continue;
                if (!xMap.get(x).add(sym)) return false;
                if (!yMap.get(y).add(sym)) return false;

            }
        }

        return true;
    }

    private boolean validateBlock(char[][] board, int x, int y) {

        HashSet<Character> block = new HashSet<>();

        block.add(board[x][y]);

        if (board[x-1][y-1] != '.') if (!block.add(board[x-1][y-1])) return false;
        if (board[x-1][y] != '.') if (!block.add(board[x-1][y])) return false;
        if (board[x-1][y+1] != '.') if (!block.add(board[x-1][y+1])) return false;
        if (board[x][y-1] != '.') if (!block.add(board[x][y-1])) return false;
        if (board[x][y+1] != '.') if (!block.add(board[x][y+1])) return false;
        if (board[x+1][y-1] != '.') if (!block.add(board[x+1][y-1])) return false;
        if (board[x+1][y] != '.') if (!block.add(board[x+1][y])) return false;
        if (board[x+1][y+1] != '.') return block.add(board[x + 1][y + 1]);

        return true;
    }

    @Test
    public void test(){

        boolean result2 = isValidSudoku(new char[][]{
                {'7','.','.','.','4','.','.','.','.'},
                {'.','.','.','8','6','5','.','.','.'},
                {'.','1','.','2','.','.','.','.','.'},
                {'.','.','.','.','.','9','.','.','.'},
                {'.','.','.','.','5','.','5','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}});

        Assert.assertFalse(result2);

//        boolean result1 = isValidSudoku(new char[][]{
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}});
//
//        Assert.assertTrue(result1);
//
//        boolean result = isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}});
//
//        Assert.assertFalse(result);
    }
}
