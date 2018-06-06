package com.j2core.sts.codefights.com.specialTopics.commonTechniquesBasic.sumOfTwo;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    boolean sumOfTwo(int[] a, int[] b, int v) {

        if (a.length < 1 || b.length < 1){

            return false;
        }else {

            a = quickSort(a);
            b = quickSort(b);
            int bLength = b.length;

            for (int anA : a) {

                long num = v - anA;

                if (num > -1000000001) {

                    if (num > b[0]) {

                        if (num <= b[bLength - 1]) {

                            int pivot = bLength / 2;
                            int indexStart;
                            int indexStop;
                            if (num < b[pivot]) {
                                indexStart = 0;
                                indexStop = pivot;
                            } else {
                                indexStart = pivot;
                                indexStop = bLength - 1;
                            }
                            for (int i = indexStart; i <= indexStop; i++) {

                                if (num == b[i]) {
                                    return true;
                                } else if (num < b[i]) break;
                            }
                        }
                    }
                }
            }

            return false;
        }
    }


    public int[] quickSort(int[] array) {

        List<Integer> pivotIndexList = new LinkedList<>();
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
