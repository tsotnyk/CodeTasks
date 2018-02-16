package com.j2core.sts.sorting;

/*
   The class implement selection sort algorithm
 */
public class SelectionSortAlgorithmImplementation {

    /**
     * The method sort elements in array from smaller to bigger elements use selection sort's principle.
     *
     * @param array  array with not sorted numbers
     * @return  array with sorted numbers
     */
    public int[] selectionSort(int[] array){

        for (int i = 0; i < array.length - 1; i++){

            int tmpValue = array[i];
            int tmpIndex = i;

            for (int j = i+1; j < array.length; j++){

                if (array[j] < tmpValue){

                    tmpValue = array[j];
                    tmpIndex = j;

                }
            }

            if (tmpIndex != i){

                array[tmpIndex] = array[i];
                array[i] = tmpValue;

            }
        }

        return array;
    }
}
