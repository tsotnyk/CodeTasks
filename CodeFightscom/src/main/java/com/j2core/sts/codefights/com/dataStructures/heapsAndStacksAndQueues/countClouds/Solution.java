package com.j2core.sts.codefights.com.dataStructures.heapsAndStacksAndQueues.countClouds;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    int countClouds(char[][] skyMap) {

        if (skyMap.length < 1) return 0;

        int countClouds = 0;

        for (int i = 0; i < skyMap.length; i++){

            for (int j = 0; j < skyMap[i].length; j++){

                if (skyMap[i][j] == '1'){

                    countClouds++;

                    clearClouds(skyMap, new MatrixIndex(i, j));

                }
            }
        }

        return countClouds;

    }

    private void clearClouds(char[][] skyMap, MatrixIndex index){

        List<MatrixIndex> indexList = new LinkedList<>();
        int i = index.i;
        int j = index.j;

        skyMap[i][j] = '0';

        if (i-1 > -1 && skyMap[i-1][j] == '1'){
            indexList.add(new MatrixIndex(i-1, j));
        }
        if (i+1 < skyMap.length && skyMap[i+1][j] == '1'){
            indexList.add(new MatrixIndex(i+1, j));
        }
        if (j-1 > -1 && skyMap[i][j-1] == '1'){
            indexList.add(new MatrixIndex(i, j-1));
        }
        if (j+1 < skyMap[i].length && skyMap[i][j+1] == '1'){
            indexList.add(new MatrixIndex(i, j+1));
        }

        for (MatrixIndex matrixIndex : indexList){

            clearClouds(skyMap, matrixIndex);

        }

    }

    class MatrixIndex{

        int i;
        int j;

        public MatrixIndex(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }
}
