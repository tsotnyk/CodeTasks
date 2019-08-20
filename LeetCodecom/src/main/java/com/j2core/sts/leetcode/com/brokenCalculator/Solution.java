package com.j2core.sts.leetcode.com.brokenCalculator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution {

        public int brokenCalc(int X, int Y) {
            return findOperations(0, X, Y);

        }

        private int findOperations(int count, int x, int y){

            if (x >= y){

                return count+(x-y);
            }else if (y%2 == 0){
                return findOperations(++count, x, y/2);
            }else {
                return findOperations(++count, x, y+1);
            }
        }

        @Test
        public void test(){

            int one = brokenCalc(2,3);
            Assert.assertEquals(2, one);
            int two = brokenCalc(5,8);
            Assert.assertEquals(2, two);
            int three = brokenCalc(3,10);
            Assert.assertEquals(3, three);
            int four = brokenCalc(1024,1);
            Assert.assertEquals(1023, four);
            int five = brokenCalc(1 ,1000000000);
            Assert.assertEquals(39, five);

        }
}
