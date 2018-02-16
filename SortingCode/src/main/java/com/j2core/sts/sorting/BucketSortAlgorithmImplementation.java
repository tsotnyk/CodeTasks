package com.j2core.sts.sorting;

import java.util.*;
import java.util.stream.Collectors;

/*
   The class implement bucket sort algorithm
 */
public class BucketSortAlgorithmImplementation {

    /**
     * The method sort elements in array from smaller to bigger elements use bucket principle.
     *
     * @param array  array with not sorted numbers
     * @return  array with sorted numbers
     */
    public int[] bucketSort(int[] array){

        if (array.length > 1) {

            List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());
            Integer maxElement = array[0];

            for (int k = 1; k < array.length; k++) {
                if (maxElement < array[k]) {
                    maxElement = array[k];
                }
            }

            int exponent = maxElement.toString().length();
            Map<Integer, List<Integer>> preCollection = preSortBucketSort(arrayList, exponent - 1, 0);

            if (preCollection != null) {

                if (exponent > 1) {

                    for (int i = 0; i < 10; i++) {

                        List<Integer> integerList = preCollection.get(i);
                        List<Integer> sortedList;

                        if (integerList.size() > 1) {

                            int tmpExponent = exponent - 1;
                            int baseDelta = (int) (i * Math.pow(10, tmpExponent));
                            List<Map<Integer, List<Integer>>> preSortCollection = sortOneBucket(integerList, tmpExponent, i, baseDelta);

                            if (preSortCollection.size() > 1) {

                                sortedList = mergeCollectionBucketSort(preSortCollection);

                            } else {

                                sortedList = new LinkedList<>();
                                Map<Integer, List<Integer>> tmpMap = preSortCollection.get(0);

                                for (int k = 0; k < 10; k++) {

                                    sortedList.addAll(tmpMap.get(k));
                                }
                            }
                            preCollection.put(i, sortedList);
                        }
                    }
                }

                List<Integer> result = new LinkedList<>();

                for (int i = 0; i < 10; i++) {
                    result.addAll(preCollection.get(i));
                }

                return changeStructureBucketSort(result);
            }
        }

        return array;

    }

    /**
     * The method sort numbers from one bucket
     *
     * @param integerList       existing data
     * @param numberExponent    number's exponent
     * @param baseNumeric       base numeric with sorting
     * @param baseDelta         number's delta, which is not taken into account when sorting
     * @return   collection with sorted number's collections
     */
    private List<Map<Integer, List<Integer>>> sortOneBucket(List<Integer> integerList, int numberExponent, int baseNumeric, int baseDelta){

        List<Map<Integer, List<Integer>>> tmp = new LinkedList<>();
        tmp.add(preSortBucketSort(integerList, numberExponent - 1, baseDelta));

        numberExponent--;
        int collectionIndex = 0;
        int counter = 1;

        while (numberExponent > 0) {

            int tmpDelta;
            int delta;

            for (int n = 0; n < counter; n++) {

                tmpDelta = (int) (baseDelta + (n * Math.pow(10, numberExponent + 1)));

                if (tmp.get(collectionIndex) != null) {

                    for (int j = 0; j < 10; j++) {
                        delta = tmpDelta + (int) (j * Math.pow(10, numberExponent));
                        tmp.add(preSortBucketSort(tmp.get(collectionIndex).get(j), numberExponent - 1, delta));
                    }
                } else {

                    for (int r = 0; r < 10; r++) {
                        tmp.add(null);
                    }
                }
                collectionIndex++;
            }

            numberExponent--;
            counter = counter * 10;
        }

        return tmp;
    }

    /**
     * The method sorts collection by number's exponent
     *
     * @param data        number's collection
     * @param exponent    number's exponent for sort
     * @param delta       number's delta, which is not taken into account when sorting
     * @return   collection with sorted numbers
     */
    private Map<Integer, List<Integer>> preSortBucketSort(List<Integer> data, int exponent, int delta){

        if (data.size() > 0) {

            Map<Integer, List<Integer>> result = new HashMap<>();
            int denominator = (int) Math.pow(10, exponent);

            for (int k = 0; k < 10; k++) {

                result.put(k, new LinkedList<>());

            }

            for (Integer number : data) {

                result.get((number - delta) / (denominator)).add(number);

            }
            return result;

        }else return null;
    }

    /**
     * The method merge sorted numbers in resulting collection
     *
     * @param data  list with sorted number's collections
     * @return      collection with sorted numbers
     */
    private List<Integer> mergeCollectionBucketSort(List<Map<Integer, List<Integer>>> data){

        List<Integer> result = new LinkedList<>();

        int indexExponent = 0;
        int index = 0;
        int tmpIndex = 0;

        while (tmpIndex * 10 < data.size()-1) {

            tmpIndex = (int) (tmpIndex + (Math.pow(10, indexExponent)));
            indexExponent++;
        }

        for (int h = 1; h < 11; h++) {

            if (index > data.size()-1) break;

            index = h;

            if (data.size() > 11) {

                int baseIndex = 0;

                for (int l = 0; l < indexExponent-1; l++){

                    baseIndex = (int) (baseIndex + Math.pow(10, l));
                }

                index = (int) (h*Math.pow(10, indexExponent - 1) + baseIndex);
            }
            for (int c = 0; c < Math.pow(10, indexExponent-1); c++) {

                Map<Integer, List<Integer>> tmpMap = data.get(index);

                if (tmpMap != null) {
                    for (int k = 0; k < 10; k++) {

                        result.addAll(tmpMap.get(k));

                    }
                }
                index++;
            }
        }
        return result;
    }

    /**
     * The method change data's structure from collection to array
     *
     * @param collection   data's collection
     * @return     data's array
     */
    private int[] changeStructureBucketSort(List<Integer> collection){

        int[] result = new int[collection.size()];

        int index = 0;
        for (Integer value : collection){

            result[index] = value;
            index++;

        }

        return result;
    }
}
