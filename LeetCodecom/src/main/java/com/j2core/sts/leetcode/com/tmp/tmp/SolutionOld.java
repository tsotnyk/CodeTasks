package com.j2core.sts.leetcode.com.tmp.tmp;

public class SolutionOld {

// array with numbers
    // must to have result for all numbers = 1 (like num1*num2*..*numN = 1);
    public int costChangeDP(int[] array){


        int smaller = 0;
        int bigger = 0;

        for(int num : array){

            int toOne = Math.abs(num-1);
            int toMinusOne = Math.abs(-1-num);
            smaller = Math.min(smaller+toOne, bigger+toMinusOne);
            bigger = Math.min(smaller+toMinusOne, bigger+toOne);

        }

        return bigger;
    }



    public int costChangeGreedy(int[] array) {

        int indexNegative = -1;
        int index = 0;
        int[] result = new int[array.length];

        while(index < array.length){

            if(array[index] > 0){
                result[index] = array[index]-1;
            }else{
                if(indexNegative == -1){
                    indexNegative = index;
                }else{
                    result[indexNegative] = Math.abs(array[index]+1);
                    result[index] = Math.abs(array[index]+1);
                    indexNegative = -1;
                }
            }
            index++;
        }

        if(indexNegative != -1){
            result[indexNegative] = Math.abs(array[indexNegative]-1);
        }

        int sum = 0;
        for(int num : result){
            sum += num;
        }

        return sum;
    }

}
