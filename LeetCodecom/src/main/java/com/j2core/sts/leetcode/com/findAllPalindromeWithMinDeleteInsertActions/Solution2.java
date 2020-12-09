package com.j2core.sts.leetcode.com.findAllPalindromeWithMinDeleteInsertActions;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {

    public List<String> findAllPalindromeWithDeleteInsertActions(String word) {

        String reversWord = new StringBuilder(word).reverse().toString();
        OptionObject[][] matrix = new OptionObject[word.length()+1][word.length()+1];

        addFirstLines(matrix, word, reversWord);

        for (int i = 1; i <= word.length(); i++){
            for (int j = 1; j <= word.length(); j++){
                if (word.charAt(j-1) == reversWord.charAt(i-1)){
                    addSimilarSymbol(i, j, matrix, word.charAt(j-1));
                }else {
                    addVariantActions(i, j, matrix, word.charAt(j-1), reversWord.charAt(i-1));
                }
            }
        }

        return getPalindromeList(matrix[word.length()][word.length()]);
    }

    private List<String> getPalindromeList(OptionObject object){

        List<String> result = new LinkedList<>();

        for (String word : object.uniqString){
            if (isPalindrome(word)){
                result.add(word);
            }
        }
        return result;
    }

    private boolean isPalindrome(String word){

        int indexStart = 0;
        int indexEnd = word.length()-1;

        // this word is palindrome or not
        while (indexStart < indexEnd){

            if (word.charAt(indexStart) != word.charAt(indexEnd)) return false;
            indexStart++;
            indexEnd--;
        }

        return true;
    }

    private void addSimilarSymbol(int i, int j, OptionObject[][] matrix, char symbol){
        OptionObject newObject = new OptionObject();
        newObject.action = matrix[i-1][j-1].action;
        for (String option : matrix[i-1][j-1].uniqString){
            newObject.uniqString.add(option + symbol);
        }
        matrix[i][j] = newObject;
    }

    private void addVariantActions(int i, int j, OptionObject[][] matrix, char word, char revers){

        OptionObject object = new OptionObject();

        if (matrix[i-1][j].action == matrix[i][j-1].action){
            addSetOptions(object, matrix[i-1][j], revers);
            addSetOptions(object, matrix[i][j-1], word);
            object.action = matrix[i-1][j].action + 1;
        }
        else if (matrix[i-1][j].action < matrix[i][j-1].action){
            addSetOptions(object, matrix[i-1][j], revers);
            object.action = matrix[i-1][j].action + 1;
        }else {
            addSetOptions(object, matrix[i][j-1], word);
            object.action = matrix[i][j-1].action + 1;
        }

        matrix[i][j] = object;
    }

    private void addSetOptions(OptionObject newObject, OptionObject object, char symbol){

        for (String option : object.uniqString){
            newObject.uniqString.add(option);
            newObject.uniqString.add(option + symbol);
        }
    }

    private void addFirstLines(OptionObject[][] matrix, String word, String revers){

        for (int i = 0; i <= word.length(); i++){
            matrix[0][i] = new OptionObject();
            if (i == 0) {
                matrix[0][i].uniqString.add("");
            }else {
                matrix[0][i].action = matrix[0][i-1].action + 1;
                for (String options : matrix[0][i-1].uniqString){
                    matrix[0][i].uniqString.add(options);
                    matrix[0][i].uniqString.add(options+word.charAt(i-1));
                }
            }
        }

        for (int i = 0; i <= revers.length(); i++){
            matrix[i][0] = new OptionObject();
            if (i == 0) {
                matrix[i][0].uniqString.add("");
            }else {
                matrix[i][0].action = matrix[i-1][0].action + 1;
                for (String options : matrix[i-1][0].uniqString){
                    matrix[i][0].uniqString.add(options);
                    matrix[i][0].uniqString.add(options+revers.charAt(i-1));
                }
            }
        }
    }

    @Test
    public void test(){

        List<String> result2 = findAllPalindromeWithDeleteInsertActions("abba");

        Assert.assertEquals(result2.size(), 1);
        for (String palindrome : result2){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  abba");

        List<String> result3 = findAllPalindromeWithDeleteInsertActions("baac");

        Assert.assertEquals(result3.size(), 5);
        for (String palindrome : result3){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  aa, baab, caac, bcaacb, cbaabc");

        List<String> result4 = findAllPalindromeWithDeleteInsertActions("ababcac");

        Assert.assertEquals(result4.size(), 4);
        for (String palindrome : result4){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  ababa, acbabca, cababac, cacbabcac");

        List<String> result5 = findAllPalindromeWithDeleteInsertActions("");

        Assert.assertEquals(result5.size(), 1);
        for (String palindrome : result5){
            System.out.println(palindrome);
        }
        System.out.println( "  == > only empty string");

        List<String> result6 = findAllPalindromeWithDeleteInsertActions("a");

        Assert.assertEquals(result6.size(), 1);
        for (String palindrome : result6){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  a");

        List<String> result7 = findAllPalindromeWithDeleteInsertActions("aa");

        Assert.assertEquals(result7.size(), 1);
        for (String palindrome : result7){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  aa");

        List<String> result8 = findAllPalindromeWithDeleteInsertActions("ab");

        Assert.assertEquals(result8.size(), 4);
        for (String palindrome : result8){
            System.out.println(palindrome);
        }
        System.out.println( "  == >  a, b, aba, bab");
    }

}

class OptionObject{

    int action;
    HashSet<String> uniqString;

    public OptionObject(){

        this.action = 0;
        this.uniqString = new HashSet<>();
    }
}
