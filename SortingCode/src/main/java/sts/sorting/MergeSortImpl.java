package sts.sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MergeSortImpl {

    public int[] mergeSort(int[] array){

        if (array != null && array.length > 1){
            return sort(array, 0, array.length/2, array.length-1);
        }

        return array;
    }

    private int[] sort(int[] array, int indexStart, int indexMidl, int indexEnd){

        int[] sortArray = new int[indexEnd-indexStart+1];
        if (indexEnd > indexStart){
            int[] first = sort(array, indexStart, (indexMidl-1)/2, indexMidl-1);
            int[] second = sort(array, indexMidl, indexMidl+((indexEnd-indexMidl)/2), indexEnd);
            int indexFirst = 0;
            int indexSecond = 0;
            for (int i = 0; i < sortArray.length; i++){
                if (indexFirst == first.length){
                    sortArray[i] = second[indexSecond++];
                }else if (indexSecond == second.length){
                    sortArray[i] = first[indexFirst++];
                }else {
                    if (first[indexFirst] < second[indexSecond]){
                        sortArray[i] = first[indexFirst++];
                    }else {
                        sortArray[i] = second[indexSecond++];
                    }
                }
            }
        }else {
            for (int i = 0; i < sortArray.length; i++){
                sortArray[i] = array[indexStart++];
            }
        }

        return sortArray;
    }

    @Test
    public void test(){

        Assert.assertEquals(mergeSort(null), null);
        Assert.assertEquals(mergeSort(new int[]{}), new int[]{});
        Assert.assertEquals(mergeSort(new int[]{1}), new int[]{1});
        Assert.assertEquals(mergeSort(new int[]{2,1}), new int[]{1,2});
        Assert.assertEquals(mergeSort(new int[]{2,3,1}), new int[]{1,2,3});
        Assert.assertEquals(mergeSort(new int[]{2,4,3,1}), new int[]{1,2,3,4});
        Assert.assertEquals(mergeSort(new int[]{2,4,3,1,5}), new int[]{1,2,3,4,5});
        Assert.assertEquals(mergeSort(new int[]{2,4,3,1,3,6,4,7,8,9,4,2,4,5,2,0,5}), new int[]{0,1,2,2,2,3,3,4,4,4,4,5,5,6,7,8,9});


    }
}
