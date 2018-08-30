package com.j2core.sts.leetcode.com.guessNumberHigherOrLower;

/*
   The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num);
*/

public class Solution {

    public int guessNumber(int n) {

        int start = 1;
        int stop = n;
        int median = n/2;
        int result = 0;

        while (result < 1){

            int tmpResult = isGuessNumber(start, stop, median);

            switch (tmpResult){
                case -2:
                    return start;
                case 0:
                    return median;
                case 2:
                    return stop;
                default:
                    break;
            }

            if (tmpResult < 0){
                stop = median;
            }else {
                start = median;
            }
            median = start + ((stop - start)/2);

        }
        return result;
    }


    private int isGuessNumber(int start, int stop, int median){

        if (guess(start) == 0){
            return -2;
        }else if (guess(stop) == 0){
            return 2;
        }else return guess(median);

    }

    public int guess(int n){

        return 0;
    }

}
