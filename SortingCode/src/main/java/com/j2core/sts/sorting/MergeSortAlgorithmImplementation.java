package sorting;

/*
   The class implement merge sort algorithm
 */
public class MergeSortAlgorithmImplementation {

    /**
     * The method sort elements in array from smaller to bigger elements use merge two sorted array's principle.
     *
     * @param array  array with not sorted numbers
     * @return  array with sorted numbers
     */
    public int[] mergeSort(int[] array){

        if (array.length < 2) return array;

        int[] result = {array[0]};
        for (int i = 1; i< array.length; i++){

            int [] tmpArray = new int[result.length + 1];
            boolean flag = false;

            for (int j = 0; j < result.length; j++){

                if (array[i] < result[j]){

                    if (j != 0){
                        System.arraycopy(result, 0, tmpArray, 0, j);
                        tmpArray[j] = array[i];
                        System.arraycopy(result, j, tmpArray, j+1, result.length-j);
                        flag = true;
                        break;

                    }else {
                        tmpArray[j] = array[i];
                        System.arraycopy(result, 0, tmpArray, j+1, result.length);
                        flag = true;
                        break;

                    }
                }
            }
            if (!flag){

                System.arraycopy(result, 0, tmpArray, 0, result.length);
                tmpArray[tmpArray.length - 1] = array[i];

            }
            result = tmpArray;
        }

        return result;

    }
}
