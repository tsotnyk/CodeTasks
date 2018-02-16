package com.j2core.sts.sorting;

/*
   The class implement heap sort algorithm
 */
public class HeapSortAlgorithmImplementation {

    /**
     * The method sort elements in array from smaller to bigger elements use heap principle.
     *
     * @param array  array with not sorted numbers
     * @return  array with sorted numbers
     */
    public int[] heapSort(int[] array){

        if (array == null) return null;

        if (array.length < 2) return array;

        int tmpIndex1;
        int tmpIndex2;
        int tmpValue;

        int indexLastElement = array.length - 1;
        int barrier = log2HeapSort(array.length);
        int index = indexLastElement;

        while (barrier > 0) {

            int barrierIndex = (int) Math.pow(2, barrier) - 1;
            while (index > barrierIndex) {

                if (index == indexLastElement && index % 2 != 0) {

                    tmpIndex1 = index;
                    index--;

                } else {

                    if (array[index] > array[index - 1]) {
                        tmpIndex1 = index;
                    } else {
                        tmpIndex1 = index - 1;
                    }

                    index = index - 2;
                }

                tmpIndex2 = (tmpIndex1 - 1) / 2;

                if (array[tmpIndex1] > array[tmpIndex2]) {

                    tmpValue = array[tmpIndex1];
                    array[tmpIndex1] = array[tmpIndex2];
                    array[tmpIndex2] = tmpValue;

                }

                tmpIndex2 = tmpIndex1;
                tmpIndex1 = (tmpIndex1 * 2) + 1;

                passageBranchHeapSort(array, indexLastElement, tmpIndex1, tmpIndex2);

            }

            barrier--;

        }

        while (indexLastElement > 0) {

            tmpValue = array[indexLastElement];
            array[indexLastElement] = array[0];
            array[0] = tmpValue;
            indexLastElement--;

            tmpIndex1 = 1;
            tmpIndex2 = 0;

            passageBranchHeapSort(array, indexLastElement, tmpIndex1, tmpIndex2);
        }

        return array;
    }

    /**
     * The method calculates logarithm with base 2
     *
     * @param data   number
     * @return      calculates logarithm's result
     */
    private int log2HeapSort(int data){

        int result = 0;

        while ((data >>= 1) != 0){

            result++;
        }
        return result;
    }

    /**
     * The method sorts numbers in existing range
     *
     * @param array                    array with not sorted numbers
     * @param indexLastElement         last element's index in array
     * @param firstIndex               first number's index for start passage branch
     * @param supportingElementIndex   supporting element's index
     */
    private void passageBranchHeapSort(int[] array, int indexLastElement, int firstIndex, int supportingElementIndex){

        int tmpValue;

        while (firstIndex <= indexLastElement) {
            if (firstIndex != indexLastElement) {

                if (array[firstIndex] < array[firstIndex + 1]) {

                    firstIndex = firstIndex + 1;
                }
            }
            if (array[firstIndex] > array[supportingElementIndex]) {

                tmpValue = array[firstIndex];
                array[firstIndex] = array[supportingElementIndex];
                array[supportingElementIndex] = tmpValue;
            }

            supportingElementIndex = firstIndex;
            firstIndex = (firstIndex * 2) + 1;
        }
    }
}
