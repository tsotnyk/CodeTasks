package com.j2core.sts.leetcode.com.romanToInteger;

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

    public int romanToIntNew(String number) throws Exception{

        if(number == null || number.length() < 1) throw new Exception("Uncorrect date");

        long result = 0;

        for(int i = number.length()-1; i > -1;){

            int tmpNum = 0;
            switch(number.charAt(i)){
                case 'I':
                    tmpNum = 1;
                    break;
                case 'V':
                    if(i-1 > -1 && number.charAt(i-1) == 'I'){
                        tmpNum = 4;
                        i--;
                    }else{
                        tmpNum = 5;
                    }
                    break;
                case 'X':
                    if(i-1 > -1 && number.charAt(i-1) == 'I'){
                        tmpNum = 9;
                        i--;
                    }else{
                        tmpNum = 10;
                    }
                    break;
                case 'L':
                    if(i-1 > -1 && number.charAt(i-1) == 'X'){
                        tmpNum = 40;
                        i--;
                    }else{
                        tmpNum = 50;
                    }
                    break;
                case 'C':
                    if(i-1 > -1 && number.charAt(i-1) == 'X'){
                        tmpNum = 90;
                        i--;
                    }else{
                        tmpNum = 100;
                    }
                    break;
                case 'D':
                    if(i-1 > -1 && number.charAt(i-1) == 'C'){
                        tmpNum = 400;
                        i--;
                    }else{
                        tmpNum = 500;
                    }
                    break;
                case 'M':
                    if(i-1 > -1 && number.charAt(i-1) == 'C'){
                        tmpNum = 900;
                        i--;
                    }else{
                        tmpNum = 1000;
                    }
                    break;
                default: throw new Exception("Uncorrect date");
            }
            result += tmpNum;
            i--;
        }

        return (int) result;
    }
}
