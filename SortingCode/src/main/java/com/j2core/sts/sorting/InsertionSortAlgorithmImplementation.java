package com.j2core.sts.sorting;

/*
   The class implement insertion sort algorithm
 */
public class InsertionSortAlgorithmImplementation {

    /**
     * The method sort elements in array from smaller to bigger elements use insertion principle.
     *
     * @param array  array with not sorted numbers
     * @return  array with sorted numbers
     */
    public int[] insertionSort(int[] array){

        for (int index = 0; index < array.length-1; index++){

            if (array[index] > array[index+1]){

                int tmpValue = array[index+1];

                array[index+1] = array[index];

                int tmpIndex = index-1;

                while (tmpIndex > -1 && array[tmpIndex] > tmpValue){

                    array[tmpIndex+1] = array[tmpIndex];

                    tmpIndex--;

                }

                array[tmpIndex+1] = tmpValue;
            }
        }

        return array;
    }
}
