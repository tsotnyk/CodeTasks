package com.j2core.sts.leetcode.com.max.maximumSwap;

/*
   The class change two digits at most once to get the maximum valued number.
 */
public class Solution {

    /**
     * The method could swap two digits at most once to get the maximum valued number.
     *
     * @param num     number for change
     * @return        maximum value number
     */
    public int maximumSwap(int num) {
        int result = num;
        char[] array = Integer.toString(num).toCharArray();
        if (array.length < 2) return num;
        int maxValue = -1;
        int maxIndex = 0;
        int step = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length; j++ ){
                int value = Character.getNumericValue(array[j]);
                if (value > maxValue){
                    maxValue = value;
                    maxIndex = j;
                }else if (value == maxValue && j > maxIndex && maxIndex != i){
                    maxIndex = j;
                    i++;
                }
            }
            if (maxIndex == i){
                step = i + 1;
            }else  if (maxIndex > i){
                break;
            }
            maxIndex = 0;
            maxValue = -1;
        }
        if (step < array.length-1) {
            char tmp = array[step];
            array[step] = array[maxIndex];
            array[maxIndex] = tmp;
            StringBuilder builder = new StringBuilder();
            for (char number : array) {
                builder.append(number);
            }
            try {
                result = Integer.parseInt(builder.toString());
            } catch (Exception ex) {

                ex.getStackTrace();
            }
        }
        return result;
    }
}
