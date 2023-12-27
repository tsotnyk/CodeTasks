package com.j2core.sts.leetcode.com.sudokuSolver;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public void solveSudoku(char[][] board) {

        HashMap<Integer, HashSet<Character>> xMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> yMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> blockMap = new HashMap<>();

        parseBoard(board, xMap, yMap, blockMap);

        solveSudoku(board, xMap, yMap, blockMap, 0, 0);

    }

    private boolean solveSudoku(char[][] board, HashMap<Integer, HashSet<Character>> xMap, HashMap<Integer, HashSet<Character>> yMap,
                             HashMap<Integer, HashSet<Character>> blockMap, int x, int y) {

        if (x >= 9) return true;

        if (y >= 9) return solveSudoku(board, xMap, yMap, blockMap, x+1, 0);

        if (board[x][y] != '.') return solveSudoku(board, xMap, yMap, blockMap, x, y+1);

        int blockId = getBlockId(x, y);

        for (char candidate = '1'; candidate <= '9'; candidate++){

            if (validateCandidate(candidate, xMap, yMap, blockMap, x, y, blockId)){
                board[x][y] = candidate;
                xMap.get(x).add(candidate);
                yMap.get(y).add(candidate);
                blockMap.get(blockId).add(candidate);

                if (solveSudoku(board, xMap, yMap, blockMap, x, y+1)){
                    return true;
                }

                xMap.get(x).remove(candidate);
                yMap.get(y).remove(candidate);
                blockMap.get(blockId).remove(candidate);
                board[x][y] = '.';
            }

        }

        return false;
    }

    private boolean validateCandidate(char candidate, HashMap<Integer, HashSet<Character>> xMap, HashMap<Integer, HashSet<Character>> yMap,
                                      HashMap<Integer, HashSet<Character>> blockMap, int x, int y, int block){

        if (xMap.get(x).contains(candidate)) return false;
        if (yMap.get(y).contains(candidate)) return false;
        return !blockMap.get(block).contains(candidate);
    }

    private void parseBoard(char[][] board, HashMap<Integer, HashSet<Character>> xMap, HashMap<Integer, HashSet<Character>> yMap,
                            HashMap<Integer, HashSet<Character>> blockMap){

        for (int i = 0; i < 9; i++){
            xMap.put(i, new HashSet<>());
            yMap.put(i, new HashSet<>());
            blockMap.put(i, new HashSet<>());
        }


        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                char sym = board[x][y];
                if ( sym != '.'){
                    xMap.get(x).add(sym);
                    yMap.get(y).add(sym);
                    blockMap.get(getBlockId(x, y)).add(sym);
                }
            }
        }
    }

    private int getBlockId(int x, int y){
        if (x/3 == 0){
            if (y/3 == 0){
                return 0;
            }else if (y/3 == 1){
                return 1;
            }else {
                return 2;
            }
        }else if (x/3 == 1){
            if (y/3 == 0){
                return 3;
            }else if (y/3 == 1){
                return 4;
            }else {
                return 5;
            }
        }else {
            if (y/3 == 0){
                return 6;
            }else if (y/3 == 1){
                return 7;
            }else {
                return 8;
            }
        }
    }


}
