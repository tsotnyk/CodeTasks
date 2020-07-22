package com.j2core.sts.leetcode.com.tmp;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public Set<String> findMaxLengthPalindromeFromString(String text){

        String builder = new StringBuilder(text).reverse().toString();

        PalindromesObject[][] matrix = new PalindromesObject[text.length()+1][text.length()+1];

        for (PalindromesObject[] list : matrix){
            for (int i = 0; i <= text.length(); i++){
                list[i] = new PalindromesObject();
            }
        }

        for (int i = 1; i <= text.length(); i++){

            for (int j = 1; j <= text.length(); j++){

                if (builder.charAt(i-1) == text.charAt(j-1)){
                    PalindromesObject object = matrix[i-1][j-1];
                    String suffix = String.valueOf(text.charAt(j - 1));
                    if (object.palindromeList.isEmpty()){
                        matrix[i][j].palindromeList.add(suffix);
                    }else {
                        for (String str : object.palindromeList){
                            matrix[i][j].palindromeList.add(str+suffix);
                        }
                    }
                    matrix[i][j].length = object.length + 1;
                }else {
                    if (matrix[i-1][j].length > matrix[i][j-1].length){
                        matrix[i][j].palindromeList.addAll(matrix[i-1][j].palindromeList);
                        matrix[i][j].length = matrix[i-1][j].length;
                    }
                    else if (matrix[i-1][j].length < matrix[i][j-1].length){
                        matrix[i][j].palindromeList.addAll(matrix[i][j-1].palindromeList);
                        matrix[i][j].length = matrix[i][j-1].length;
                    }
                    else {
                        matrix[i][j].palindromeList.addAll(matrix[i-1][j].palindromeList);
                        matrix[i][j].palindromeList.addAll(matrix[i][j-1].palindromeList);
                        matrix[i][j].length = matrix[i-1][j].length;
                    }
                }
            }
        }

        return matrix[text.length()][text.length()].palindromeList;
    }

    class PalindromesObject{

        int length = 0;
        Set<String> palindromeList;

        public PalindromesObject() {
            this.palindromeList = new HashSet<>();
        }
    }


    @Test
    public void test(){

        Set<String> result = findMaxLengthPalindromeFromString("bbbcdab");

        for (String str : result){

            System.out.println(str);
        }

    }

}
