package com.j2core.sts.leetcode.com.tripleByte;

public class Solution {


    public static int longest_flat(int[] array) {

        if (array == null) return 0;
        if (array.length < 2) return array.length;

        int result = Integer.MIN_VALUE;
        int i = 0;
        int value = array[i++];

        while (i < array.length) {

            int counter = 1;
            while (i < array.length && value == array[i]) {
                counter++;
                i++;
            }
            result = Math.max(result, counter);
            if (i < array.length) {
                value = array[i++];
            }
        }
        return result;
    }

    public static int deletion_distance(String str1, String str2){

        if (str1.length() < 1 || str2.length() <1){
            return str1.length() < 1 ? str2.length() : str1.length();
        }

        int[][] map = new int[str1.length()+1][str2.length()+1];

        int value = 0;
        for (int k = 0; k <= str2.length(); k++){
            map[0][k] = value++;
        }

        for (int i = 1; i < str1.length()+1; i++){
            for (int j = 0; j < str2.length()+1; j++){
                if(j == 0){
                    map[i][j] = map[i-1][j]+1;
                }else {
                    if(str1.charAt(i-1) != str2.charAt(j-1)){
                        map[i][j] = Math.min(map[i-1][j], map[i][j-1])+1;
                    }else {
                        map[i][j] = map[i-1][j-1];
                    }
                }
            }
        }

        return map[str1.length()][str2.length()];
    }

    public static int bracket_match(String bracket_string){

        int result = 0;
        int counter = 0;
        for (int i = 0; i < bracket_string.length(); i++){
            if (bracket_string.charAt(i) == '('){
                counter++;
            }else {
                counter--;
            }
            if (counter < 0){
                result++;
                counter++;
            }
        }

        return counter > 0 ? counter+result : result;
    }


    public static int stock_runs(int[] prices){

        if (prices == null) return 0;
        if (prices.length < 2) return prices.length;

        int length = 1;
        int i = 0;
        while (i+1 < prices.length){

            if (prices[i] == prices[i+1]){
                i++;
            }else {
                int counter = 1;
                if (prices[i] < prices[i+1]){
                    while (i+1 < prices.length && prices[i] < prices[i+1]){
                        counter++;
                        i++;
                    }
                }else {
                    while (i+1 < prices.length && prices[i] > prices[i+1]){
                        counter++;
                        i++;
                    }
                }
                length = Math.max(length, counter);
            }

        }
        return length;
    }



}
