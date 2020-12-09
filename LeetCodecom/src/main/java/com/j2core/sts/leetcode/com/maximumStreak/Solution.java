package com.j2core.sts.leetcode.com.maximumStreak;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

    public int maxStreak(String[] records) {

        int counter = 0;
        int tmpCounter = 0;
        for (String day : records){
            boolean allWorkers = true;
            for (char employee : day.toCharArray()){
                if (employee == 'N') {
                    allWorkers = false;
                    break;
                }
            }
            if (allWorkers){
                tmpCounter++;
            }else {
                counter = Math.max(counter, tmpCounter);
                tmpCounter = 0;
            }
        }

        return counter;
    }

    @Test
    public void test(){

        Assert.assertEquals(maxStreak(new String[]{"YYY", "YYY", "YNN", "YYN", "YYN"}), 2);
        Assert.assertEquals(maxStreak(new String[]{"YN", "NN"}), 0);
        Assert.assertEquals(maxStreak(new String[]{"NYY"}), 0);
        Assert.assertEquals(maxStreak(new String[]{"YYYY", "YYYY", "YYNY", "NYYN", "YNYN"}), 2);

    }

    public static void fizzBuzz(int n) {
        // Write your code here

        for (int i = 1; i <= n; i++){

            int tree = i%3;
            int five = i%5;
            if (tree == 0 && five == 0){
                System.out.println("FizzBuzz");
            }else if (tree == 0){
                System.out.println("Fizz");
            }else if (five == 0){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }

    }

}


