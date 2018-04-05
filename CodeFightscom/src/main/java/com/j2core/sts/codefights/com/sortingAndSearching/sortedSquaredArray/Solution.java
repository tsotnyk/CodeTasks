package com.j2core.sts.codefights.com.sortingAndSearching.sortedSquaredArray;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    int[] sortedSquaredArray(int[] array) {

        for (int i = 0; i < array.length; i++){

            array[i] = array[i] * array[i];

        }

        sortNum(array);

        return array;
    }


    private int[] sortNum(int[] array){


        List<Integer> pivotIndexList = new LinkedList<Integer>();
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int tmp;

        if (array.length > 2) {

            int tmpFirstIndex;
            int tmpLastIndex;

            do {

                if (pivotIndexList.isEmpty()) {

                    tmpFirstIndex = firstIndex;
                    tmpLastIndex = lastIndex;

                } else {

                    int tmpPivot = pivotIndexList.get(pivotIndexList.size() - 1);

                    if (tmpPivot > firstIndex && tmpPivot < lastIndex) {

                        tmpFirstIndex = firstIndex;
                        tmpLastIndex = tmpPivot - 1;

                    } else {

                        if (tmpPivot == firstIndex) {
                            firstIndex++;
                        } else if (tmpPivot == lastIndex) {
                            lastIndex--;
                        }

                        pivotIndexList.remove(pivotIndexList.size() - 1);
                        tmpFirstIndex = firstIndex;

                        if (pivotIndexList.isEmpty()) {
                            tmpLastIndex = lastIndex;
                        } else {

                            tmpLastIndex = pivotIndexList.get(pivotIndexList.size() - 1) - 1;
                        }
                    }
                }

                tmp = findPivotPositionQuickSort(array, tmpLastIndex, tmpFirstIndex);
                pivotIndexList.add(tmp);

                if (tmp == -1) {

                    pivotIndexList.remove(pivotIndexList.size() - 1);
                    firstIndex = tmpLastIndex + 1;

                }

            } while (!pivotIndexList.isEmpty());

        } else if (array.length == 2) {

            if (array[0] > array[1]) {

                tmp = array[0];
                array[0] = array[1];
                array[1] = tmp;

            }
        }

        return array;
    }

    private int findPivotPositionQuickSort(int[] array, int pivot, int index){

        int tmpValue;
        int tmpIndex = index - 1;

        if (((pivot - index) + 1) > 2) {

            for (; index < pivot; index++) {

                if (array[index] < array[pivot]) {

                    tmpIndex++;
                    tmpValue = array[index];
                    array[index] = array[tmpIndex];
                    array[tmpIndex] = tmpValue;

                }
            }

            tmpValue = array[pivot];
            System.arraycopy(array, tmpIndex + 1, array, tmpIndex + 2, index - 1 - tmpIndex);
            array[tmpIndex + 1] = tmpValue;

            return tmpIndex+1;

        } else if (((pivot - index) + 1) < 2){

            return -1;
        }else {

            if (array[index] > array[pivot]) {

                tmpValue = array[index];
                array[index] = array[pivot];
                array[pivot] = tmpValue;

            }

            return -1;
        }
    }
}
