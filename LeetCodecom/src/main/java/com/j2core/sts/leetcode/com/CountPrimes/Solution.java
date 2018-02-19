package com.j2core.sts.leetcode.com.CountPrimes;

/**
 * The class count the number of prime numbers less than a non-negative number
 */
public class Solution {

    /**
     * The method count the number of prime numbers less than a non-negative number
     *
     * @param n     // non-negative number
     * @return      count's result
     */
    public int countPrimes(int n) {
        int counter;
        switch (n){
            case 0: case 1: case 2:
                counter = 0;
                break;
            case 3:
                counter = 1;
                break;
            case 4: case 5:
                counter = 2;
                break;
            case 6: case 7:
                counter = 3;
                break;
            default:
                boolean flag;
                counter = 4;
                for (int i = 8; i < n; i++){
                    flag = true;
                    if (i%2 == 0 || i%10 == 5){
                        flag = false;
                    }else {
                        int bar = (int) (Math.sqrt(i) + 1);
                        for (int j = 3; j < bar; j = j+2){
                            if (i%j == 0){
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag){
                        counter++;
                    }
                }
        }

        return counter;
    }
}
