package sorting;

/*
   The class implement bubble sort algorithm
 */
public class BubbleSortAlgorithmImplementation {

    /**
     * The method sort elements in array from smaller to bigger elements use bubble principle.
     *
     * @param array  array with not sorted numbers
     * @return  array with sorted numbers
     */
    public int[] bubbleSort(int[] array){

        int cycleIndex = array.length - 1;

        while (cycleIndex > 0){

            for (int i = 0; i < cycleIndex; i++){

                if (array[i] > array[i+1]){

                    int tmpValue = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmpValue;

                }
            }

            cycleIndex--;
        }

        return array;
    }
}
