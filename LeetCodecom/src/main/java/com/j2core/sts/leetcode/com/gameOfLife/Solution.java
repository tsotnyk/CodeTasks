package com.j2core.sts.leetcode.com.gameOfLife;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public void gameOfLife(int[][] board) {

        int iLength = board.length;
        int jLength = board[0].length;
        List<IndexEntry> indexesList = new LinkedList<>();

        for (int i = 0; i < iLength; i++){

            for (int j = 0; j < jLength; j++){

                int neighbors = createNeighborsArray(i, j, iLength, jLength, board);
                int node = board[i][j];
                if (node < 1){

                    if (neighbors == 3){
                        indexesList.add(new IndexEntry(i, j, 1));
                    }

                }else {

                    if (neighbors < 2){
                        indexesList.add(new IndexEntry(i, j, 0));
                    }else if (neighbors > 3){
                        indexesList.add(new IndexEntry(i, j, 0));
                    }

                }
            }
        }

        for (IndexEntry entry : indexesList){

            board[entry.i][entry.j] = entry.value;
        }
    }




    private int createNeighborsArray(int i, int j, int iLength, int jLength, int[][] board){

        int amountNeighbor = 0;
        int index = 0;
        int value;

        while (index < 8){

            value = -1;
            switch (index){
                case 0: if (j-1 > -1) value = board[i][j - 1];
                        break;
                case 1: if (j+1 < jLength) value = board[i][j+1];
                        break;
                case 2: if (i-1 > -1 && j-1 > -1) value = board[i-1][j-1];
                        break;
                case 3: if (i-1> -1) value = board[i-1][j];
                        break;
                case 4: if (i-1 > -1 && j+1 < jLength) value = board[i-1][j+1];
                        break;
                case 5: if (i+1 < iLength && j-1 > -1) value = board[i+1][j-1];
                        break;
                case 6: if (i+1 < iLength) value = board[i+1][j];
                        break;
                case 7: if (i+1 < iLength && j+1 < jLength) value = board[i+1][j+1];
                        break;
            }

            if (value > 0) amountNeighbor++;
            index++;
        }

        return amountNeighbor;
    }

    @Test
    public void test(){

        gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});

    }
}


class IndexEntry {

    public int i;
    public int j;
    public int value;

    IndexEntry(int i, int j, int value){
        this.i = i;
        this.j = j;
        this.value  = value;

    }
}