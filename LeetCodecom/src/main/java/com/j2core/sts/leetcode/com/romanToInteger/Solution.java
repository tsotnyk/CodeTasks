package com.j2core.sts.leetcode.com.RomanToInteger;

/**
 * The class convert roman numeral it to an integer.
 */
public class Solution {

    /**
     * The method convert roman numeral it to an integer
     *
     * @param s     numeral for convert
     * @return      converted number
     */
    public int romanToInt(String s) {
        int result = 0;
        char[] arrayChar = s.toCharArray();
        int[] numbers = new int[arrayChar.length];
        int index = 0;
        for (char character: arrayChar){
            int tmpNum;
            switch (character){
                case 'I':
                    tmpNum = 1;
                    break;
                case 'V':
                    tmpNum = 5;
                    break;
                case 'X':
                    tmpNum = 10;
                    break;
                case 'L':
                    tmpNum = 50;
                    break;
                case 'C':
                    tmpNum = 100;
                    break;
                case 'D':
                    tmpNum = 500;
                    break;
                case 'M':
                    tmpNum = 1000;
                    break;
                default:
                    tmpNum = -1;
                    break;
            }
            numbers[index] = tmpNum;
            index++;
        }
        for (int i = 0; i < numbers.length-1; i++){

            int tmpNum = numbers[i];
            if (tmpNum < numbers[i+1]){
                numbers[i] = tmpNum*-1;
            }
        }
        for (int num: numbers){

            result = result + num;
        }
        return result;
    }
}
