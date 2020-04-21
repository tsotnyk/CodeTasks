package com.j2core.sts.leetcode.com;

import org.testng.Assert;

import java.util.*;

public class Test {

    public int findUnsortedSubarray(int[] nums) {

        int indexStart = 0;
        int numStart = nums[0];
        int indexEnd = nums.length-1;
        int numEnd = nums[indexEnd];

        while (indexStart+1 < nums.length && nums[indexStart+1] > nums[indexStart]){
            indexStart++;
            numStart = nums[indexStart];
        }

        if (indexStart == nums.length-1) return 0;

        for (int i = indexStart+1; i < nums.length; i++){

            if (nums[i] < numStart){
                if (indexStart == 0){
                    break;
                }else {
                    i--;
                    indexStart--;
                    numStart = nums[indexStart];
                }
            }
        }

        while (indexEnd > indexStart && nums[indexEnd-1] < nums[indexEnd]){
            indexEnd--;
            numEnd = nums[indexEnd];
        }

        for (int j = indexEnd-1; j > indexStart; j--){

            if (nums[j] > numEnd) {
                if (indexEnd == nums.length - 1) {
                    break;
                } else {
                    j++;
                    indexEnd++;
                    numEnd = nums[indexEnd];
                }
            }
        }

        return indexEnd-indexStart-1;
    }



    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        int i;
        for (i = 0; i< nums.length; i++){
            if (nums[i] != i){
                break;
            }
        }

        return i;
    }

    @org.testng.annotations.Test
    public void test(){

        Assert.assertEquals(findUnsortedSubarray(new int[]{2,1}), 0);

    }

    /*
    Вам дан целочисленный массив A. Из некоторого начального индекса вы можете сделать серию переходов. (1-й, 3-й, 5-й, ...)
    прыжки в серии называются прыжками с нечетным номером, а (2-й, 4-й, 6-й, ...) прыжки в серии называются прыжками с четными номерами.

Вы можете перейти от индекса i к индексу j (с i <j) следующим образом:

Во время прыжков с нечетным номером (т. Е. Прыжков 1, 3, 5, ...) вы переходите к индексу j так, что A [i] <= A [j] и A [j] -
наименьшее возможное значение. Если существует несколько таких индексов j, вы можете перейти только к наименьшему такому индексу j.
Во время прыжков с четными номерами (т. Е. Прыжков 2, 4, 6, ...) вы переходите к индексу j так, что A [i]> = A [j] и A [j] -
максимально возможное значение. Если существует несколько таких индексов j, вы можете перейти только к наименьшему такому индексу j.
(Может случиться так, что для некоторого индекса i нет никаких законных скачков.)
Начальный индекс хорош, если, начиная с этого индекса, вы можете достичь конца массива (индекс A.length - 1), перепрыгивая
несколько раз (возможно, 0 или более одного раза).

Вернуть количество хороших стартовых индексов.
     */

}


