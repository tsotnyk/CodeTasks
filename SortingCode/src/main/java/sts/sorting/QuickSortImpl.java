package sts.sorting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QuickSortImpl {

    public void quickSort(int[] array){

        if (array != null && array.length > 1){
            sort(array, 0, array.length-1);
        }
    }

    private void sort(int[] array, int indexStart, int indexEnd){

        int left = indexStart;
        int right = indexEnd-1;
        if (indexStart < indexEnd){
            int tmp;

            while (left <= right){
                if (array[left] <= array[indexEnd]){
                    left++;
                }else if (array[right] > array[indexEnd]){
                    right--;
                }else {
                    tmp = array[right];
                    array[right] = array[left];
                    array[left] = tmp;
                    left++;
                    right--;
                }
            }

            tmp = array[left];
            array[left] = array[indexEnd];
            array[indexEnd] = tmp;

            sort(array, indexStart, left-1);
            sort(array, left+1, indexEnd);
        }
    }

    @Test
    public void test(){

        int[] array = new int[]{3,1,2};
        quickSort(array);
        Assert.assertEquals(array, new int[]{1,2,3});

        int[] array1 = new int[]{};
        quickSort(array1);
        Assert.assertEquals(array1, new int[]{});

        int[] array2 = new int[]{3};
        quickSort(array2);
        Assert.assertEquals(array2, new int[]{3});

        int[] array3 = new int[]{1,2};
        quickSort(array3);
        Assert.assertEquals(array3, new int[]{1,2});

        int[] array4 = new int[]{2,3,4,6,5,1,9,5,0,3,4,5,6,2,3,1,2};
        quickSort(array4);
        Assert.assertEquals(array4, new int[]{0,1,1,2,2,2,3,3,3,4,4,5,5,5,6,6,9});
    }
}
