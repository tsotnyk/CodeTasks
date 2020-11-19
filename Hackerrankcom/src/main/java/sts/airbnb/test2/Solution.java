package sts.airbnb.test2;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static int maxIndex(int steps, int badIndex) {
        // Write your code here
        boolean findBadIndex;
        int startJ = 0;
        int i;
        do {
            findBadIndex = false;
            startJ++;
            i = 0;
            int j = startJ;
            int counter = 0;
            while (counter++ < steps){
                i = i+j;
                if (i == badIndex){
                    findBadIndex = true;
                    steps--;
                    break;
                }
                j++;
            }
        }while (findBadIndex);

        return i;
    }

    @Test
    public void test1(){

        Assert.assertEquals(maxIndex(4, 6), 9);
        Assert.assertEquals(maxIndex(2, 2), 3);
        Assert.assertEquals(maxIndex(2, 1), 2);
        Assert.assertEquals(maxIndex(3, 3), 5);

    }

    public static List<Integer> commonPrefix(List<String> inputs) {
        // Write your code here
        List<Integer> outputList = new LinkedList<>();
        for (String word : inputs){
            int prefixLengthSum = word.length();
            for (int i = 1; i < word.length(); i++){
                prefixLengthSum += commonPrefixLength(word, i);
            }
            outputList.add(prefixLengthSum);
        }

        return outputList;
    }

    private static int commonPrefixLength(String word, int indexStart){

        int prefixLength = 0;
        int index = 0;

        while (indexStart < word.length()){
            if (word.charAt(index++) != word.charAt(indexStart++)) return prefixLength;
            prefixLength++;
        }

        return prefixLength;
    }

    @Test
    public void test2(){

        Assert.assertEquals(commonPrefix(new LinkedList<>(Arrays.asList("abcabcd", "ababaa"))), new LinkedList<>(Arrays.asList(10, 11)));

    }

    public static int numPaths(List<List<Integer>> warehouse) {
        // Write your code here
        long[][] matrix = new long[warehouse.size()][warehouse.get(0).size()];
        int i = 0;
        for (List<Integer> list : warehouse){
            int j = 0;
            for (int num : list){
                if (num == 1) {
                    if (i == 0 || j == 0) {
                        if (i == 0 && j == 0){
                            matrix[i][j] = 1;
                        }else if (i != 0){
                            matrix[i][j] = matrix[i-1][j];
                        }else {
                            matrix[i][j] = matrix[i][j-1];
                        }
                    }else {
                        matrix[i][j] = (matrix[i-1][j] + matrix[i][j-1])%1000000007;
                    }
                }else {
                    if (i == 0 && j == 0) return 0;
                }
                j++;
            }
            i++;
        }

        return (int)matrix[matrix.length-1][matrix[0].length-1];
    }

    @Test
    public void test3(){

        List<List<Integer>> matrix = new LinkedList<>();
        matrix.add(new LinkedList<>(Arrays.asList(1,1,1,1)));
        matrix.add(new LinkedList<>(Arrays.asList(1,1,1,1)));
        matrix.add(new LinkedList<>(Arrays.asList(1,1,1,1)));
        Assert.assertEquals(numPaths(matrix), 10);

        List<List<Integer>> matrix1 = new LinkedList<>();
        matrix1.add(new LinkedList<>(Arrays.asList(1,1,0,1)));
        matrix1.add(new LinkedList<>(Arrays.asList(1,1,1,1)));
        Assert.assertEquals(numPaths(matrix1), 2);

        List<List<Integer>> matrix2 = new LinkedList<>();
        matrix2.add(new LinkedList<>(Arrays.asList(1,1)));
        matrix2.add(new LinkedList<>(Arrays.asList(0,1)));
        Assert.assertEquals(numPaths(matrix2), 1);
    }

    public static void calcMissing(List<String> readings) {
        // Write your code here

    }

    @Test
    public void test4(){

    }
}
